package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.webkit.JsResult;

class CordovaChromeClient$3
  implements DialogInterface.OnKeyListener
{
  CordovaChromeClient$3(CordovaChromeClient paramCordovaChromeClient, JsResult paramJsResult) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.val$result.confirm();
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaChromeClient$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */