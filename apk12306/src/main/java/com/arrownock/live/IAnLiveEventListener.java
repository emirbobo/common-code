package com.arrownock.live;

import com.arrownock.exception.ArrownockException;
import java.util.Date;

public abstract interface IAnLiveEventListener
{
  public abstract void onError(String paramString, ArrownockException paramArrownockException);
  
  public abstract void onLocalVideoSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onLocalVideoViewReady(LocalVideoView paramLocalVideoView);
  
  public abstract void onReceivedInvitation(boolean paramBoolean, String paramString1, String paramString2, String paramString3, Date paramDate);
  
  public abstract void onRemotePartyAudioStateChanged(String paramString, AudioState paramAudioState);
  
  public abstract void onRemotePartyConnected(String paramString);
  
  public abstract void onRemotePartyDisconnected(String paramString);
  
  public abstract void onRemotePartyVideoSizeChanged(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onRemotePartyVideoStateChanged(String paramString, VideoState paramVideoState);
  
  public abstract void onRemotePartyVideoViewReady(String paramString, VideoView paramVideoView);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\live\IAnLiveEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */