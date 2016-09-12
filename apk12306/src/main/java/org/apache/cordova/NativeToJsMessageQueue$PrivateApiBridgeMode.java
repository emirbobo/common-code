package org.apache.cordova;

import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class NativeToJsMessageQueue$PrivateApiBridgeMode
  implements NativeToJsMessageQueue.BridgeMode
{
  private static final int EXECUTE_JS = 194;
  boolean initFailed;
  Method sendMessageMethod;
  Object webViewCore;
  
  private NativeToJsMessageQueue$PrivateApiBridgeMode(NativeToJsMessageQueue paramNativeToJsMessageQueue) {}
  
  private void initReflection()
  {
    Object localObject2 = NativeToJsMessageQueue.access$300(this.this$0);
    localObject4 = WebView.class;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        Object localObject5 = WebView.class.getDeclaredField("mProvider");
        localObject1 = localObject2;
        ((Field)localObject5).setAccessible(true);
        localObject1 = localObject2;
        localObject2 = ((Field)localObject5).get(NativeToJsMessageQueue.access$300(this.this$0));
        localObject1 = localObject2;
        localObject5 = localObject2.getClass();
        localObject4 = localObject5;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject3 = localObject4;
        continue;
      }
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField("mWebViewCore");
        ((Field)localObject2).setAccessible(true);
        this.webViewCore = ((Field)localObject2).get(localObject1);
        if (this.webViewCore != null)
        {
          this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
          this.sendMessageMethod.setAccessible(true);
        }
        return;
      }
      catch (Throwable localThrowable1)
      {
        this.initFailed = true;
        Log.e("JsMessageQueue", "PrivateApiBridgeMode failed to find the expected APIs.", localThrowable1);
      }
    }
  }
  
  public void onNativeToJsMessageAvailable()
  {
    if ((this.sendMessageMethod == null) && (!this.initFailed)) {
      initReflection();
    }
    Message localMessage;
    if (this.sendMessageMethod != null) {
      localMessage = Message.obtain(null, 194, NativeToJsMessageQueue.access$200(this.this$0));
    }
    try
    {
      this.sendMessageMethod.invoke(this.webViewCore, new Object[] { localMessage });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("JsMessageQueue", "Reflection message bridge failed.", localThrowable);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$PrivateApiBridgeMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */