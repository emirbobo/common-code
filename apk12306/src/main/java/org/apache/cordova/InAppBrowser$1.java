package org.apache.cordova;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class InAppBrowser$1
  implements Runnable
{
  InAppBrowser$1(InAppBrowser paramInAppBrowser, String paramString1, String paramString2, HashMap paramHashMap, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    Object localObject = "";
    if ("_self".equals(this.val$target))
    {
      Log.d("InAppBrowser", "in self");
      if ((this.val$url.startsWith("file://")) || (this.val$url.startsWith("javascript:")) || (Config.isUrlWhiteListed(this.val$url))) {
        this.this$0.webView.loadUrl(this.val$url);
      }
    }
    for (;;)
    {
      localObject = new PluginResult(PluginResult.Status.OK, (String)localObject);
      ((PluginResult)localObject).setKeepCallback(true);
      this.val$callbackContext.sendPluginResult((PluginResult)localObject);
      return;
      if (this.val$url.startsWith("tel:"))
      {
        try
        {
          Intent localIntent = new android/content/Intent;
          localIntent.<init>("android.intent.action.DIAL");
          localIntent.setData(Uri.parse(this.val$url));
          this.this$0.cordova.getActivity().startActivity(localIntent);
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          LOG.e("InAppBrowser", "Error dialing " + this.val$url + ": " + localActivityNotFoundException.toString());
        }
      }
      else
      {
        localObject = this.this$0.showWebPage(this.val$url, this.val$features);
        continue;
        if ("_system".equals(this.val$target))
        {
          Log.d("InAppBrowser", "in system");
          localObject = this.this$0.openExternal(this.val$url);
        }
        else
        {
          Log.d("InAppBrowser", "in blank");
          localObject = this.this$0.showWebPage(this.val$url, this.val$features);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */