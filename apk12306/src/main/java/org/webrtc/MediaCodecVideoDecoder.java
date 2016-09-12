package org.webrtc;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

class MediaCodecVideoDecoder
{
  private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  private static final int CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
  private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
  private static final int EGL14_SDK_VERSION = 17;
  private static final String TAG = "MediaCodecVideoDecoder";
  private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
  private static final int[] supportedColorList;
  private static final String[] supportedHwCodecPrefixes = { "OMX.qcom.", "OMX.Nvidia." };
  private static final String[] supportedSwCodecPrefixes = { "OMX.google." };
  private int colorFormat;
  private EGLContext eglContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay eglDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface eglSurface = EGL14.EGL_NO_SURFACE;
  private int height;
  private ByteBuffer[] inputBuffers;
  private MediaCodec mediaCodec;
  private Thread mediaCodecThread;
  private ByteBuffer[] outputBuffers;
  private int sliceHeight;
  private float[] stMatrix = new float[16];
  private int stride;
  private Surface surface = null;
  private SurfaceTexture surfaceTexture = null;
  private int textureID = -1;
  private boolean useSurface;
  private int width;
  
  static
  {
    supportedColorList = new int[] { 19, 21, 2141391872, 2141391876 };
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      Log.e("MediaCodecVideoDecoder", paramString + ": EGL Error: 0x" + Integer.toHexString(i));
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e("MediaCodecVideoDecoder", paramString + ": GL Error: 0x" + Integer.toHexString(i));
      throw new RuntimeException(paramString + ": GL Error: 0x " + Integer.toHexString(i));
    }
  }
  
  private void checkOnMediaCodecThread()
  {
    if (this.mediaCodecThread.getId() != Thread.currentThread().getId()) {
      throw new RuntimeException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }
  }
  
  private int dequeueInputBuffer()
  {
    checkOnMediaCodecThread();
    try
    {
      i = this.mediaCodec.dequeueInputBuffer(500000L);
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoDecoder", "dequeueIntputBuffer failed", localIllegalStateException);
        int i = -2;
      }
    }
  }
  
  private MediaCodecVideoDecoder.DecoderOutputBufferInfo dequeueOutputBuffer(int paramInt)
  {
    checkOnMediaCodecThread();
    for (;;)
    {
      try
      {
        localObject1 = new android/media/MediaCodec$BufferInfo;
        ((MediaCodec.BufferInfo)localObject1).<init>();
        i = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, paramInt);
        if ((i != -3) && (i != -2)) {
          continue;
        }
        if (i == -3)
        {
          this.outputBuffers = this.mediaCodec.getOutputBuffers();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("Output buffers changed: ");
          Log.d("MediaCodecVideoDecoder", this.outputBuffers.length);
          i = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject1, paramInt);
          continue;
        }
        if (i != -2) {
          continue;
        }
        localObject2 = this.mediaCodec.getOutputFormat();
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("Format changed: ");
        Log.d("MediaCodecVideoDecoder", ((MediaFormat)localObject2).toString());
        this.width = ((MediaFormat)localObject2).getInteger("width");
        this.height = ((MediaFormat)localObject2).getInteger("height");
        if ((this.useSurface) || (!((MediaFormat)localObject2).containsKey("color-format"))) {
          continue;
        }
        this.colorFormat = ((MediaFormat)localObject2).getInteger("color-format");
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("Color: 0x");
        Log.d("MediaCodecVideoDecoder", Integer.toHexString(this.colorFormat));
        localObject3 = supportedColorList;
        int j = localObject3.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        int k = localObject3[i];
        if (this.colorFormat != k) {
          continue;
        }
        i = 1;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject1;
        Object localObject2;
        Log.e("MediaCodecVideoDecoder", "dequeueOutputBuffer failed", localIllegalStateException);
        MediaCodecVideoDecoder.DecoderOutputBufferInfo localDecoderOutputBufferInfo = new MediaCodecVideoDecoder.DecoderOutputBufferInfo(-1, 0, 0, -1L);
        continue;
        if (i < 0) {
          continue;
        }
        localDecoderOutputBufferInfo = new MediaCodecVideoDecoder.DecoderOutputBufferInfo(i, localDecoderOutputBufferInfo.offset, localDecoderOutputBufferInfo.size, localDecoderOutputBufferInfo.presentationTimeUs);
        continue;
        localDecoderOutputBufferInfo = null;
        continue;
        int i = 0;
        continue;
      }
      if (i == 0)
      {
        Log.e("MediaCodecVideoDecoder", "Non supported color format");
        localObject1 = new MediaCodecVideoDecoder.DecoderOutputBufferInfo(-1, 0, 0, -1L);
        return (MediaCodecVideoDecoder.DecoderOutputBufferInfo)localObject1;
        i++;
      }
      else
      {
        if (((MediaFormat)localObject2).containsKey("stride")) {
          this.stride = ((MediaFormat)localObject2).getInteger("stride");
        }
        if (((MediaFormat)localObject2).containsKey("slice-height")) {
          this.sliceHeight = ((MediaFormat)localObject2).getInteger("slice-height");
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("Frame stride and slice height: ");
        Log.d("MediaCodecVideoDecoder", this.stride + " x " + this.sliceHeight);
        this.stride = Math.max(this.width, this.stride);
        this.sliceHeight = Math.max(this.height, this.sliceHeight);
      }
    }
  }
  
  private void eglRelease()
  {
    Log.d("MediaCodecVideoDecoder", "EGL release");
    if (this.eglDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
      EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.eglDisplay);
    }
    this.eglDisplay = EGL14.EGL_NO_DISPLAY;
    this.eglContext = EGL14.EGL_NO_CONTEXT;
    this.eglSurface = EGL14.EGL_NO_SURFACE;
  }
  
  private void eglSetup(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    Log.d("MediaCodecVideoDecoder", "EGL setup");
    EGLContext localEGLContext = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext = EGL14.EGL_NO_CONTEXT;
    }
    this.eglDisplay = EGL14.eglGetDisplay(0);
    if (this.eglDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("Unable to get EGL14 display");
    }
    paramEGLContext = new int[2];
    if (!EGL14.eglInitialize(this.eglDisplay, paramEGLContext, 0, paramEGLContext, 1)) {
      throw new RuntimeException("Unable to initialize EGL14");
    }
    paramEGLContext = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.eglDisplay;
    int i = paramEGLContext.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344 }, 0, paramEGLContext, 0, i, arrayOfInt, 0)) {
      throw new RuntimeException("Unable to find RGB888 EGL config");
    }
    this.eglContext = EGL14.eglCreateContext(this.eglDisplay, paramEGLContext[0], localEGLContext, new int[] { 12440, 2, 12344 }, 0);
    checkEglError("eglCreateContext");
    if (this.eglContext == null) {
      throw new RuntimeException("Null EGL context");
    }
    this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, paramEGLContext[0], new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (this.eglSurface == null) {
      throw new RuntimeException("EGL surface was null");
    }
  }
  
  private static MediaCodecVideoDecoder.DecoderProperties findVp8Decoder(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      localObject1 = null;
      return (MediaCodecVideoDecoder.DecoderProperties)localObject1;
    }
    Object localObject1 = supportedHwCodecPrefixes;
    if (paramBoolean) {
      localObject1 = supportedSwCodecPrefixes;
    }
    int i = 0;
    label30:
    Object localObject3;
    int k;
    int j;
    if (i < MediaCodecList.getCodecCount())
    {
      localObject3 = MediaCodecList.getCodecInfoAt(i);
      if (!((MediaCodecInfo)localObject3).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)localObject3).getSupportedTypes();
        k = localObject2.length;
        j = 0;
        if (j >= k) {
          break label364;
        }
        if (!localObject2[j].equals("video/x-vnd.on2.vp8")) {}
      }
    }
    label123:
    label341:
    label347:
    label359:
    label364:
    for (Object localObject2 = ((MediaCodecInfo)localObject3).getName();; localObject2 = null)
    {
      if (localObject2 != null)
      {
        Log.d("MediaCodecVideoDecoder", "Found candidate decoder " + (String)localObject2);
        k = localObject1.length;
        j = 0;
        if (j >= k) {
          break label359;
        }
        if (!((String)localObject2).startsWith(localObject1[j])) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          localObject3 = ((MediaCodecInfo)localObject3).getCapabilitiesForType("video/x-vnd.on2.vp8");
          int[] arrayOfInt1 = ((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats;
          k = arrayOfInt1.length;
          j = 0;
          for (;;)
          {
            if (j < k)
            {
              m = arrayOfInt1[j];
              Log.d("MediaCodecVideoDecoder", "   Color: 0x" + Integer.toHexString(m));
              j++;
              continue;
              j++;
              break;
              j++;
              break label123;
            }
          }
          int[] arrayOfInt2 = supportedColorList;
          int m = arrayOfInt2.length;
          for (j = 0;; j++)
          {
            if (j >= m) {
              break label347;
            }
            int n = arrayOfInt2[j];
            arrayOfInt1 = ((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats;
            int i1 = arrayOfInt1.length;
            for (k = 0;; k++)
            {
              if (k >= i1) {
                break label341;
              }
              int i2 = arrayOfInt1[k];
              if (i2 == n)
              {
                Log.d("MediaCodecVideoDecoder", "Found target decoder " + (String)localObject2 + ". Color: 0x" + Integer.toHexString(i2));
                localObject1 = new MediaCodecVideoDecoder.DecoderProperties((String)localObject2, i2);
                break;
              }
            }
          }
        }
        i++;
        break label30;
        localObject1 = null;
        break;
      }
    }
  }
  
  private boolean initDecode(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, EGLContext paramEGLContext)
  {
    Surface localSurface = null;
    bool = false;
    if (this.mediaCodecThread != null) {
      throw new RuntimeException("Forgot to release()?");
    }
    if ((paramBoolean2) && (paramEGLContext == null)) {
      throw new RuntimeException("No shared EGL context.");
    }
    MediaCodecVideoDecoder.DecoderProperties localDecoderProperties = findVp8Decoder(paramBoolean1);
    if (localDecoderProperties == null) {
      throw new RuntimeException("Cannot find HW VP8 decoder");
    }
    Log.d("MediaCodecVideoDecoder", "Java initDecode: " + paramInt1 + " x " + paramInt2 + ". Color: 0x" + Integer.toHexString(localDecoderProperties.colorFormat) + ". Use Surface: " + paramBoolean2 + ". Use SW codec: " + paramBoolean1);
    if (paramEGLContext != null) {
      Log.d("MediaCodecVideoDecoder", "Decoder shared EGL Context: " + paramEGLContext);
    }
    this.mediaCodecThread = Thread.currentThread();
    for (;;)
    {
      try
      {
        this.width = paramInt1;
        this.height = paramInt2;
        this.useSurface = paramBoolean2;
        this.stride = paramInt1;
        this.sliceHeight = paramInt2;
        if (paramBoolean2)
        {
          eglSetup(paramEGLContext, paramInt1, paramInt2);
          makeCurrent();
          paramEGLContext = new int[1];
          GLES20.glGenTextures(1, paramEGLContext, 0);
          checkGlError("glGenTextures");
          this.textureID = paramEGLContext[0];
          GLES20.glBindTexture(36197, this.textureID);
          checkGlError("glBindTexture mTextureID");
          GLES20.glTexParameterf(36197, 10241, 9728.0F);
          GLES20.glTexParameterf(36197, 10240, 9729.0F);
          GLES20.glTexParameteri(36197, 10242, 33071);
          GLES20.glTexParameteri(36197, 10243, 33071);
          checkGlError("glTexParameter");
          paramEGLContext = new java/lang/StringBuilder;
          paramEGLContext.<init>("Video decoder TextureID = ");
          Log.d("MediaCodecVideoDecoder", this.textureID);
          paramEGLContext = new android/graphics/SurfaceTexture;
          paramEGLContext.<init>(this.textureID);
          this.surfaceTexture = paramEGLContext;
          paramEGLContext = new android/view/Surface;
          paramEGLContext.<init>(this.surfaceTexture);
          this.surface = paramEGLContext;
          localSurface = this.surface;
        }
        paramEGLContext = MediaFormat.createVideoFormat("video/x-vnd.on2.vp8", paramInt1, paramInt2);
        if (!paramBoolean2) {
          paramEGLContext.setInteger("color-format", localDecoderProperties.colorFormat);
        }
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("  Format: ");
        Log.d("MediaCodecVideoDecoder", paramEGLContext);
        this.mediaCodec = MediaCodecVideoEncoder.createByCodecName(localDecoderProperties.codecName);
        if (this.mediaCodec != null) {
          continue;
        }
        paramBoolean1 = bool;
      }
      catch (IllegalStateException paramEGLContext)
      {
        Log.e("MediaCodecVideoDecoder", "initDecode failed", paramEGLContext);
        paramBoolean1 = bool;
        continue;
      }
      return paramBoolean1;
      this.mediaCodec.configure(paramEGLContext, localSurface, null, 0);
      this.mediaCodec.start();
      this.colorFormat = localDecoderProperties.colorFormat;
      this.outputBuffers = this.mediaCodec.getOutputBuffers();
      this.inputBuffers = this.mediaCodec.getInputBuffers();
      paramEGLContext = new java/lang/StringBuilder;
      paramEGLContext.<init>("Input buffers: ");
      Log.d("MediaCodecVideoDecoder", this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
      paramBoolean1 = true;
    }
  }
  
  private static boolean isEGL14Supported()
  {
    Log.d("MediaCodecVideoDecoder", "SDK version: " + CURRENT_SDK_VERSION);
    if (CURRENT_SDK_VERSION >= 17) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isPlatformSupported()
  {
    boolean bool = false;
    if (findVp8Decoder(false) != null) {
      bool = true;
    }
    return bool;
  }
  
  private void makeCurrent()
  {
    if (!EGL14.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
  
  private boolean queueInputBuffer(int paramInt1, int paramInt2, long paramLong)
  {
    checkOnMediaCodecThread();
    try
    {
      this.inputBuffers[paramInt1].position(0);
      this.inputBuffers[paramInt1].limit(paramInt2);
      this.mediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, 0);
      bool = true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoDecoder", "decode failed", localIllegalStateException);
        boolean bool = false;
      }
    }
    return bool;
  }
  
  private void release()
  {
    Log.d("MediaCodecVideoDecoder", "Java releaseDecoder");
    checkOnMediaCodecThread();
    try
    {
      this.mediaCodec.stop();
      this.mediaCodec.release();
      this.mediaCodec = null;
      this.mediaCodecThread = null;
      if (this.useSurface)
      {
        this.surface.release();
        if (this.textureID >= 0)
        {
          int i = this.textureID;
          Log.d("MediaCodecVideoDecoder", "Delete video decoder TextureID " + this.textureID);
          GLES20.glDeleteTextures(1, new int[] { i }, 0);
          checkGlError("glDeleteTextures");
        }
        eglRelease();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoDecoder", "release failed", localIllegalStateException);
      }
    }
  }
  
  private boolean releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    checkOnMediaCodecThread();
    try
    {
      if (!this.useSurface) {
        paramBoolean = false;
      }
      this.mediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      paramBoolean = true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoDecoder", "releaseOutputBuffer failed", localIllegalStateException);
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaCodecVideoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */