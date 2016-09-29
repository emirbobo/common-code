package org.webrtc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeerConnection
{
  private final List<MediaStream> localStreams;
  private final long nativeObserver;
  private final long nativePeerConnection;
  
  static
  {
    System.loadLibrary("Arrownock");
  }
  
  PeerConnection(long paramLong1, long paramLong2)
  {
    this.nativePeerConnection = paramLong1;
    this.nativeObserver = paramLong2;
    this.localStreams = new LinkedList();
  }
  
  private static native void freeObserver(long paramLong);
  
  private static native void freePeerConnection(long paramLong);
  
  private native boolean nativeAddIceCandidate(String paramString1, int paramInt, String paramString2);
  
  private native boolean nativeAddLocalStream(long paramLong);
  
  private native boolean nativeGetStats(StatsObserver paramStatsObserver, long paramLong);
  
  private native void nativeRemoveLocalStream(long paramLong);
  
  public boolean addIceCandidate(IceCandidate paramIceCandidate)
  {
    return nativeAddIceCandidate(paramIceCandidate.sdpMid, paramIceCandidate.sdpMLineIndex, paramIceCandidate.sdp);
  }
  
  public boolean addStream(MediaStream paramMediaStream)
  {
    if (!nativeAddLocalStream(paramMediaStream.nativeStream)) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.localStreams.add(paramMediaStream);
    }
  }
  
  public native void close();
  
  public native void createAnswer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);
  
  public native DataChannel createDataChannel(String paramString, DataChannel.Init paramInit);
  
  public native void createOffer(SdpObserver paramSdpObserver, MediaConstraints paramMediaConstraints);
  
  public void dispose()
  {
    close();
    Iterator localIterator = this.localStreams.iterator();
    while (localIterator.hasNext())
    {
      MediaStream localMediaStream = (MediaStream)localIterator.next();
      nativeRemoveLocalStream(localMediaStream.nativeStream);
      localMediaStream.dispose();
    }
    this.localStreams.clear();
    freePeerConnection(this.nativePeerConnection);
    freeObserver(this.nativeObserver);
  }
  
  public native SessionDescription getLocalDescription();
  
  public native SessionDescription getRemoteDescription();
  
  public boolean getStats(StatsObserver paramStatsObserver, MediaStreamTrack paramMediaStreamTrack)
  {
    if (paramMediaStreamTrack == null) {}
    for (long l = 0L;; l = paramMediaStreamTrack.nativeTrack) {
      return nativeGetStats(paramStatsObserver, l);
    }
  }
  
  public native PeerConnection.IceConnectionState iceConnectionState();
  
  public native PeerConnection.IceGatheringState iceGatheringState();
  
  public void removeStream(MediaStream paramMediaStream)
  {
    nativeRemoveLocalStream(paramMediaStream.nativeStream);
    this.localStreams.remove(paramMediaStream);
  }
  
  public native void setLocalDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);
  
  public native void setRemoteDescription(SdpObserver paramSdpObserver, SessionDescription paramSessionDescription);
  
  public native PeerConnection.SignalingState signalingState();
  
  public native boolean updateIce(List<PeerConnection.IceServer> paramList, MediaConstraints paramMediaConstraints);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\PeerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */