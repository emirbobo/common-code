package com.alipay.sdk.widget;

import android.content.DialogInterface.OnCancelListener;
import com.bangcle.andjni.JniLib;

class Loading$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 140);
  }
  
  Loading$1(Loading paramLoading, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener, CharSequence paramCharSequence) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\widget\Loading$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */