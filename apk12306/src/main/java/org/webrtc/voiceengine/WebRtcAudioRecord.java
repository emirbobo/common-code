package org.webrtc.voiceengine;

import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect.Descriptor;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

class WebRtcAudioRecord
{
  private AcousticEchoCanceler _aec = null;
  private AudioRecord _audioRecord = null;
  private int _bufferedRecSamples = 0;
  private Context _context;
  private boolean _doRecInit = true;
  private boolean _isRecording = false;
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private byte[] _tempBufRec;
  private boolean _useBuiltInAEC = false;
  final String logTag = "WebRtcAudioRecord-Java";
  
  WebRtcAudioRecord()
  {
    try
    {
      this._recBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufRec = new byte['π'];
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        DoLog(localException.getMessage());
      }
    }
  }
  
  public static boolean BuiltInAECIsAvailable()
  {
    if (!runningOnJellyBeanOrHigher()) {}
    for (boolean bool = false;; bool = AcousticEchoCanceler.isAvailable()) {
      return bool;
    }
  }
  
  private void DoLog(String paramString)
  {
    Log.d("WebRtcAudioRecord-Java", paramString);
  }
  
  private void DoLogErr(String paramString)
  {
    Log.e("WebRtcAudioRecord-Java", paramString);
  }
  
  private int EnableBuiltInAEC(boolean paramBoolean)
  {
    int i = -1;
    DoLog("EnableBuiltInAEC(" + paramBoolean + ')');
    if (!runningOnJellyBeanOrHigher()) {}
    for (;;)
    {
      return i;
      this._useBuiltInAEC = paramBoolean;
      if (this._aec != null)
      {
        if (this._aec.setEnabled(paramBoolean) != 0) {
          DoLogErr("AcousticEchoCanceler.setEnabled failed");
        } else {
          DoLog("AcousticEchoCanceler.getEnabled: " + this._aec.getEnabled());
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    Log.d("WebRtcAudioRecord-Java", "InitRecording");
    paramInt1 = AudioRecord.getMinBufferSize(paramInt2, 16, 2);
    this._bufferedRecSamples = (paramInt2 / 200);
    if (this._aec != null)
    {
      this._aec.release();
      this._aec = null;
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    try
    {
      AudioRecord localAudioRecord = new android/media/AudioRecord;
      localAudioRecord.<init>(7, paramInt2, 16, 2, paramInt1 << 1);
      this._audioRecord = localAudioRecord;
      if (this._audioRecord.getState() == 1) {
        break label114;
      }
      paramInt1 = -1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        DoLog(localException.getMessage());
        paramInt1 = -1;
        continue;
        DoLog("AcousticEchoCanceler.isAvailable: " + BuiltInAECIsAvailable());
        if (!BuiltInAECIsAvailable())
        {
          paramInt1 = this._bufferedRecSamples;
        }
        else
        {
          this._aec = AcousticEchoCanceler.create(this._audioRecord.getAudioSessionId());
          if (this._aec == null)
          {
            DoLogErr("AcousticEchoCanceler.create failed");
            paramInt1 = -1;
          }
          else if (this._aec.setEnabled(this._useBuiltInAEC) != 0)
          {
            DoLogErr("AcousticEchoCanceler.setEnabled failed");
            paramInt1 = -1;
          }
          else
          {
            AudioEffect.Descriptor localDescriptor = this._aec.getDescriptor();
            DoLog("AcousticEchoCanceler name: " + localDescriptor.name + ", implementor: " + localDescriptor.implementor + ", uuid: " + localDescriptor.uuid);
            DoLog("AcousticEchoCanceler.getEnabled: " + this._aec.getEnabled());
            paramInt1 = this._bufferedRecSamples;
          }
        }
      }
    }
    return paramInt1;
  }
  
  private int RecordAudio(int paramInt)
  {
    this._recLock.lock();
    for (;;)
    {
      try
      {
        localObject1 = this._audioRecord;
        if (localObject1 != null) {
          continue;
        }
        this._recLock.unlock();
        paramInt = -2;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        boolean bool;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("RecordAudio try failed: ");
        DoLogErr(localException1.getMessage());
        this._recLock.unlock();
        paramInt = this._bufferedRecSamples;
        continue;
        this._recLock.unlock();
        continue;
      }
      finally
      {
        this._recLock.unlock();
      }
      return paramInt;
      bool = this._doRecInit;
      if (bool == true) {}
      try
      {
        Process.setThreadPriority(-19);
        this._doRecInit = false;
        this._recBuffer.rewind();
        int i = this._audioRecord.read(this._tempBufRec, 0, paramInt);
        this._recBuffer.put(this._tempBufRec);
        if (i != paramInt)
        {
          this._recLock.unlock();
          paramInt = -1;
        }
      }
      catch (Exception localException2)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Set rec thread priority failed: ");
        DoLog(localException2.getMessage());
      }
    }
  }
  
  private int StartRecording()
  {
    Log.d("WebRtcAudioRecord-Java", "StartRecording");
    try
    {
      this._audioRecord.startRecording();
      this._isRecording = true;
      i = 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
        int i = -1;
      }
    }
    return i;
  }
  
  private int StopRecording()
  {
    int i = 0;
    Log.d("WebRtcAudioRecord-Java", "StopRecording");
    this._recLock.lock();
    try
    {
      int j = this._audioRecord.getRecordingState();
      if (j == 3) {}
      try
      {
        this._audioRecord.stop();
        if (this._aec != null)
        {
          this._aec.release();
          this._aec = null;
        }
        this._audioRecord.release();
        this._audioRecord = null;
        this._doRecInit = true;
        this._recLock.unlock();
        this._isRecording = false;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
          this._doRecInit = true;
          this._recLock.unlock();
          i = -1;
        }
      }
      return i;
    }
    finally
    {
      this._doRecInit = true;
      this._recLock.unlock();
    }
  }
  
  private static boolean runningOnJellyBeanOrHigher()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\voiceengine\WebRtcAudioRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */