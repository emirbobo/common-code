package org.webrtc.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

class WebRtcAudioTrack
{
  private AudioManager _audioManager;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private Context _context;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private byte[] _tempBufPlay;
  final String logTag = "WebRTC AD java";
  
  WebRtcAudioTrack()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufPlay = new byte['π'];
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
  
  private void DoLog(String paramString)
  {
    Log.d("WebRTC AD java", paramString);
  }
  
  private void DoLogErr(String paramString)
  {
    Log.e("WebRTC AD java", paramString);
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt)
  {
    int j = AudioTrack.getMinBufferSize(paramInt, 4, 2);
    int i = j;
    if (j < 6000) {
      i = j << 1;
    }
    this._bufferedPlaySamples = 0;
    if (this._audioTrack != null)
    {
      this._audioTrack.release();
      this._audioTrack = null;
    }
    try
    {
      AudioTrack localAudioTrack = new android/media/AudioTrack;
      localAudioTrack.<init>(0, paramInt, 4, 2, i, 1);
      this._audioTrack = localAudioTrack;
      if (this._audioTrack.getState() == 1) {
        break label97;
      }
      paramInt = -1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        DoLog(localException.getMessage());
        paramInt = -1;
        continue;
        if ((this._audioManager == null) && (this._context != null)) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (this._audioManager == null) {
          paramInt = 0;
        } else {
          paramInt = this._audioManager.getStreamMaxVolume(0);
        }
      }
    }
    return paramInt;
  }
  
  private int PlayAudio(int paramInt)
  {
    this._playLock.lock();
    for (;;)
    {
      try
      {
        Object localObject1 = this._audioTrack;
        if (localObject1 == null)
        {
          this._playLock.unlock();
          paramInt = -2;
          return paramInt;
        }
        boolean bool = this._doPlayInit;
        if (bool == true) {}
        try
        {
          Process.setThreadPriority(-19);
          this._doPlayInit = false;
          this._playBuffer.get(this._tempBufPlay);
          int j = this._audioTrack.write(this._tempBufPlay, 0, paramInt);
          this._playBuffer.rewind();
          this._bufferedPlaySamples += (j >> 1);
          int i = this._audioTrack.getPlaybackHeadPosition();
          if (i < this._playPosition) {
            this._playPosition = 0;
          }
          this._bufferedPlaySamples -= i - this._playPosition;
          this._playPosition = i;
          if (j != paramInt)
          {
            this._playLock.unlock();
            paramInt = -1;
          }
        }
        catch (Exception localException)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("Set play thread priority failed: ");
          DoLog(localException.getMessage());
          continue;
        }
      }
      finally
      {
        this._playLock.unlock();
      }
      paramInt = this._bufferedPlaySamples;
    }
  }
  
  private int SetPlayoutSpeaker(boolean paramBoolean)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    if (this._audioManager == null)
    {
      Log.e("WebRTC AD java", "Could not change audio routing - no audio manager");
      i = -1;
      return i;
    }
    int i = Build.VERSION.SDK_INT;
    if ((3 == i) || (4 == i)) {
      if (paramBoolean) {
        this._audioManager.setMode(0);
      }
    }
    for (;;)
    {
      i = 0;
      break;
      this._audioManager.setMode(2);
      continue;
      if (((Build.BRAND.equals("Samsung")) || (Build.BRAND.equals("samsung"))) && ((5 == i) || (6 == i) || (7 == i)))
      {
        if (paramBoolean) {
          this._audioManager.setMode(2);
        }
      }
      else
      {
        this._audioManager.setSpeakerphoneOn(paramBoolean);
        continue;
      }
      this._audioManager.setSpeakerphoneOn(paramBoolean);
      this._audioManager.setMode(0);
    }
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  private int StartPlayback()
  {
    try
    {
      this._audioTrack.play();
      this._isPlaying = true;
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
  
  private int StopPlayback()
  {
    int i = 0;
    this._playLock.lock();
    try
    {
      int j = this._audioTrack.getPlayState();
      if (j == 3) {}
      try
      {
        this._audioTrack.stop();
        this._audioTrack.flush();
        this._audioTrack.release();
        this._audioTrack = null;
        this._doPlayInit = true;
        this._playLock.unlock();
        this._isPlaying = false;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
          this._doPlayInit = true;
          this._playLock.unlock();
          i = -1;
        }
      }
      return i;
    }
    finally
    {
      this._doPlayInit = true;
      this._playLock.unlock();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\voiceengine\WebRtcAudioTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */