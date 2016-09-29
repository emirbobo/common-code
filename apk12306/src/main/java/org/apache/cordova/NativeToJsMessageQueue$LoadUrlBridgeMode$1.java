package org.apache.cordova;

class NativeToJsMessageQueue$LoadUrlBridgeMode$1
  implements Runnable
{
  NativeToJsMessageQueue$LoadUrlBridgeMode$1(NativeToJsMessageQueue.LoadUrlBridgeMode paramLoadUrlBridgeMode) {}
  
  public void run()
  {
    String str = NativeToJsMessageQueue.access$200(this.this$1.this$0);
    if (str != null) {
      NativeToJsMessageQueue.access$300(this.this$1.this$0).loadUrlNow("javascript:" + str);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$LoadUrlBridgeMode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */