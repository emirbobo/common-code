package org.webrtc;

public class MediaStreamTrack
{
  final long nativeTrack;
  
  public MediaStreamTrack(long paramLong)
  {
    this.nativeTrack = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native boolean nativeEnabled(long paramLong);
  
  private static native String nativeId(long paramLong);
  
  private static native String nativeKind(long paramLong);
  
  private static native boolean nativeSetEnabled(long paramLong, boolean paramBoolean);
  
  private static native boolean nativeSetState(long paramLong, int paramInt);
  
  private static native MediaStreamTrack.State nativeState(long paramLong);
  
  public void dispose()
  {
    free(this.nativeTrack);
  }
  
  public boolean enabled()
  {
    return nativeEnabled(this.nativeTrack);
  }
  
  public String id()
  {
    return nativeId(this.nativeTrack);
  }
  
  public String kind()
  {
    return nativeKind(this.nativeTrack);
  }
  
  public boolean setEnabled(boolean paramBoolean)
  {
    return nativeSetEnabled(this.nativeTrack, paramBoolean);
  }
  
  public boolean setState(MediaStreamTrack.State paramState)
  {
    return nativeSetState(this.nativeTrack, paramState.ordinal());
  }
  
  public MediaStreamTrack.State state()
  {
    return nativeState(this.nativeTrack);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaStreamTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */