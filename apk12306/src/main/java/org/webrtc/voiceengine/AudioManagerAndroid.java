package org.webrtc.voiceengine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build.VERSION;

class AudioManagerAndroid
{
  private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
  private static final int DEFAULT_SAMPLING_RATE = 44100;
  private int mAudioLowLatencyOutputFrameSize;
  private boolean mAudioLowLatencySupported;
  private int mNativeOutputSampleRate;
  
  private AudioManagerAndroid(Context paramContext)
  {
    Object localObject = (AudioManager)paramContext.getSystemService("audio");
    this.mNativeOutputSampleRate = 44100;
    this.mAudioLowLatencyOutputFrameSize = 256;
    if (Build.VERSION.SDK_INT >= 17)
    {
      String str = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
      if (str != null) {
        this.mNativeOutputSampleRate = Integer.parseInt(str);
      }
      localObject = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
      if (localObject != null) {
        this.mAudioLowLatencyOutputFrameSize = Integer.parseInt((String)localObject);
      }
    }
    this.mAudioLowLatencySupported = paramContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }
  
  private int getAudioLowLatencyOutputFrameSize()
  {
    return this.mAudioLowLatencyOutputFrameSize;
  }
  
  private int getNativeOutputSampleRate()
  {
    return this.mNativeOutputSampleRate;
  }
  
  private boolean isAudioLowLatencySupported()
  {
    return this.mAudioLowLatencySupported;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\voiceengine\AudioManagerAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */