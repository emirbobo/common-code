package org.webrtc;

public class MediaSource
{
  final long nativeSource;
  
  public MediaSource(long paramLong)
  {
    this.nativeSource = paramLong;
  }
  
  private static native void free(long paramLong);
  
  private static native MediaSource.State nativeState(long paramLong);
  
  public void dispose()
  {
    free(this.nativeSource);
  }
  
  public MediaSource.State state()
  {
    return nativeState(this.nativeSource);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */