package org.webrtc;

import java.util.LinkedList;

public class VideoTrack
  extends MediaStreamTrack
{
  private final LinkedList<VideoRenderer> renderers = new LinkedList();
  
  public VideoTrack(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void free(long paramLong);
  
  private static native void nativeAddRenderer(long paramLong1, long paramLong2);
  
  private static native void nativeRemoveRenderer(long paramLong1, long paramLong2);
  
  public void addRenderer(VideoRenderer paramVideoRenderer)
  {
    this.renderers.add(paramVideoRenderer);
    nativeAddRenderer(this.nativeTrack, paramVideoRenderer.nativeVideoRenderer);
  }
  
  public void dispose()
  {
    while (!this.renderers.isEmpty()) {
      removeRenderer((VideoRenderer)this.renderers.getFirst());
    }
    super.dispose();
  }
  
  public void removeRenderer(VideoRenderer paramVideoRenderer)
  {
    if (!this.renderers.remove(paramVideoRenderer)) {}
    for (;;)
    {
      return;
      nativeRemoveRenderer(this.nativeTrack, paramVideoRenderer.nativeVideoRenderer);
      paramVideoRenderer.dispose();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */