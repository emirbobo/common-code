package org.webrtc;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.FloatBuffer;
import java.util.concurrent.LinkedBlockingQueue;

class VideoRendererGui$YuvImageRenderer
  implements VideoRenderer.Callbacks
{
  private long copyTimeNs;
  private long drawTimeNs;
  LinkedBlockingQueue<VideoRenderer.I420Frame> frameToRenderQueue;
  private int framesDropped;
  private int framesReceived;
  private int framesRendered;
  private int id;
  private boolean mirror;
  private int oesProgram;
  private int oesTexture = -1;
  private VideoRendererGui.YuvImageRenderer.RendererType rendererType;
  private VideoRendererGui.ScalingType scalingType;
  private int screenHeight;
  private int screenWidth;
  boolean seenFrame;
  private float[] stMatrix = new float[16];
  private long startTimeNs = -1L;
  private GLSurfaceView surface;
  private float texBottom;
  private float texLeft;
  private float texRight;
  private float texTop;
  private FloatBuffer textureCoords;
  private VideoRenderer.I420Frame textureFrameToRender;
  private FloatBuffer textureVertices;
  private final Object updateTextureLock = new Object();
  private boolean updateTextureProperties;
  private int videoHeight;
  private int videoWidth;
  private VideoRenderer.I420Frame yuvFrameToRender;
  private int yuvProgram;
  private int[] yuvTextures = { -1, -1, -1 };
  
  private VideoRendererGui$YuvImageRenderer(GLSurfaceView paramGLSurfaceView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, VideoRendererGui.ScalingType paramScalingType, boolean paramBoolean)
  {
    Log.d("VideoRendererGui", "YuvImageRenderer.Create id: " + paramInt1);
    this.surface = paramGLSurfaceView;
    this.id = paramInt1;
    this.scalingType = paramScalingType;
    this.mirror = paramBoolean;
    this.frameToRenderQueue = new LinkedBlockingQueue(1);
    this.texLeft = ((paramInt2 - 50) / 50.0F);
    this.texTop = ((50 - paramInt3) / 50.0F);
    this.texRight = Math.min(1.0F, (paramInt2 + paramInt4 - 50) / 50.0F);
    this.texBottom = Math.max(-1.0F, (50 - paramInt3 - paramInt5) / 50.0F);
    this.textureVertices = VideoRendererGui.access$000(new float[] { this.texLeft, this.texTop, this.texLeft, this.texBottom, this.texRight, this.texTop, this.texRight, this.texBottom });
    this.textureCoords = VideoRendererGui.access$000(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    this.updateTextureProperties = false;
  }
  
  private void checkAdjustTextureCoords()
  {
    if ((!this.updateTextureProperties) || (this.scalingType == VideoRendererGui.ScalingType.SCALE_FILL)) {
      return;
    }
    for (;;)
    {
      float f7;
      synchronized (this.updateTextureLock)
      {
        f3 = this.texRight;
        float f4 = this.texLeft;
        f1 = this.texTop;
        f2 = this.texBottom;
        f8 = (f3 - f4) * this.screenWidth / 2.0F;
        f5 = (f1 - f2) * this.screenHeight / 2.0F;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("ID: ");
        Log.d("VideoRendererGui", this.id + ". Display: " + f8 + " x " + f5 + ". Video: " + this.videoWidth + " x " + this.videoHeight);
        if ((f8 > 1.0F) && (f5 > 1.0F) && (this.videoWidth > 1) && (this.videoHeight > 1))
        {
          f7 = f8 / f5;
          f6 = this.videoWidth / this.videoHeight;
          if (this.scalingType != VideoRendererGui.ScalingType.SCALE_ASPECT_FIT) {
            break label586;
          }
          if (f7 > f6)
          {
            f5 = (f8 - f5 * f6) / VideoRendererGui.access$300(VideoRendererGui.access$200());
            f4 += f5;
            f5 = f3 - f5;
            f3 = f1;
            if (this.scalingType != VideoRendererGui.ScalingType.SCALE_ASPECT_FILL) {
              break label578;
            }
            if (f7 <= f6) {
              break label553;
            }
            f6 = (1.0F - f6 / f7) / 2.0F;
            f1 = 0.0F;
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("  Texture vertices: (");
            Log.d("VideoRendererGui", f4 + "," + f2 + ") - (" + f5 + "," + f3 + ")");
            this.textureVertices = VideoRendererGui.access$000(new float[] { f4, f3, f4, f2, f5, f3, f5, f2 });
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("  Texture UV offsets: ");
            Log.d("VideoRendererGui", f1 + ", " + f6);
            if (!this.mirror) {
              break label569;
            }
            f2 = 1.0F - f1;
            this.textureCoords = VideoRendererGui.access$000(new float[] { f2, f6, f2, 1.0F - f6, f1, f6, f1, 1.0F - f6 });
          }
        }
        else
        {
          this.updateTextureProperties = false;
        }
      }
      f8 /= f6;
      int i = VideoRendererGui.access$400(VideoRendererGui.access$200());
      float f8 = (f5 - f8) / i;
      float f5 = f3;
      f2 += f8;
      float f3 = f1 - f8;
      continue;
      label553:
      float f1 = (1.0F - f7 / f6) / 2.0F;
      float f6 = 0.0F;
      continue;
      label569:
      float f2 = f1;
      f1 = 1.0F - f1;
      continue;
      label578:
      f6 = 0.0F;
      f1 = 0.0F;
      continue;
      label586:
      f5 = f3;
      f3 = f1;
    }
  }
  
  private void createTextures(int paramInt1, int paramInt2)
  {
    Log.d("VideoRendererGui", "  YuvImageRenderer.createTextures " + this.id + " on GL thread:" + Thread.currentThread().getId());
    this.yuvProgram = paramInt1;
    this.oesProgram = paramInt2;
    GLES20.glGenTextures(3, this.yuvTextures, 0);
    for (paramInt1 = 0; paramInt1 < 3; paramInt1++)
    {
      GLES20.glActiveTexture(33984 + paramInt1);
      GLES20.glBindTexture(3553, this.yuvTextures[paramInt1]);
      GLES20.glTexImage2D(3553, 0, 6409, 128, 128, 0, 6409, 5121, null);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    VideoRendererGui.access$100();
  }
  
  private void draw()
  {
    if (!this.seenFrame) {}
    for (;;)
    {
      return;
      checkAdjustTextureCoords();
      long l = System.nanoTime();
      int j;
      synchronized (this.frameToRenderQueue)
      {
        VideoRenderer.I420Frame localI420Frame = (VideoRenderer.I420Frame)this.frameToRenderQueue.peek();
        if ((localI420Frame != null) && (this.startTimeNs == -1L)) {
          this.startTimeNs = l;
        }
        if (this.rendererType == VideoRendererGui.YuvImageRenderer.RendererType.RENDERER_YUV)
        {
          GLES20.glUseProgram(this.yuvProgram);
          i = 0;
          if (i < 3)
          {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, this.yuvTextures[i]);
            if (localI420Frame != null)
            {
              if (i != 0) {
                break label160;
              }
              j = localI420Frame.width;
              label118:
              if (i != 0) {
                break label171;
              }
            }
            label160:
            label171:
            for (int k = localI420Frame.height;; k = localI420Frame.height / 2)
            {
              GLES20.glTexImage2D(3553, 0, 6409, j, k, 0, 6409, 5121, localI420Frame.yuvPlanes[i]);
              i++;
              break;
              j = localI420Frame.width / 2;
              break label118;
            }
          }
        }
        else
        {
          GLES20.glUseProgram(this.oesProgram);
          if (localI420Frame != null)
          {
            this.oesTexture = localI420Frame.textureId;
            if ((localI420Frame.textureObject instanceof SurfaceTexture))
            {
              SurfaceTexture localSurfaceTexture = (SurfaceTexture)localI420Frame.textureObject;
              localSurfaceTexture.updateTexImage();
              localSurfaceTexture.getTransformMatrix(this.stMatrix);
            }
          }
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, this.oesTexture);
        }
        if (localI420Frame != null) {
          this.frameToRenderQueue.poll();
        }
        if (this.rendererType == VideoRendererGui.YuvImageRenderer.RendererType.RENDERER_YUV)
        {
          GLES20.glUniform1i(GLES20.glGetUniformLocation(this.yuvProgram, "y_tex"), 0);
          GLES20.glUniform1i(GLES20.glGetUniformLocation(this.yuvProgram, "u_tex"), 1);
          GLES20.glUniform1i(GLES20.glGetUniformLocation(this.yuvProgram, "v_tex"), 2);
        }
        j = GLES20.glGetAttribLocation(this.yuvProgram, "in_pos");
        if (j == -1) {
          throw new RuntimeException("Could not get attrib location for in_pos");
        }
      }
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 0, this.textureVertices);
      int i = GLES20.glGetAttribLocation(this.yuvProgram, "in_tc");
      if (i == -1) {
        throw new RuntimeException("Could not get attrib location for in_tc");
      }
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.textureCoords);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(j);
      GLES20.glDisableVertexAttribArray(i);
      VideoRendererGui.access$100();
      if (localObject != null)
      {
        this.framesRendered += 1;
        this.drawTimeNs += System.nanoTime() - l;
        if (this.framesRendered % 150 == 0) {
          logStatistics();
        }
      }
    }
  }
  
  private void logStatistics()
  {
    long l = System.nanoTime() - this.startTimeNs;
    Log.d("VideoRendererGui", "ID: " + this.id + ". Type: " + this.rendererType + ". Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered);
    if ((this.framesReceived > 0) && (this.framesRendered > 0))
    {
      Log.d("VideoRendererGui", "Duration: " + (int)(l / 1000000.0D) + " ms. FPS: " + this.framesRendered * 1.0E9D / l);
      Log.d("VideoRendererGui", "Draw time: " + (int)(this.drawTimeNs / (this.framesRendered * 1000)) + " us. Copy time: " + (int)(this.copyTimeNs / (this.framesReceived * 1000)) + " us");
    }
  }
  
  public void renderFrame(VideoRenderer.I420Frame paramI420Frame)
  {
    long l1;
    for (;;)
    {
      Object localObject;
      try
      {
        l1 = System.nanoTime();
        this.framesReceived += 1;
        if ((this.yuvFrameToRender == null) || (this.textureFrameToRender == null))
        {
          this.framesDropped += 1;
          return;
        }
        if (!paramI420Frame.yuvFrame) {
          break label240;
        }
        if ((paramI420Frame.yuvStrides[0] != paramI420Frame.width) || (paramI420Frame.yuvStrides[1] != paramI420Frame.width / 2) || (paramI420Frame.yuvStrides[2] != paramI420Frame.width / 2))
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>("Incorrect strides ");
          Log.e("VideoRendererGui", paramI420Frame.yuvStrides[0] + ", " + paramI420Frame.yuvStrides[1] + ", " + paramI420Frame.yuvStrides[2]);
          continue;
        }
        if (paramI420Frame.width != this.yuvFrameToRender.width) {
          break label190;
        }
      }
      finally {}
      if (paramI420Frame.height != this.yuvFrameToRender.height)
      {
        label190:
        localObject = new java/lang/RuntimeException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Wrong frame size ");
        ((RuntimeException)localObject).<init>(paramI420Frame.width + " x " + paramI420Frame.height);
        throw ((Throwable)localObject);
      }
      label240:
      if (this.frameToRenderQueue.size() <= 0) {
        break;
      }
      this.framesDropped += 1;
    }
    if (paramI420Frame.yuvFrame)
    {
      this.yuvFrameToRender.copyFrom(paramI420Frame);
      this.rendererType = VideoRendererGui.YuvImageRenderer.RendererType.RENDERER_YUV;
      this.frameToRenderQueue.offer(this.yuvFrameToRender);
    }
    for (;;)
    {
      long l2 = this.copyTimeNs;
      this.copyTimeNs = (System.nanoTime() - l1 + l2);
      this.seenFrame = true;
      this.surface.requestRender();
      break;
      this.textureFrameToRender.copyFrom(paramI420Frame);
      this.rendererType = VideoRendererGui.YuvImageRenderer.RendererType.RENDERER_TEXTURE;
      this.frameToRenderQueue.offer(this.textureFrameToRender);
    }
  }
  
  public void setPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoRendererGui.ScalingType paramScalingType)
  {
    Object localObject = this.updateTextureLock;
    float f = (paramInt1 - 50) / 50.0F;
    try
    {
      this.texLeft = f;
      this.texTop = ((50 - paramInt2) / 50.0F);
      this.texRight = Math.min(1.0F, (paramInt1 + paramInt3 - 50) / 50.0F);
      this.texBottom = Math.max(-1.0F, (50 - paramInt2 - paramInt4) / 50.0F);
      this.scalingType = paramScalingType;
      this.updateTextureProperties = true;
      return;
    }
    finally
    {
      paramScalingType = finally;
      throw paramScalingType;
    }
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    synchronized (this.updateTextureLock)
    {
      this.screenWidth = paramInt1;
      this.screenHeight = paramInt2;
      this.updateTextureProperties = true;
      return;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    Log.d("VideoRendererGui", "ID: " + this.id + ". YuvImageRenderer.setSize: " + paramInt1 + " x " + paramInt2);
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    int i = paramInt1 / 2;
    int j = paramInt1 / 2;
    synchronized (this.frameToRenderQueue)
    {
      this.frameToRenderQueue.poll();
      VideoRenderer.I420Frame localI420Frame = new org/webrtc/VideoRenderer$I420Frame;
      localI420Frame.<init>(paramInt1, paramInt2, new int[] { paramInt1, i, j }, null);
      this.yuvFrameToRender = localI420Frame;
      localI420Frame = new org/webrtc/VideoRenderer$I420Frame;
      localI420Frame.<init>(paramInt1, paramInt2, null, -1);
      this.textureFrameToRender = localI420Frame;
      this.updateTextureProperties = true;
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoRendererGui$YuvImageRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */