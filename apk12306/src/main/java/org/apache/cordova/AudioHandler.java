package org.apache.cordova;

import android.app.Activity;
import android.media.AudioManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class AudioHandler
  extends CordovaPlugin
{
  public static String TAG = "AudioHandler";
  ArrayList<AudioPlayer> pausedForPhone = new ArrayList();
  HashMap<String, AudioPlayer> players = new HashMap();
  
  private boolean release(String paramString)
  {
    if (!this.players.containsKey(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      AudioPlayer localAudioPlayer = (AudioPlayer)this.players.get(paramString);
      this.players.remove(paramString);
      localAudioPlayer.destroy();
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    PluginResult.Status localStatus = PluginResult.Status.OK;
    if (paramString.equals("startRecordingAudio"))
    {
      startRecordingAudio(paramJSONArray.getString(0), FileHelper.stripFileProtocol(paramJSONArray.getString(1)));
      paramCallbackContext.sendPluginResult(new PluginResult(localStatus, ""));
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("stopRecordingAudio"))
      {
        stopRecordingAudio(paramJSONArray.getString(0));
        break;
      }
      if (paramString.equals("startPlayingAudio"))
      {
        startPlayingAudio(paramJSONArray.getString(0), FileHelper.stripFileProtocol(paramJSONArray.getString(1)));
        break;
      }
      if (paramString.equals("seekToAudio"))
      {
        seekToAudio(paramJSONArray.getString(0), paramJSONArray.getInt(1));
        break;
      }
      if (paramString.equals("pausePlayingAudio"))
      {
        pausePlayingAudio(paramJSONArray.getString(0));
        break;
      }
      if (paramString.equals("stopPlayingAudio"))
      {
        stopPlayingAudio(paramJSONArray.getString(0));
        break;
      }
      if (paramString.equals("setVolume"))
      {
        try
        {
          setVolume(paramJSONArray.getString(0), Float.parseFloat(paramJSONArray.getString(1)));
        }
        catch (NumberFormatException paramString) {}
        break;
      }
      if (paramString.equals("getCurrentPositionAudio"))
      {
        paramCallbackContext.sendPluginResult(new PluginResult(localStatus, getCurrentPositionAudio(paramJSONArray.getString(0))));
      }
      else if (paramString.equals("getDurationAudio"))
      {
        paramCallbackContext.sendPluginResult(new PluginResult(localStatus, getDurationAudio(paramJSONArray.getString(0), paramJSONArray.getString(1))));
      }
      else
      {
        if (paramString.equals("create"))
        {
          paramString = paramJSONArray.getString(0);
          paramJSONArray = new AudioPlayer(this, paramString, FileHelper.stripFileProtocol(paramJSONArray.getString(1)));
          this.players.put(paramString, paramJSONArray);
          break;
        }
        if (paramString.equals("release")) {
          paramCallbackContext.sendPluginResult(new PluginResult(localStatus, release(paramJSONArray.getString(0))));
        } else {
          bool = false;
        }
      }
    }
  }
  
  public int getAudioOutputDevice()
  {
    int i = 1;
    AudioManager localAudioManager = (AudioManager)this.cordova.getActivity().getSystemService("audio");
    if (localAudioManager.getRouting(0) == 1) {}
    for (;;)
    {
      return i;
      if (localAudioManager.getRouting(0) == 2) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
  
  public float getCurrentPositionAudio(String paramString)
  {
    paramString = (AudioPlayer)this.players.get(paramString);
    if (paramString != null) {}
    for (float f = (float)paramString.getCurrentPosition() / 1000.0F;; f = -1.0F) {
      return f;
    }
  }
  
  public float getDurationAudio(String paramString1, String paramString2)
  {
    AudioPlayer localAudioPlayer = (AudioPlayer)this.players.get(paramString1);
    if (localAudioPlayer != null) {}
    for (float f = localAudioPlayer.getDuration(paramString2);; f = localAudioPlayer.getDuration(paramString2))
    {
      return f;
      localAudioPlayer = new AudioPlayer(this, paramString1, paramString2);
      this.players.put(paramString1, localAudioPlayer);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.players.values().iterator();
    while (localIterator.hasNext()) {
      ((AudioPlayer)localIterator.next()).destroy();
    }
    this.players.clear();
  }
  
  public Object onMessage(String paramString, Object paramObject)
  {
    if (paramString.equals("telephone"))
    {
      if (("ringing".equals(paramObject)) || ("offhook".equals(paramObject))) {
        paramObject = this.players.values().iterator();
      }
      while (((Iterator)paramObject).hasNext())
      {
        paramString = (AudioPlayer)((Iterator)paramObject).next();
        if (paramString.getState() == AudioPlayer.STATE.MEDIA_RUNNING.ordinal())
        {
          this.pausedForPhone.add(paramString);
          paramString.pausePlaying();
          continue;
          if ("idle".equals(paramObject))
          {
            paramString = this.pausedForPhone.iterator();
            while (paramString.hasNext()) {
              ((AudioPlayer)paramString.next()).startPlaying(null);
            }
            this.pausedForPhone.clear();
          }
        }
      }
    }
    return null;
  }
  
  public void onReset()
  {
    onDestroy();
  }
  
  public void pausePlayingAudio(String paramString)
  {
    paramString = (AudioPlayer)this.players.get(paramString);
    if (paramString != null) {
      paramString.pausePlaying();
    }
  }
  
  public void seekToAudio(String paramString, int paramInt)
  {
    paramString = (AudioPlayer)this.players.get(paramString);
    if (paramString != null) {
      paramString.seekToPlaying(paramInt);
    }
  }
  
  public void setAudioOutputDevice(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)this.cordova.getActivity().getSystemService("audio");
    if (paramInt == 2) {
      localAudioManager.setRouting(0, 2, -1);
    }
    for (;;)
    {
      return;
      if (paramInt == 1) {
        localAudioManager.setRouting(0, 1, -1);
      } else {
        System.out.println("AudioHandler.setAudioOutputDevice() Error: Unknown output device.");
      }
    }
  }
  
  public void setVolume(String paramString, float paramFloat)
  {
    AudioPlayer localAudioPlayer = (AudioPlayer)this.players.get(paramString);
    if (localAudioPlayer != null) {
      localAudioPlayer.setVolume(paramFloat);
    }
    for (;;)
    {
      return;
      System.out.println("AudioHandler.setVolume() Error: Unknown Audio Player " + paramString);
    }
  }
  
  public void startPlayingAudio(String paramString1, String paramString2)
  {
    AudioPlayer localAudioPlayer2 = (AudioPlayer)this.players.get(paramString1);
    AudioPlayer localAudioPlayer1 = localAudioPlayer2;
    if (localAudioPlayer2 == null)
    {
      localAudioPlayer1 = new AudioPlayer(this, paramString1, paramString2);
      this.players.put(paramString1, localAudioPlayer1);
    }
    localAudioPlayer1.startPlaying(paramString2);
  }
  
  public void startRecordingAudio(String paramString1, String paramString2)
  {
    AudioPlayer localAudioPlayer2 = (AudioPlayer)this.players.get(paramString1);
    AudioPlayer localAudioPlayer1 = localAudioPlayer2;
    if (localAudioPlayer2 == null)
    {
      localAudioPlayer1 = new AudioPlayer(this, paramString1, paramString2);
      this.players.put(paramString1, localAudioPlayer1);
    }
    localAudioPlayer1.startRecording(paramString2);
  }
  
  public void stopPlayingAudio(String paramString)
  {
    paramString = (AudioPlayer)this.players.get(paramString);
    if (paramString != null) {
      paramString.stopPlaying();
    }
  }
  
  public void stopRecordingAudio(String paramString)
  {
    paramString = (AudioPlayer)this.players.get(paramString);
    if (paramString != null) {
      paramString.stopRecording();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\AudioHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */