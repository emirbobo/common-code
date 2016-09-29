package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;

class ContactManager$1
  implements Runnable
{
  ContactManager$1(ContactManager paramContactManager, JSONArray paramJSONArray, JSONObject paramJSONObject, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    JSONArray localJSONArray = ContactManager.access$000(this.this$0).search(this.val$filter, this.val$options);
    this.val$callbackContext.success(localJSONArray);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */