package org.apache.cordova;

import android.app.Activity;
import org.apache.cordova.api.CordovaInterface;

class NativeToJsMessageQueue$LoadUrlBridgeMode
  implements NativeToJsMessageQueue.BridgeMode
{
  final Runnable runnable = new Runnable()
  {
    public void run()
    {
      String str = NativeToJsMessageQueue.access$200(NativeToJsMessageQueue.LoadUrlBridgeMode.this.this$0);
      if (str != null) {
        NativeToJsMessageQueue.access$300(NativeToJsMessageQueue.LoadUrlBridgeMode.this.this$0).loadUrlNow("javascript:" + str);
      }
    }
  };
  
  private NativeToJsMessageQueue$LoadUrlBridgeMode(NativeToJsMessageQueue paramNativeToJsMessageQueue) {}
  
  public void onNativeToJsMessageAvailable()
  {
    NativeToJsMessageQueue.access$400(this.this$0).getActivity().runOnUiThread(this.runnable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$LoadUrlBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */