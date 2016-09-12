package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;

public class SplashScreen
  extends CordovaPlugin
{
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    if (paramString.equals("hide"))
    {
      this.webView.postMessage("splashscreen", "hide");
      paramCallbackContext.success();
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (paramString.equals("show"))
      {
        this.webView.postMessage("splashscreen", "show");
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\SplashScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */