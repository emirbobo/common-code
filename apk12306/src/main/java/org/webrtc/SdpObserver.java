package org.webrtc;

public abstract interface SdpObserver
{
  public abstract void onCreateFailure(String paramString);
  
  public abstract void onCreateSuccess(SessionDescription paramSessionDescription);
  
  public abstract void onSetFailure(String paramString);
  
  public abstract void onSetSuccess();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\SdpObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */