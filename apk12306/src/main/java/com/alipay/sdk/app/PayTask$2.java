package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.alipay.sdk.widget.Loading;
import com.bangcle.andjni.JniLib;

class PayTask$2
  implements DialogInterface.OnCancelListener
{
  static
  {
    JniLib.a(2.class, 62);
  }
  
  PayTask$2(PayTask paramPayTask, Loading paramLoading) {}
  
  public native void onCancel(DialogInterface paramDialogInterface);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */