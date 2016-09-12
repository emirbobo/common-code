package org.apache.cordova;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class Notification$1
  implements Runnable
{
  Notification$1(Notification paramNotification, CordovaInterface paramCordovaInterface, String paramString1, String paramString2, String paramString3, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.val$cordova.getActivity());
    localBuilder.setMessage(this.val$message);
    localBuilder.setTitle(this.val$title);
    localBuilder.setCancelable(true);
    localBuilder.setPositiveButton(this.val$buttonLabel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        Notification.1.this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
      }
    });
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramAnonymousDialogInterface.dismiss();
        Notification.1.this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
      }
    });
    localBuilder.create();
    localBuilder.show();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */