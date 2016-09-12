package org.webrtc.videoengine;

import java.util.concurrent.Exchanger;

class VideoCaptureAndroid$1
  implements Runnable
{
  VideoCaptureAndroid$1(VideoCaptureAndroid paramVideoCaptureAndroid, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Exchanger paramExchanger) {}
  
  public void run()
  {
    VideoCaptureAndroid.access$100(this.this$0, this.val$width, this.val$height, this.val$min_mfps, this.val$max_mfps, this.val$result);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\VideoCaptureAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */