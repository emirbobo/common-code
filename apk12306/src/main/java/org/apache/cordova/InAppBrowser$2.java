package org.apache.cordova;

import android.webkit.WebView;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class InAppBrowser$2
  implements Runnable
{
  InAppBrowser$2(InAppBrowser paramInAppBrowser, String paramString, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    InAppBrowser.access$000(this.this$0).loadUrl("javascript:" + this.val$finalScriptEnclosure);
    PluginResult localPluginResult = new PluginResult(PluginResult.Status.OK);
    this.val$callbackContext.sendPluginResult(localPluginResult);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */