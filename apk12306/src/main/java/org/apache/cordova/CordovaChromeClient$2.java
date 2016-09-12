package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

class CordovaChromeClient$2
  implements DialogInterface.OnCancelListener
{
  CordovaChromeClient$2(CordovaChromeClient paramCordovaChromeClient, JsResult paramJsResult) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.val$result.cancel();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaChromeClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */