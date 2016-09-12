package org.apache.cordova;

import android.webkit.JavascriptInterface;
import org.apache.cordova.api.PluginManager;
import org.json.JSONException;

class ExposedJsApi
{
  private NativeToJsMessageQueue jsMessageQueue;
  private PluginManager pluginManager;
  
  public ExposedJsApi(PluginManager paramPluginManager, NativeToJsMessageQueue paramNativeToJsMessageQueue)
  {
    this.pluginManager = paramPluginManager;
    this.jsMessageQueue = paramNativeToJsMessageQueue;
  }
  
  @JavascriptInterface
  public String exec(String paramString1, String paramString2, String paramString3, String paramString4)
    throws JSONException
  {
    this.jsMessageQueue.setPaused(true);
    try
    {
      this.pluginManager.exec(paramString1, paramString2, paramString3, paramString4);
      paramString1 = this.jsMessageQueue.popAndEncode();
      return paramString1;
    }
    finally
    {
      this.jsMessageQueue.setPaused(false);
    }
  }
  
  @JavascriptInterface
  public String retrieveJsMessages()
  {
    return this.jsMessageQueue.popAndEncode();
  }
  
  @JavascriptInterface
  public void setNativeToJsBridgeMode(int paramInt)
  {
    this.jsMessageQueue.setBridgeMode(paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ExposedJsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */