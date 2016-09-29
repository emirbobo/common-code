package org.apache.cordova;

import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONException;
import org.json.JSONObject;

class ContactManager$2
  implements Runnable
{
  ContactManager$2(ContactManager paramContactManager, JSONObject paramJSONObject, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    Object localObject3 = null;
    String str = ContactManager.access$000(this.this$0).save(this.val$contact);
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      localObject1 = ContactManager.access$000(this.this$0).getContactById(str);
      if (localObject1 != null)
      {
        this.val$callbackContext.success((JSONObject)localObject1);
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
        this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */