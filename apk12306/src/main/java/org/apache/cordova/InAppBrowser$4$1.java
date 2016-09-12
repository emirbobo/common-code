package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class InAppBrowser$4$1
  implements DialogInterface.OnDismissListener
{
  InAppBrowser$4$1(InAppBrowser.4 param4) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    try
    {
      paramDialogInterface = new org/json/JSONObject;
      paramDialogInterface.<init>();
      paramDialogInterface.put("type", "exit");
      InAppBrowser.access$200(this.this$1.this$0, paramDialogInterface, false);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      for (;;)
      {
        Log.d("InAppBrowser", "Should never happen");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */