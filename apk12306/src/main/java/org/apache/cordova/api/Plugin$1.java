package org.apache.cordova.api;

import org.json.JSONArray;

class Plugin$1
  implements Runnable
{
  Plugin$1(Plugin paramPlugin, String paramString1, JSONArray paramJSONArray, String paramString2) {}
  
  public void run()
  {
    try
    {
      PluginResult localPluginResult1 = this.this$0.execute(this.val$action, this.val$args, this.val$callbackId);
      this.this$0.sendPluginResult(localPluginResult1, this.val$callbackId);
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\api\Plugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */