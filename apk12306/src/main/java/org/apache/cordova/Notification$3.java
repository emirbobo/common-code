package org.apache.cordova;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Notification$3
  implements Runnable
{
  Notification$3(Notification paramNotification, CordovaInterface paramCordovaInterface, String paramString1, String paramString2, EditText paramEditText, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.val$cordova.getActivity());
    localBuilder.setMessage(this.val$message);
    localBuilder.setTitle(this.val$title);
    localBuilder.setCancelable(true);
    localBuilder.setView(this.val$promptInput);
    final JSONObject localJSONObject = new JSONObject();
    if (this.val$buttonLabels.length() > 0) {}
    try
    {
      String str = this.val$buttonLabels.getString(0);
      Object localObject = new org/apache/cordova/Notification$3$1;
      ((1)localObject).<init>(this, localJSONObject);
      localBuilder.setNegativeButton(str, (DialogInterface.OnClickListener)localObject);
      if (this.val$buttonLabels.length() > 1) {}
      try
      {
        str = this.val$buttonLabels.getString(1);
        localObject = new org/apache/cordova/Notification$3$2;
        ((2)localObject).<init>(this, localJSONObject);
        localBuilder.setNeutralButton(str, (DialogInterface.OnClickListener)localObject);
        if (this.val$buttonLabels.length() > 2) {}
        try
        {
          str = this.val$buttonLabels.getString(2);
          localObject = new org/apache/cordova/Notification$3$3;
          ((3)localObject).<init>(this, localJSONObject);
          localBuilder.setPositiveButton(str, (DialogInterface.OnClickListener)localObject);
          localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              paramAnonymousDialogInterface.dismiss();
              try
              {
                localJSONObject.put("buttonIndex", 0);
                localJSONObject.put("input1", Notification.3.this.val$promptInput.getText());
                Notification.3.this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, localJSONObject));
                return;
              }
              catch (JSONException paramAnonymousDialogInterface)
              {
                for (;;)
                {
                  paramAnonymousDialogInterface.printStackTrace();
                }
              }
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */