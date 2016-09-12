package org.apache.cordova;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class ContactManager$3
  implements Runnable
{
  ContactManager$3(ContactManager paramContactManager, String paramString, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    if (ContactManager.access$000(this.this$0).remove(this.val$contactId)) {
      this.val$callbackContext.success();
    }
    for (;;)
    {
      return;
      this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 0));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactManager$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */