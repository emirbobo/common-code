package org.apache.cordova;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import org.apache.cordova.api.CordovaInterface;

class Notification$4
  implements Runnable
{
  Notification$4(Notification paramNotification, CordovaInterface paramCordovaInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.spinnerDialog = ProgressDialog.show(this.val$cordova.getActivity(), this.val$title, this.val$message, true, true, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        Notification.4.this.this$0.spinnerDialog = null;
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */