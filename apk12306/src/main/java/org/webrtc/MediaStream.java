package org.webrtc;

import java.util.LinkedList;

public class MediaStream
{
  public final LinkedList<AudioTrack> audioTracks = new LinkedList();
  final long nativeStream;
  public final LinkedList<VideoTrack> videoTracks = new LinkedList();
  
  public MediaStream(long paramLong)
  {
    this.nativeStream = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native boolean nativeAddAudioTrack(long paramLong1, long paramLong2);
  
  private static native boolean nativeAddVideoTrack(long paramLong1, long paramLong2);
  
  private static native String nativeLabel(long paramLong);
  
  private static native boolean nativeRemoveAudioTrack(long paramLong1, long paramLong2);
  
  private static native boolean nativeRemoveVideoTrack(long paramLong1, long paramLong2);
  
  public boolean addTrack(AudioTrack paramAudioTrack)
  {
    if (nativeAddAudioTrack(this.nativeStream, paramAudioTrack.nativeTrack)) {
      this.audioTracks.add(paramAudioTrack);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean addTrack(VideoTrack paramVideoTrack)
  {
    if (nativeAddVideoTrack(this.nativeStream, paramVideoTrack.nativeTrack)) {
      this.videoTracks.add(paramVideoTrack);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void dispose()
  {
    Object localObject;
    while (!this.audioTracks.isEmpty())
    {
      localObject = (AudioTrack)this.audioTracks.getFirst();
      removeTrack((AudioTrack)localObject);
      ((AudioTrack)localObject).dispose();
    }
    while (!this.videoTracks.isEmpty())
    {
      localObject = (VideoTrack)this.videoTracks.getFirst();
      removeTrack((VideoTrack)localObject);
      ((VideoTrack)localObject).dispose();
    }
    free(this.nativeStream);
  }
  
  public String label()
  {
    return nativeLabel(this.nativeStream);
  }
  
  public boolean removeTrack(AudioTrack paramAudioTrack)
  {
    if (nativeRemoveAudioTrack(this.nativeStream, paramAudioTrack.nativeTrack)) {
      this.audioTracks.remove(paramAudioTrack);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean removeTrack(VideoTrack paramVideoTrack)
  {
    if (nativeRemoveVideoTrack(this.nativeStream, paramVideoTrack.nativeTrack)) {
      this.videoTracks.remove(paramVideoTrack);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String toString()
  {
    return "[" + label() + ":A=" + this.audioTracks.size() + ":V=" + this.videoTracks.size() + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */