package org.webrtc;

public class VideoRenderer
{
  private final VideoRenderer.Callbacks callbacks;
  final long nativeVideoRenderer;
  
  private VideoRenderer(long paramLong)
  {
    this.nativeVideoRenderer = paramLong;
    this.callbacks = null;
  }
  
  public VideoRenderer(VideoRenderer.Callbacks paramCallbacks)
  {
    this.nativeVideoRenderer = nativeWrapVideoRenderer(paramCallbacks);
    this.callbacks = paramCallbacks;
  }
  
  public static VideoRenderer createGui(int paramInt1, int paramInt2)
  {
    long l = nativeCreateGuiVideoRenderer(paramInt1, paramInt2);
    if (l == 0L) {}
    for (VideoRenderer localVideoRenderer = null;; localVideoRenderer = new VideoRenderer(l)) {
      return localVideoRenderer;
    }
  }
  
  private static native void freeGuiVideoRenderer(long paramLong);
  
  private static native void freeWrappedVideoRenderer(long paramLong);
  
  private static native long nativeCreateGuiVideoRenderer(int paramInt1, int paramInt2);
  
  private static native long nativeWrapVideoRenderer(VideoRenderer.Callbacks paramCallbacks);
  
  public void dispose()
  {
    if (this.callbacks == null) {
      freeGuiVideoRenderer(this.nativeVideoRenderer);
    }
    for (;;)
    {
      return;
      freeWrappedVideoRenderer(this.nativeVideoRenderer);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */