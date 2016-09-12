package org.webrtc;

public class VideoCapturer
{
  private long nativeVideoCapturer;
  
  private VideoCapturer(long paramLong)
  {
    this.nativeVideoCapturer = paramLong;
  }
  
  public static VideoCapturer create(String paramString)
  {
    long l = nativeCreateVideoCapturer(paramString);
    if (l == 0L) {}
    for (paramString = null;; paramString = new VideoCapturer(l)) {
      return paramString;
    }
  }
  
  private static native void free(long paramLong);
  
  private static native long nativeCreateVideoCapturer(String paramString);
  
  public void dispose()
  {
    if (this.nativeVideoCapturer != 0L) {
      free(this.nativeVideoCapturer);
    }
  }
  
  long takeNativeVideoCapturer()
  {
    if (this.nativeVideoCapturer == 0L) {
      throw new RuntimeException("Capturer can only be taken once!");
    }
    long l = this.nativeVideoCapturer;
    this.nativeVideoCapturer = 0L;
    return l;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoCapturer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */