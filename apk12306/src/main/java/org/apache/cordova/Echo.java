package org.apache.cordova;

import java.util.concurrent.ExecutorService;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONException;

public class Echo
  extends CordovaPlugin
{
  public boolean execute(final String paramString, CordovaArgs paramCordovaArgs, final CallbackContext paramCallbackContext)
    throws JSONException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool = true;
    if ("echo".equals(paramString)) {
      if (paramCordovaArgs.isNull(0))
      {
        paramString = (String)localObject1;
        paramCallbackContext.success(paramString);
      }
    }
    for (;;)
    {
      return bool;
      paramString = paramCordovaArgs.getString(0);
      break;
      if ("echoAsync".equals(paramString))
      {
        if (paramCordovaArgs.isNull(0)) {}
        for (paramString = (String)localObject2;; paramString = paramCordovaArgs.getString(0))
        {
          this.cordova.getThreadPool().execute(new Runnable()
          {
            public void run()
            {
              paramCallbackContext.success(paramString);
            }
          });
          break;
        }
      }
      if ("echoArrayBuffer".equals(paramString)) {
        paramCallbackContext.success(paramCordovaArgs.getArrayBuffer(0));
      } else {
        bool = false;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Echo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */