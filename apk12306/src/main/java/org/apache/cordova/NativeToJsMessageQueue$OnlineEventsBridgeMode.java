package org.apache.cordova;

import android.app.Activity;
import java.util.LinkedList;
import org.apache.cordova.api.CordovaInterface;

class NativeToJsMessageQueue$OnlineEventsBridgeMode
  implements NativeToJsMessageQueue.BridgeMode
{
  boolean online = true;
  final Runnable runnable = new Runnable()
  {
    public void run()
    {
      NativeToJsMessageQueue.OnlineEventsBridgeMode localOnlineEventsBridgeMode;
      if (!NativeToJsMessageQueue.access$500(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.this$0).isEmpty())
      {
        localOnlineEventsBridgeMode = NativeToJsMessageQueue.OnlineEventsBridgeMode.this;
        if (NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online) {
          break label59;
        }
      }
      label59:
      for (boolean bool = true;; bool = false)
      {
        localOnlineEventsBridgeMode.online = bool;
        NativeToJsMessageQueue.access$300(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.this$0).setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online);
        return;
      }
    }
  };
  
  NativeToJsMessageQueue$OnlineEventsBridgeMode(NativeToJsMessageQueue paramNativeToJsMessageQueue)
  {
    NativeToJsMessageQueue.access$300(paramNativeToJsMessageQueue).setNetworkAvailable(true);
  }
  
  public void onNativeToJsMessageAvailable()
  {
    NativeToJsMessageQueue.access$400(this.this$0).getActivity().runOnUiThread(this.runnable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$OnlineEventsBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */