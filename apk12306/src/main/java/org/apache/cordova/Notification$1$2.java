package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class Notification$1$2
  implements DialogInterface.OnCancelListener
{
  Notification$1$2(Notification.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    this.this$1.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */