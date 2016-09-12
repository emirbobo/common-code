package com.alipay.sdk.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import com.bangcle.andjni.JniLib;

public class Loading
{
  private Activity a;
  private ProgressDialog b;
  
  static
  {
    JniLib.a(Loading.class, 142);
  }
  
  public Loading(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public native void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
  
  public native void a(String paramString);
  
  public native boolean a();
  
  public native void b();
  
  public native void c();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\widget\Loading.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */