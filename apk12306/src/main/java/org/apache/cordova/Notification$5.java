package org.apache.cordova;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import org.apache.cordova.api.CordovaInterface;

class Notification$5
  implements Runnable
{
  Notification$5(Notification paramNotification1, Notification paramNotification2, CordovaInterface paramCordovaInterface, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.val$notification.progressDialog = new ProgressDialog(this.val$cordova.getActivity());
    this.val$notification.progressDialog.setProgressStyle(1);
    this.val$notification.progressDialog.setTitle(this.val$title);
    this.val$notification.progressDialog.setMessage(this.val$message);
    this.val$notification.progressDialog.setCancelable(true);
    this.val$notification.progressDialog.setMax(100);
    this.val$notification.progressDialog.setProgress(0);
    this.val$notification.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        Notification.5.this.val$notification.progressDialog = null;
      }
    });
    this.val$notification.progressDialog.show();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */