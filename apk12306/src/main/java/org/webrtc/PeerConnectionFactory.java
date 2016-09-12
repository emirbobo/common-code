package org.webrtc;

import java.util.List;

public class PeerConnectionFactory
{
  private final long nativeFactory = nativeCreatePeerConnectionFactory();
  
  static
  {
    System.loadLibrary("Arrownock");
  }
  
  public PeerConnectionFactory()
  {
    if (this.nativeFactory == 0L) {
      throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
    }
  }
  
  private static native void freeFactory(long paramLong);
  
  public static native boolean initializeAndroidGlobals(Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject2);
  
  private static native long nativeCreateAudioSource(long paramLong, MediaConstraints paramMediaConstraints);
  
  private static native long nativeCreateAudioTrack(long paramLong1, String paramString, long paramLong2);
  
  private static native long nativeCreateLocalMediaStream(long paramLong, String paramString);
  
  private static native long nativeCreateObserver(PeerConnection.Observer paramObserver);
  
  private static native long nativeCreatePeerConnection(long paramLong1, List<PeerConnection.IceServer> paramList, MediaConstraints paramMediaConstraints, long paramLong2);
  
  private static native long nativeCreatePeerConnectionFactory();
  
  private static native long nativeCreateVideoSource(long paramLong1, long paramLong2, MediaConstraints paramMediaConstraints);
  
  private static native long nativeCreateVideoTrack(long paramLong1, String paramString, long paramLong2);
  
  public AudioSource createAudioSource(MediaConstraints paramMediaConstraints)
  {
    return new AudioSource(nativeCreateAudioSource(this.nativeFactory, paramMediaConstraints));
  }
  
  public AudioTrack createAudioTrack(String paramString, AudioSource paramAudioSource)
  {
    return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, paramString, paramAudioSource.nativeSource));
  }
  
  public MediaStream createLocalMediaStream(String paramString)
  {
    return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, paramString));
  }
  
  public PeerConnection createPeerConnection(List<PeerConnection.IceServer> paramList, MediaConstraints paramMediaConstraints, PeerConnection.Observer paramObserver)
  {
    long l2 = nativeCreateObserver(paramObserver);
    if (l2 == 0L) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      long l1 = nativeCreatePeerConnection(this.nativeFactory, paramList, paramMediaConstraints, l2);
      if (l1 == 0L) {
        paramList = null;
      } else {
        paramList = new PeerConnection(l1, l2);
      }
    }
  }
  
  public VideoSource createVideoSource(VideoCapturer paramVideoCapturer, MediaConstraints paramMediaConstraints)
  {
    return new VideoSource(nativeCreateVideoSource(this.nativeFactory, paramVideoCapturer.takeNativeVideoCapturer(), paramMediaConstraints));
  }
  
  public VideoTrack createVideoTrack(String paramString, VideoSource paramVideoSource)
  {
    return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, paramString, paramVideoSource.nativeSource));
  }
  
  public void dispose()
  {
    freeFactory(this.nativeFactory);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\PeerConnectionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */