package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.nio.ByteBuffer;

public class MediaCodecVideoEncoder
{
  private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
  private static final int DEQUEUE_TIMEOUT = 0;
  private static final String TAG = "MediaCodecVideoEncoder";
  private static final int VIDEO_ControlRateConstant = 2;
  private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
  private static final int[] supportedColorList = { 19, 21, 2141391872, 2141391876 };
  private static final String[] supportedHwCodecPrefixes = { "OMX.qcom.", "OMX.Nvidia." };
  private int colorFormat;
  private MediaCodec mediaCodec;
  private Thread mediaCodecThread;
  private ByteBuffer[] outputBuffers;
  
  private void checkOnMediaCodecThread()
  {
    if (this.mediaCodecThread.getId() != Thread.currentThread().getId()) {
      throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }
  }
  
  static MediaCodec createByCodecName(String paramString)
  {
    try
    {
      paramString = MediaCodec.createByCodecName(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private int dequeueInputBuffer()
  {
    checkOnMediaCodecThread();
    try
    {
      i = this.mediaCodec.dequeueInputBuffer(0L);
      return i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "dequeueIntputBuffer failed", localIllegalStateException);
        int i = -2;
      }
    }
  }
  
  private MediaCodecVideoEncoder.OutputBufferInfo dequeueOutputBuffer()
  {
    checkOnMediaCodecThread();
    for (;;)
    {
      try
      {
        localObject2 = new android/media/MediaCodec$BufferInfo;
        ((MediaCodec.BufferInfo)localObject2).<init>();
        i = this.mediaCodec.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject2, 0L);
        if (i < 0) {
          continue;
        }
        ByteBuffer localByteBuffer = this.outputBuffers[i].duplicate();
        localByteBuffer.position(((MediaCodec.BufferInfo)localObject2).offset);
        localByteBuffer.limit(((MediaCodec.BufferInfo)localObject2).offset + ((MediaCodec.BufferInfo)localObject2).size);
        if ((((MediaCodec.BufferInfo)localObject2).flags & 0x1) == 0) {
          continue;
        }
        bool = true;
        if (bool) {
          Log.d("MediaCodecVideoEncoder", "Sync frame generated");
        }
        localObject1 = new org/webrtc/MediaCodecVideoEncoder$OutputBufferInfo;
        ((MediaCodecVideoEncoder.OutputBufferInfo)localObject1).<init>(i, localByteBuffer.slice(), bool, ((MediaCodec.BufferInfo)localObject2).presentationTimeUs);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject2;
        int i;
        boolean bool;
        Object localObject1;
        Log.e("MediaCodecVideoEncoder", "dequeueOutputBuffer failed", localIllegalStateException);
        MediaCodecVideoEncoder.OutputBufferInfo localOutputBufferInfo = new MediaCodecVideoEncoder.OutputBufferInfo(-1, null, false, -1L);
        continue;
      }
      return (MediaCodecVideoEncoder.OutputBufferInfo)localObject1;
      bool = false;
      continue;
      if (i == -3)
      {
        this.outputBuffers = this.mediaCodec.getOutputBuffers();
        localObject1 = dequeueOutputBuffer();
      }
      else if (i == -2)
      {
        localObject1 = dequeueOutputBuffer();
      }
      else
      {
        if (i != -1) {
          continue;
        }
        localObject1 = null;
      }
    }
    localObject1 = new java/lang/RuntimeException;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>("dequeueOutputBuffer: ");
    ((RuntimeException)localObject1).<init>(i);
    throw ((Throwable)localObject1);
  }
  
  private boolean encode(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    checkOnMediaCodecThread();
    if (paramBoolean) {}
    try
    {
      Log.d("MediaCodecVideoEncoder", "Sync frame request");
      Bundle localBundle = new android/os/Bundle;
      localBundle.<init>();
      localBundle.putInt("request-sync", 0);
      this.mediaCodec.setParameters(localBundle);
      this.mediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, 0);
      paramBoolean = true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "encode failed", localIllegalStateException);
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
  
  private static MediaCodecVideoEncoder.EncoderProperties findVp8HwEncoder()
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      localObject1 = null;
      return (MediaCodecVideoEncoder.EncoderProperties)localObject1;
    }
    int i = 0;
    label16:
    Object localObject2;
    int k;
    int j;
    if (i < MediaCodecList.getCodecCount())
    {
      localObject2 = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject2).isEncoder())
      {
        localObject1 = ((MediaCodecInfo)localObject2).getSupportedTypes();
        k = localObject1.length;
        j = 0;
        if (j >= k) {
          break label348;
        }
        if (!localObject1[j].equals("video/x-vnd.on2.vp8")) {}
      }
    }
    label113:
    label325:
    label331:
    label343:
    label348:
    for (Object localObject1 = ((MediaCodecInfo)localObject2).getName();; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        Log.d("MediaCodecVideoEncoder", "Found candidate encoder " + (String)localObject1);
        localObject3 = supportedHwCodecPrefixes;
        k = localObject3.length;
        j = 0;
        if (j >= k) {
          break label343;
        }
        if (!((String)localObject1).startsWith(localObject3[j])) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          localObject2 = ((MediaCodecInfo)localObject2).getCapabilitiesForType("video/x-vnd.on2.vp8");
          localObject3 = ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
          k = localObject3.length;
          j = 0;
          for (;;)
          {
            if (j < k)
            {
              m = localObject3[j];
              Log.d("MediaCodecVideoEncoder", "   Color: 0x" + Integer.toHexString(m));
              j++;
              continue;
              j++;
              break;
              j++;
              break label113;
            }
          }
          int[] arrayOfInt = supportedColorList;
          int m = arrayOfInt.length;
          for (j = 0;; j++)
          {
            if (j >= m) {
              break label331;
            }
            int i1 = arrayOfInt[j];
            localObject3 = ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
            int n = localObject3.length;
            for (k = 0;; k++)
            {
              if (k >= n) {
                break label325;
              }
              int i2 = localObject3[k];
              if (i2 == i1)
              {
                Log.d("MediaCodecVideoEncoder", "Found target encoder " + (String)localObject1 + ". Color: 0x" + Integer.toHexString(i2));
                localObject1 = new MediaCodecVideoEncoder.EncoderProperties((String)localObject1, i2);
                break;
              }
            }
          }
        }
        i++;
        break label16;
        localObject1 = null;
        break;
      }
    }
  }
  
  private ByteBuffer[] initEncode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = null;
    Log.d("MediaCodecVideoEncoder", "Java initEncode: " + paramInt1 + " x " + paramInt2 + ". @ " + paramInt3 + " kbps. Fps: " + paramInt4 + ". Color: 0x" + Integer.toHexString(this.colorFormat));
    if (this.mediaCodecThread != null) {
      throw new RuntimeException("Forgot to release()?");
    }
    Object localObject2 = findVp8HwEncoder();
    if (localObject2 == null) {
      throw new RuntimeException("Can not find HW VP8 encoder");
    }
    this.mediaCodecThread = Thread.currentThread();
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/x-vnd.on2.vp8", paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3 * 1000);
      localMediaFormat.setInteger("bitrate-mode", 2);
      localMediaFormat.setInteger("color-format", ((MediaCodecVideoEncoder.EncoderProperties)localObject2).colorFormat);
      localMediaFormat.setInteger("frame-rate", paramInt4);
      localMediaFormat.setInteger("i-frame-interval", 100);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("  Format: ");
      Log.d("MediaCodecVideoEncoder", localMediaFormat);
      this.mediaCodec = createByCodecName(((MediaCodecVideoEncoder.EncoderProperties)localObject2).codecName);
      if (this.mediaCodec == null) {}
      for (;;)
      {
        return (ByteBuffer[])localObject1;
        this.mediaCodec.configure(localMediaFormat, null, null, 1);
        this.mediaCodec.start();
        this.colorFormat = ((MediaCodecVideoEncoder.EncoderProperties)localObject2).colorFormat;
        this.outputBuffers = this.mediaCodec.getOutputBuffers();
        localObject2 = this.mediaCodec.getInputBuffers();
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Input buffers: ");
        Log.d("MediaCodecVideoEncoder", localObject2.length + ". Output buffers: " + this.outputBuffers.length);
        localObject1 = localObject2;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "initEncode failed", localIllegalStateException);
      }
    }
  }
  
  public static boolean isPlatformSupported()
  {
    if (findVp8HwEncoder() != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void release()
  {
    Log.d("MediaCodecVideoEncoder", "Java releaseEncoder");
    checkOnMediaCodecThread();
    try
    {
      this.mediaCodec.stop();
      this.mediaCodec.release();
      this.mediaCodec = null;
      this.mediaCodecThread = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "release failed", localIllegalStateException);
      }
    }
  }
  
  private boolean releaseOutputBuffer(int paramInt)
  {
    boolean bool = false;
    checkOnMediaCodecThread();
    try
    {
      this.mediaCodec.releaseOutputBuffer(paramInt, false);
      bool = true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "releaseOutputBuffer failed", localIllegalStateException);
      }
    }
    return bool;
  }
  
  private boolean setRates(int paramInt1, int paramInt2)
  {
    checkOnMediaCodecThread();
    Log.v("MediaCodecVideoEncoder", "setRates: " + paramInt1 + " kbps. Fps: " + paramInt2);
    try
    {
      Bundle localBundle = new android/os/Bundle;
      localBundle.<init>();
      localBundle.putInt("video-bitrate", paramInt1 * 1000);
      this.mediaCodec.setParameters(localBundle);
      bool = true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("MediaCodecVideoEncoder", "setRates failed", localIllegalStateException);
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaCodecVideoEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */