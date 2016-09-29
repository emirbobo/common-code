package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONException;
import org.json.JSONObject;

class Notification$3$1
  implements DialogInterface.OnClickListener
{
  Notification$3$1(Notification.3 param3, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    try
    {
      this.val$result.put("buttonIndex", 1);
      this.val$result.put("input1", this.this$1.val$promptInput.getText());
      this.this$1.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.val$result));
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */