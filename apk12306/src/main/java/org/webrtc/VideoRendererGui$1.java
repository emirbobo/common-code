package org.webrtc;

import java.util.concurrent.CountDownLatch;

final class VideoRendererGui$1
  implements Runnable
{
  VideoRendererGui$1(VideoRendererGui.YuvImageRenderer paramYuvImageRenderer, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    VideoRendererGui.YuvImageRenderer.access$800(this.val$yuvImageRenderer, VideoRendererGui.access$600(VideoRendererGui.access$200()), VideoRendererGui.access$700(VideoRendererGui.access$200()));
    this.val$yuvImageRenderer.setScreenSize(VideoRendererGui.access$300(VideoRendererGui.access$200()), VideoRendererGui.access$400(VideoRendererGui.access$200()));
    this.val$countDownLatch.countDown();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoRendererGui$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */