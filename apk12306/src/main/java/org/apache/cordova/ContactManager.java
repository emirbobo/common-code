package org.apache.cordova;

import android.os.Build.VERSION;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactManager
  extends CordovaPlugin
{
  public static final int INVALID_ARGUMENT_ERROR = 1;
  public static final int IO_ERROR = 4;
  private static final String LOG_TAG = "Contact Query";
  public static final int NOT_SUPPORTED_ERROR = 5;
  public static final int PENDING_OPERATION_ERROR = 3;
  public static final int PERMISSION_DENIED_ERROR = 20;
  public static final int TIMEOUT_ERROR = 2;
  public static final int UNKNOWN_ERROR = 0;
  private ContactAccessor contactAccessor;
  
  public boolean execute(final String paramString, final JSONArray paramJSONArray, final CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    if (Build.VERSION.RELEASE.startsWith("1.")) {
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 5));
    }
    for (;;)
    {
      return bool;
      if (this.contactAccessor == null) {
        this.contactAccessor = new ContactAccessorSdk5(this.webView, this.cordova);
      }
      if (paramString.equals("search"))
      {
        paramString = paramJSONArray.getJSONArray(0);
        paramJSONArray = paramJSONArray.getJSONObject(1);
        this.cordova.getThreadPool().execute(new Runnable()
        {
          public void run()
          {
            JSONArray localJSONArray = ContactManager.this.contactAccessor.search(paramString, paramJSONArray);
            paramCallbackContext.success(localJSONArray);
          }
        });
      }
      else if (paramString.equals("save"))
      {
        paramString = paramJSONArray.getJSONObject(0);
        this.cordova.getThreadPool().execute(new Runnable()
        {
          public void run()
          {
            Object localObject3 = null;
            String str = ContactManager.this.contactAccessor.save(paramString);
            Object localObject1 = localObject3;
            if (str != null) {}
            try
            {
              localObject1 = ContactManager.this.contactAccessor.getContactById(str);
              if (localObject1 != null)
              {
                paramCallbackContext.success((JSONObject)localObject1);
                return;
              }
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Log.e("Contact Query", "JSON fail.", localJSONException);
                Object localObject2 = localObject3;
                continue;
                paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
              }
            }
          }
        });
      }
      else if (paramString.equals("remove"))
      {
        paramString = paramJSONArray.getString(0);
        this.cordova.getThreadPool().execute(new Runnable()
        {
          public void run()
          {
            if (ContactManager.this.contactAccessor.remove(paramString)) {
              paramCallbackContext.success();
            }
            for (;;)
            {
              return;
              paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
            }
          }
        });
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */