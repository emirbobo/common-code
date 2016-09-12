package org.webrtc;

public abstract interface PeerConnection$Observer
{
  public abstract void onAddStream(MediaStream paramMediaStream);
  
  public abstract void onDataChannel(DataChannel paramDataChannel);
  
  public abstract void onIceCandidate(IceCandidate paramIceCandidate);
  
  public abstract void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState);
  
  public abstract void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState);
  
  public abstract void onRemoveStream(MediaStream paramMediaStream);
  
  public abstract void onRenegotiationNeeded();
  
  public abstract void onSignalingChange(PeerConnection.SignalingState paramSignalingState);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\PeerConnection$Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */