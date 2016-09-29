package com.alipay.sdk.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class PayTask$1$2
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(2.class, 60);
  }
  
  PayTask$1$2(PayTask.1 param1) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */