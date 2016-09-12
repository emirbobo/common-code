package org.webrtc;

public class VideoSource
  extends MediaSource
{
  private long nativeVideoFormatAtStop;
  
  public VideoSource(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void freeNativeVideoFormat(long paramLong);
  
  private static native void restart(long paramLong1, long paramLong2);
  
  private static native long stop(long paramLong);
  
  public void dispose()
  {
    if (this.nativeVideoFormatAtStop != 0L)
    {
      freeNativeVideoFormat(this.nativeVideoFormatAtStop);
      this.nativeVideoFormatAtStop = 0L;
    }
    super.dispose();
  }
  
  public void restart()
  {
    restart(this.nativeSource, this.nativeVideoFormatAtStop);
    this.nativeVideoFormatAtStop = 0L;
  }
  
  public void stop()
  {
    this.nativeVideoFormatAtStop = stop(this.nativeSource);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */