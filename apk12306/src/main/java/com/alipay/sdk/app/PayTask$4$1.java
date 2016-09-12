package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class PayTask$4$1
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(1.class, 64);
  }
  
  PayTask$4$1(PayTask.4 param4) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */