package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;
import com.bangcle.andjni.JniLib;

class H5PayActivity$MyWebChromeClient$2
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(2.class, 50);
  }
  
  H5PayActivity$MyWebChromeClient$2(H5PayActivity.MyWebChromeClient paramMyWebChromeClient, JsResult paramJsResult) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\H5PayActivity$MyWebChromeClient$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */