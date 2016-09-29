package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import com.bangcle.andjni.JniLib;

class H5PayActivity$MyWebChromeClient$6
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(6.class, 54);
  }
  
  H5PayActivity$MyWebChromeClient$6(H5PayActivity.MyWebChromeClient paramMyWebChromeClient, JsPromptResult paramJsPromptResult) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\H5PayActivity$MyWebChromeClient$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */