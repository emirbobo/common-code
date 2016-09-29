package org.apache.cordova.api;

import java.util.concurrent.ExecutorService;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public abstract class Plugin
  extends CordovaPlugin
{
  public LegacyContext ctx;
  
  public void error(String paramString1, String paramString2)
  {
    this.webView.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramString1), paramString2);
  }
  
  public void error(PluginResult paramPluginResult, String paramString)
  {
    this.webView.sendPluginResult(paramPluginResult, paramString);
  }
  
  public void error(JSONObject paramJSONObject, String paramString)
  {
    this.webView.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramJSONObject), paramString);
  }
  
  public abstract PluginResult execute(String paramString1, JSONArray paramJSONArray, String paramString2);
  
  public boolean execute(final String paramString, final JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    final String str = paramCallbackContext.getCallbackId();
    int i;
    if (!isSynch(paramString))
    {
      i = 1;
      if (i == 0) {
        break label56;
      }
      this.cordova.getThreadPool().execute(new Runnable()
      {
        public void run()
        {
          try
          {
            PluginResult localPluginResult1 = Plugin.this.execute(paramString, paramJSONArray, str);
            Plugin.this.sendPluginResult(localPluginResult1, str);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              PluginResult localPluginResult2 = new PluginResult(PluginResult.Status.ERROR, localThrowable.getMessage());
            }
          }
        }
      });
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label56:
      paramJSONArray = execute(paramString, paramJSONArray, str);
      paramString = paramJSONArray;
      if (paramJSONArray == null) {
        paramString = new PluginResult(PluginResult.Status.NO_RESULT);
      }
      paramCallbackContext.sendPluginResult(paramString);
    }
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    setContext(paramCordovaInterface);
    setView(paramCordovaWebView);
  }
  
  public boolean isSynch(String paramString)
  {
    return false;
  }
  
  public void sendJavascript(String paramString)
  {
    this.webView.sendJavascript(paramString);
  }
  
  public void sendPluginResult(PluginResult paramPluginResult, String paramString)
  {
    this.webView.sendPluginResult(paramPluginResult, paramString);
  }
  
  public void setContext(CordovaInterface paramCordovaInterface)
  {
    this.cordova = paramCordovaInterface;
    this.ctx = new LegacyContext(this.cordova);
  }
  
  public void setView(CordovaWebView paramCordovaWebView)
  {
    this.webView = paramCordovaWebView;
  }
  
  public void success(String paramString1, String paramString2)
  {
    this.webView.sendPluginResult(new PluginResult(PluginResult.Status.OK, paramString1), paramString2);
  }
  
  public void success(PluginResult paramPluginResult, String paramString)
  {
    this.webView.sendPluginResult(paramPluginResult, paramString);
  }
  
  public void success(JSONObject paramJSONObject, String paramString)
  {
    this.webView.sendPluginResult(new PluginResult(PluginResult.Status.OK, paramJSONObject), paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\api\Plugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */