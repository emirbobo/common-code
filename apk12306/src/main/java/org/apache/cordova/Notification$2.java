package org.apache.cordova;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

class Notification$2
  implements Runnable
{
  Notification$2(Notification paramNotification, CordovaInterface paramCordovaInterface, String paramString1, String paramString2, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.val$cordova.getActivity());
    localBuilder.setMessage(this.val$message);
    localBuilder.setTitle(this.val$title);
    localBuilder.setCancelable(true);
    if (this.val$buttonLabels.length() > 0) {}
    try
    {
      String str = this.val$buttonLabels.getString(0);
      Object localObject = new org/apache/cordova/Notification$2$1;
      ((1)localObject).<init>(this);
      localBuilder.setNegativeButton(str, (DialogInterface.OnClickListener)localObject);
      if (this.val$buttonLabels.length() > 1) {}
      try
      {
        str = this.val$buttonLabels.getString(1);
        localObject = new org/apache/cordova/Notification$2$2;
        ((2)localObject).<init>(this);
        localBuilder.setNeutralButton(str, (DialogInterface.OnClickListener)localObject);
        if (this.val$buttonLabels.length() > 2) {}
        try
        {
          str = this.val$buttonLabels.getString(2);
          localObject = new org/apache/cordova/Notification$2$3;
          ((3)localObject).<init>(this);
          localBuilder.setPositiveButton(str, (DialogInterface.OnClickListener)localObject);
          localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              paramAnonymousDialogInterface.dismiss();
              Notification.2.this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
            }
          });
          localBuilder.create();
          localBuilder.show();
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;) {}
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
    }
    catch (JSONException localJSONException3)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */