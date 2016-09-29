package org.apache.cordova;

import java.util.LinkedList;

class NativeToJsMessageQueue$OnlineEventsBridgeMode$1
  implements Runnable
{
  NativeToJsMessageQueue$OnlineEventsBridgeMode$1(NativeToJsMessageQueue.OnlineEventsBridgeMode paramOnlineEventsBridgeMode) {}
  
  public void run()
  {
    NativeToJsMessageQueue.OnlineEventsBridgeMode localOnlineEventsBridgeMode;
    if (!NativeToJsMessageQueue.access$500(this.this$1.this$0).isEmpty())
    {
      localOnlineEventsBridgeMode = this.this$1;
      if (this.this$1.online) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      localOnlineEventsBridgeMode.online = bool;
      NativeToJsMessageQueue.access$300(this.this$1.this$0).setNetworkAvailable(this.this$1.online);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$OnlineEventsBridgeMode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */