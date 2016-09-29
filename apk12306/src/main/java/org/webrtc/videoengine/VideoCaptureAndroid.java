package org.webrtc.videoengine;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.WindowManager;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Exchanger;

public class VideoCaptureAndroid
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private static final String TAG = "anLive";
  private static SurfaceHolder localPreview;
  private double averageDurationMs;
  private Camera camera;
  private int[] cameraGlTextures = null;
  private SurfaceTexture cameraSurfaceTexture;
  private VideoCaptureAndroid.CameraThread cameraThread;
  private Handler cameraThreadHandler;
  private Context context;
  private int frameCount;
  private int frameDropRatio;
  private final int id;
  private final Camera.CameraInfo info;
  private long lastCaptureTimeMs;
  private final long native_capturer;
  private final int numCaptureBuffers = 3;
  
  public VideoCaptureAndroid(int paramInt, long paramLong)
  {
    this.id = paramInt;
    this.native_capturer = paramLong;
    this.context = GetContext();
    this.info = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, this.info);
  }
  
  private static native Context GetContext();
  
  private native void ProvideCameraFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  private static <T> T exchange(Exchanger<T> paramExchanger, T paramT)
  {
    try
    {
      paramExchanger = paramExchanger.exchange(paramT);
      return paramExchanger;
    }
    catch (InterruptedException paramExchanger)
    {
      throw new RuntimeException(paramExchanger);
    }
  }
  
  private int getDeviceOrientation()
  {
    int i;
    if (this.context != null) {
      switch (((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
      continue;
      i = 0;
    }
  }
  
  public static void setLocalPreview(SurfaceHolder paramSurfaceHolder)
  {
    localPreview = paramSurfaceHolder;
  }
  
  private void setPreviewDisplayOnCameraThread(SurfaceHolder paramSurfaceHolder, Exchanger<IOException> paramExchanger)
  {
    try
    {
      this.camera.setPreviewDisplay(paramSurfaceHolder);
      exchange(paramExchanger, null);
      return;
    }
    catch (IOException paramSurfaceHolder)
    {
      for (;;)
      {
        exchange(paramExchanger, paramSurfaceHolder);
      }
    }
  }
  
  /* Error */
  private void setPreviewRotation(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 143	org/webrtc/videoengine/VideoCaptureAndroid:camera	Landroid/hardware/Camera;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 151	org/webrtc/videoengine/VideoCaptureAndroid:cameraThreadHandler	Landroid/os/Handler;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 104	java/util/concurrent/Exchanger
    //   24: astore 4
    //   26: aload 4
    //   28: invokespecial 152	java/util/concurrent/Exchanger:<init>	()V
    //   31: aload_0
    //   32: getfield 151	org/webrtc/videoengine/VideoCaptureAndroid:cameraThreadHandler	Landroid/os/Handler;
    //   35: astore_2
    //   36: new 154	org/webrtc/videoengine/VideoCaptureAndroid$3
    //   39: astore_3
    //   40: aload_3
    //   41: aload_0
    //   42: iload_1
    //   43: aload 4
    //   45: invokespecial 156	org/webrtc/videoengine/VideoCaptureAndroid$3:<init>	(Lorg/webrtc/videoengine/VideoCaptureAndroid;ILjava/util/concurrent/Exchanger;)V
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual 162	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   53: pop
    //   54: aload 4
    //   56: aconst_null
    //   57: invokestatic 76	org/webrtc/videoengine/VideoCaptureAndroid:exchange	(Ljava/util/concurrent/Exchanger;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: goto -43 -> 18
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	VideoCaptureAndroid
    //   0	69	1	paramInt	int
    //   13	36	2	localHandler	Handler
    //   64	4	2	localObject	Object
    //   39	11	3	local3	VideoCaptureAndroid.3
    //   24	31	4	localExchanger	Exchanger
    // Exception table:
    //   from	to	target	type
    //   2	14	64	finally
    //   21	61	64	finally
  }
  
  private void setPreviewRotationOnCameraThread(int paramInt, Exchanger<IOException> paramExchanger)
  {
    Log.v("anLive", "setPreviewRotation:" + paramInt);
    int i = paramInt;
    if (this.info.facing == 1) {
      i = (360 - paramInt) % 360;
    }
    this.camera.setDisplayOrientation(i);
    exchange(paramExchanger, null);
  }
  
  private boolean startCapture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("startCapture: ");
      Log.d("anLive", paramInt1 + "x" + paramInt2 + "@" + paramInt3 + ":" + paramInt4);
      if ((this.cameraThread != null) || (this.cameraThreadHandler != null))
      {
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>("Camera thread already started!");
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    Object localObject3 = new java/util/concurrent/Exchanger;
    ((Exchanger)localObject3).<init>();
    Object localObject4 = new org/webrtc/videoengine/VideoCaptureAndroid$CameraThread;
    ((VideoCaptureAndroid.CameraThread)localObject4).<init>(this, (Exchanger)localObject3);
    this.cameraThread = ((VideoCaptureAndroid.CameraThread)localObject4);
    this.cameraThread.start();
    this.cameraThreadHandler = ((Handler)exchange((Exchanger)localObject3, null));
    localObject4 = new java/util/concurrent/Exchanger;
    ((Exchanger)localObject4).<init>();
    localObject3 = this.cameraThreadHandler;
    VideoCaptureAndroid.1 local1 = new org/webrtc/videoengine/VideoCaptureAndroid$1;
    local1.<init>(this, paramInt1, paramInt2, paramInt3, paramInt4, (Exchanger)localObject4);
    ((Handler)localObject3).post(local1);
    boolean bool = ((Boolean)exchange((Exchanger)localObject4, Boolean.valueOf(false))).booleanValue();
    return bool;
  }
  
  private void startCaptureOnCameraThread(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Exchanger<Boolean> paramExchanger)
  {
    for (;;)
    {
      try
      {
        this.camera = Camera.open(this.id);
        if (localPreview == null) {
          continue;
        }
        localPreview.addCallback(this);
        if ((localPreview.getSurface() != null) && (localPreview.getSurface().isValid())) {
          this.camera.setPreviewDisplay(localPreview);
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Camera orientation: ");
        Log.d("anLive", this.info.orientation + " .Device orientation: " + getDeviceOrientation());
        localObject1 = this.camera.getParameters();
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("isVideoStabilizationSupported: ");
        Log.d("anLive", ((Camera.Parameters)localObject1).isVideoStabilizationSupported());
        if (((Camera.Parameters)localObject1).isVideoStabilizationSupported()) {
          ((Camera.Parameters)localObject1).setVideoStabilization(true);
        }
        ((Camera.Parameters)localObject1).setPictureSize(paramInt1, paramInt2);
        ((Camera.Parameters)localObject1).setPreviewSize(paramInt1, paramInt2);
        localList = ((Camera.Parameters)localObject1).getSupportedPreviewFpsRange();
        this.frameDropRatio = Integer.MAX_VALUE;
        i = 0;
      }
      catch (IOException localIOException1)
      {
        Object localObject1;
        Object localObject2;
        List localList;
        Log.e("anLive", "startCapture failed", localIOException1);
        if (this.camera == null) {
          continue;
        }
        Exchanger localExchanger = new Exchanger();
        stopCaptureOnCameraThread(localExchanger);
        exchange(localExchanger, Boolean.valueOf(false));
        exchange(paramExchanger, Boolean.valueOf(false));
        continue;
        if ((localIOException2[0] % paramInt3 != 0) || (localIOException2[1] % paramInt4 != 0)) {
          continue;
        }
        this.frameDropRatio = Math.min(localIOException2[1] / paramInt4, this.frameDropRatio);
        i++;
        continue;
        if (this.frameDropRatio <= 1) {
          continue;
        }
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Frame dropper is enabled. Ratio: ");
        Log.d("anLive", this.frameDropRatio);
        int i = paramInt3 * this.frameDropRatio;
        paramInt3 = paramInt4 * this.frameDropRatio;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Camera preview mfps range: ");
        Log.d("anLive", i + " - " + paramInt3);
        localExchanger.setPreviewFpsRange(i, paramInt3);
        localExchanger.setPreviewFormat(17);
        this.camera.setParameters(localExchanger);
        paramInt2 = paramInt1 * paramInt2 * ImageFormat.getBitsPerPixel(17) / 8;
        paramInt1 = 0;
        if (paramInt1 >= 3) {
          continue;
        }
        this.camera.addCallbackBuffer(new byte[paramInt2]);
        paramInt1++;
        continue;
        this.camera.setPreviewCallbackWithBuffer(this);
        this.frameCount = 0;
        this.averageDurationMs = (1000000.0F / (paramInt3 / this.frameDropRatio));
        this.camera.startPreview();
        exchange(paramExchanger, Boolean.valueOf(true));
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      if (i < localList.size())
      {
        localObject2 = (int[])localList.get(i);
        if ((localObject2[0] == paramInt3) && (localObject2[1] == paramInt4)) {
          this.frameDropRatio = 1;
        }
      }
      else
      {
        if (this.frameDropRatio != Integer.MAX_VALUE) {
          continue;
        }
        Log.e("anLive", "Can not find camera fps range");
        new RuntimeException("Can not find camera fps range");
        exchange(paramExchanger, Boolean.valueOf(false));
        return;
        try
        {
          this.cameraGlTextures = new int[1];
          GLES20.glGenTextures(1, this.cameraGlTextures, 0);
          GLES20.glBindTexture(36197, this.cameraGlTextures[0]);
          GLES20.glTexParameterf(36197, 10241, 9729.0F);
          GLES20.glTexParameterf(36197, 10240, 9729.0F);
          GLES20.glTexParameteri(36197, 10242, 33071);
          GLES20.glTexParameteri(36197, 10243, 33071);
          localObject1 = new android/graphics/SurfaceTexture;
          ((SurfaceTexture)localObject1).<init>(this.cameraGlTextures[0]);
          this.cameraSurfaceTexture = ((SurfaceTexture)localObject1);
          this.cameraSurfaceTexture.setOnFrameAvailableListener(null);
          this.camera.setPreviewTexture(this.cameraSurfaceTexture);
        }
        catch (IOException localIOException2)
        {
          localObject1 = new java/lang/RuntimeException;
          ((RuntimeException)localObject1).<init>(localIOException2);
          throw ((Throwable)localObject1);
        }
      }
    }
  }
  
  /* Error */
  private boolean stopCapture()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc_w 393
    //   7: invokestatic 206	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: new 104	java/util/concurrent/Exchanger
    //   14: astore_2
    //   15: aload_2
    //   16: invokespecial 152	java/util/concurrent/Exchanger:<init>	()V
    //   19: aload_0
    //   20: getfield 151	org/webrtc/videoengine/VideoCaptureAndroid:cameraThreadHandler	Landroid/os/Handler;
    //   23: astore 4
    //   25: new 395	org/webrtc/videoengine/VideoCaptureAndroid$2
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 396	org/webrtc/videoengine/VideoCaptureAndroid$2:<init>	(Lorg/webrtc/videoengine/VideoCaptureAndroid;Ljava/util/concurrent/Exchanger;)V
    //   35: aload 4
    //   37: aload_3
    //   38: invokevirtual 162	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: aload_2
    //   43: iconst_0
    //   44: invokestatic 228	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: invokestatic 76	org/webrtc/videoengine/VideoCaptureAndroid:exchange	(Ljava/util/concurrent/Exchanger;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 224	java/lang/Boolean
    //   53: invokevirtual 232	java/lang/Boolean:booleanValue	()Z
    //   56: istore_1
    //   57: aload_0
    //   58: getfield 208	org/webrtc/videoengine/VideoCaptureAndroid:cameraThread	Lorg/webrtc/videoengine/VideoCaptureAndroid$CameraThread;
    //   61: invokevirtual 399	org/webrtc/videoengine/VideoCaptureAndroid$CameraThread:join	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 151	org/webrtc/videoengine/VideoCaptureAndroid:cameraThreadHandler	Landroid/os/Handler;
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 208	org/webrtc/videoengine/VideoCaptureAndroid:cameraThread	Lorg/webrtc/videoengine/VideoCaptureAndroid$CameraThread;
    //   74: ldc 12
    //   76: ldc_w 401
    //   79: invokestatic 206	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_1
    //   86: ireturn
    //   87: astore_3
    //   88: new 109	java/lang/RuntimeException
    //   91: astore_2
    //   92: aload_2
    //   93: aload_3
    //   94: invokespecial 112	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	VideoCaptureAndroid
    //   56	30	1	bool	boolean
    //   14	84	2	localObject1	Object
    //   99	4	2	localObject2	Object
    //   28	10	3	local2	VideoCaptureAndroid.2
    //   87	7	3	localInterruptedException	InterruptedException
    //   23	13	4	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   57	64	87	java/lang/InterruptedException
    //   2	57	99	finally
    //   57	64	99	finally
    //   64	83	99	finally
    //   88	99	99	finally
  }
  
  private void stopCaptureOnCameraThread(Exchanger<Boolean> paramExchanger)
  {
    if (this.camera == null) {
      throw new RuntimeException("Camera is already stopped!");
    }
    for (;;)
    {
      try
      {
        this.camera.stopPreview();
        this.camera.setPreviewCallbackWithBuffer(null);
        if (localPreview != null)
        {
          localPreview.removeCallback(this);
          this.camera.setPreviewDisplay(null);
          this.camera.release();
          this.camera = null;
          exchange(paramExchanger, Boolean.valueOf(true));
          Looper.myLooper().quit();
          return;
        }
      }
      catch (IOException localIOException)
      {
        Log.e("anLive", "Failed to stop camera", localIOException);
        exchange(paramExchanger, Boolean.valueOf(false));
        Looper.myLooper().quit();
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      this.camera.setPreviewTexture(null);
      this.cameraSurfaceTexture = null;
      if (this.cameraGlTextures != null)
      {
        GLES20.glDeleteTextures(1, this.cameraGlTextures, 0);
        this.cameraGlTextures = null;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (Thread.currentThread() != this.cameraThread) {
      throw new RuntimeException("Camera callback not on camera thread?!?");
    }
    if (this.camera == null) {}
    for (;;)
    {
      return;
      if (this.camera != paramCamera) {
        throw new RuntimeException("Unexpected camera in callback!");
      }
      this.frameCount += 1;
      if ((this.frameDropRatio > 1) && (this.frameCount % this.frameDropRatio > 0))
      {
        this.camera.addCallbackBuffer(paramArrayOfByte);
      }
      else
      {
        long l = SystemClock.elapsedRealtime();
        if (this.frameCount > this.frameDropRatio)
        {
          double d = l - this.lastCaptureTimeMs;
          this.averageDurationMs = (0.9D * this.averageDurationMs + 0.1D * d);
          if (this.frameCount % 30 == 0) {
            Log.d("anLive", "Camera TS " + l + ". Duration: " + (int)d + " ms. FPS: " + (int)(1000.0D / this.averageDurationMs + 0.5D));
          }
        }
        this.lastCaptureTimeMs = l;
        int j = getDeviceOrientation();
        int i = j;
        if (this.info.facing == 0) {
          i = 360 - j;
        }
        j = this.info.orientation;
        ProvideCameraFrame(paramArrayOfByte, paramArrayOfByte.length, (i + j) % 360, l, this.native_capturer);
        this.camera.addCallbackBuffer(paramArrayOfByte);
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramSurfaceHolder = new java/lang/StringBuilder;
      paramSurfaceHolder.<init>("VideoCaptureAndroid::surfaceChanged ignored: ");
      Log.d("anLive", paramInt1 + ": " + paramInt2 + "x" + paramInt3);
      return;
    }
    finally
    {
      paramSurfaceHolder = finally;
      throw paramSurfaceHolder;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      Log.d("anLive", "VideoCaptureAndroid::surfaceCreated");
      if (this.camera != null)
      {
        localObject = this.cameraThreadHandler;
        if (localObject != null) {
          break label30;
        }
      }
      label30:
      do
      {
        return;
        Exchanger localExchanger = new java/util/concurrent/Exchanger;
        localExchanger.<init>();
        Handler localHandler = this.cameraThreadHandler;
        localObject = new org/webrtc/videoengine/VideoCaptureAndroid$4;
        ((VideoCaptureAndroid.4)localObject).<init>(this, paramSurfaceHolder, localExchanger);
        localHandler.post((Runnable)localObject);
        paramSurfaceHolder = (IOException)exchange(localExchanger, null);
      } while (paramSurfaceHolder == null);
      Object localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>(paramSurfaceHolder);
      throw ((Throwable)localObject);
    }
    finally {}
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      Log.d("anLive", "VideoCaptureAndroid::surfaceDestroyed");
      if (this.camera != null)
      {
        paramSurfaceHolder = this.cameraThreadHandler;
        if (paramSurfaceHolder != null) {
          break label30;
        }
      }
      label30:
      do
      {
        return;
        localObject = new java/util/concurrent/Exchanger;
        ((Exchanger)localObject).<init>();
        paramSurfaceHolder = this.cameraThreadHandler;
        VideoCaptureAndroid.5 local5 = new org/webrtc/videoengine/VideoCaptureAndroid$5;
        local5.<init>(this, (Exchanger)localObject);
        paramSurfaceHolder.post(local5);
        paramSurfaceHolder = (IOException)exchange((Exchanger)localObject, null);
      } while (paramSurfaceHolder == null);
      Object localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>(paramSurfaceHolder);
      throw ((Throwable)localObject);
    }
    finally {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\VideoCaptureAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */