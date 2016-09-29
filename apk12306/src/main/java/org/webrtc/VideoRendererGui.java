package org.webrtc;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoRendererGui
  implements GLSurfaceView.Renderer
{
  private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
  private static final int EGL14_SDK_VERSION = 17;
  private static final String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
  private static final String TAG = "VideoRendererGui";
  private static EGLContext eglContext;
  private static VideoRendererGui instance = null;
  private final String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n";
  private final String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n";
  private int oesProgram;
  private boolean onSurfaceCreatedCalled;
  private int screenHeight;
  private int screenWidth;
  private GLSurfaceView surface;
  private ArrayList<VideoRendererGui.YuvImageRenderer> yuvImageRenderers;
  private int yuvProgram;
  
  static
  {
    eglContext = null;
  }
  
  private VideoRendererGui(GLSurfaceView paramGLSurfaceView)
  {
    this.surface = paramGLSurfaceView;
    paramGLSurfaceView.setPreserveEGLContextOnPause(true);
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
    this.yuvImageRenderers = new ArrayList();
  }
  
  private static void abortUnless(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new RuntimeException(paramString);
    }
  }
  
  private static void checkNoGLES2Error()
  {
    int i = GLES20.glGetError();
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      abortUnless(bool, "GLES20 error: " + i);
      return;
    }
  }
  
  public static VideoRendererGui.YuvImageRenderer create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoRendererGui.ScalingType arg4, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt1 > 100) || (paramInt2 < 0) || (paramInt2 > 100) || (paramInt3 < 0) || (paramInt3 > 100) || (paramInt4 < 0) || (paramInt4 > 100) || (paramInt1 + paramInt3 > 100) || (paramInt2 + paramInt4 > 100)) {
      throw new RuntimeException("Incorrect window parameters.");
    }
    if (instance == null) {
      throw new RuntimeException("Attempt to create yuv renderer before setting GLSurfaceView");
    }
    VideoRendererGui.YuvImageRenderer localYuvImageRenderer = new VideoRendererGui.YuvImageRenderer(instance.surface, instance.yuvImageRenderers.size(), paramInt1, paramInt2, paramInt3, paramInt4, ???, paramBoolean, null);
    synchronized (instance.yuvImageRenderers)
    {
      CountDownLatch localCountDownLatch;
      Object localObject1;
      if (instance.onSurfaceCreatedCalled)
      {
        localCountDownLatch = new java/util/concurrent/CountDownLatch;
        localCountDownLatch.<init>(1);
        GLSurfaceView localGLSurfaceView = instance.surface;
        localObject1 = new org/webrtc/VideoRendererGui$1;
        ((VideoRendererGui.1)localObject1).<init>(localYuvImageRenderer, localCountDownLatch);
        localGLSurfaceView.queueEvent((Runnable)localObject1);
      }
      try
      {
        localCountDownLatch.await();
        instance.yuvImageRenderers.add(localYuvImageRenderer);
        return localYuvImageRenderer;
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>(localInterruptedException);
        throw ((Throwable)localObject1);
      }
    }
  }
  
  public static VideoRenderer createGui(int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoRendererGui.ScalingType paramScalingType, boolean paramBoolean)
    throws Exception
  {
    return new VideoRenderer(create(paramInt1, paramInt2, paramInt3, paramInt4, paramScalingType, paramBoolean));
  }
  
  public static VideoRenderer.Callbacks createGuiRenderer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoRendererGui.ScalingType paramScalingType, boolean paramBoolean)
  {
    return create(paramInt1, paramInt2, paramInt3, paramInt4, paramScalingType, paramBoolean);
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    int j = loadShader(35632, paramString2);
    int k = GLES20.glCreateProgram();
    if (k == 0) {
      throw new RuntimeException("Could not create program");
    }
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    paramString1[0] = 0;
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("VideoRendererGui", "Could not link program: " + GLES20.glGetProgramInfoLog(k));
      throw new RuntimeException(GLES20.glGetProgramInfoLog(k));
    }
    checkNoGLES2Error();
    return k;
  }
  
  private static FloatBuffer directNativeFloatBuffer(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat);
    localFloatBuffer.flip();
    return localFloatBuffer;
  }
  
  public static EGLContext getEGLContext()
  {
    return eglContext;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    int i = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      Log.e("VideoRendererGui", "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      throw new RuntimeException(GLES20.glGetShaderInfoLog(i));
    }
    checkNoGLES2Error();
    return i;
  }
  
  public static void setView(GLSurfaceView paramGLSurfaceView)
  {
    Log.d("VideoRendererGui", "VideoRendererGui.setView");
    instance = new VideoRendererGui(paramGLSurfaceView);
  }
  
  public static void update(VideoRenderer.Callbacks paramCallbacks, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoRendererGui.ScalingType paramScalingType)
  {
    Log.d("VideoRendererGui", "VideoRendererGui.update");
    if (instance == null) {
      throw new RuntimeException("Attempt to update yuv renderer before setting GLSurfaceView");
    }
    synchronized (instance.yuvImageRenderers)
    {
      Iterator localIterator = instance.yuvImageRenderers.iterator();
      while (localIterator.hasNext())
      {
        VideoRendererGui.YuvImageRenderer localYuvImageRenderer = (VideoRendererGui.YuvImageRenderer)localIterator.next();
        if (localYuvImageRenderer == paramCallbacks) {
          localYuvImageRenderer.setPosition(paramInt1, paramInt2, paramInt3, paramInt4, paramScalingType);
        }
      }
    }
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    GLES20.glClear(16384);
    synchronized (this.yuvImageRenderers)
    {
      Iterator localIterator = this.yuvImageRenderers.iterator();
      if (localIterator.hasNext()) {
        VideoRendererGui.YuvImageRenderer.access$900((VideoRendererGui.YuvImageRenderer)localIterator.next());
      }
    }
  }
  
  public void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    Log.d("VideoRendererGui", "VideoRendererGui.onSurfaceChanged: " + paramInt1 + " x " + paramInt2 + "  ");
    this.screenWidth = paramInt1;
    this.screenHeight = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    synchronized (this.yuvImageRenderers)
    {
      Iterator localIterator = this.yuvImageRenderers.iterator();
      if (localIterator.hasNext()) {
        ((VideoRendererGui.YuvImageRenderer)localIterator.next()).setScreenSize(this.screenWidth, this.screenHeight);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 arg1, EGLConfig paramEGLConfig)
  {
    Log.d("VideoRendererGui", "VideoRendererGui.onSurfaceCreated");
    if (CURRENT_SDK_VERSION >= 17)
    {
      eglContext = EGL14.eglGetCurrentContext();
      Log.d("VideoRendererGui", "VideoRendererGui EGL Context: " + eglContext);
    }
    this.yuvProgram = createProgram("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n");
    this.oesProgram = createProgram("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n");
    synchronized (this.yuvImageRenderers)
    {
      paramEGLConfig = this.yuvImageRenderers.iterator();
      if (paramEGLConfig.hasNext()) {
        VideoRendererGui.YuvImageRenderer.access$800((VideoRendererGui.YuvImageRenderer)paramEGLConfig.next(), this.yuvProgram, this.oesProgram);
      }
    }
    this.onSurfaceCreatedCalled = true;
    checkNoGLES2Error();
    GLES20.glClearColor(0.15F, 0.15F, 0.15F, 1.0F);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoRendererGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */