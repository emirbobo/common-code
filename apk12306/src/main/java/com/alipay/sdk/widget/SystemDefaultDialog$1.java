package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.bangcle.andjni.JniLib;

final class SystemDefaultDialog$1
  implements DialogInterface.OnKeyListener
{
  static
  {
    JniLib.a(1.class, 143);
  }
  
  public native boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\widget\SystemDefaultDialog$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */