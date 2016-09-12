package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.bangcle.andjni.JniLib;

public class PayHelper
{
  private Activity a;
  private IAlixPay b;
  private Object c;
  private boolean d = false;
  private ServiceConnection e = new PayHelper.1(this);
  private IRemoteServiceCallback f = new PayHelper.2(this);
  
  static
  {
    JniLib.a(PayHelper.class, 138);
  }
  
  public PayHelper(Activity paramActivity)
  {
    this.a = paramActivity;
    this.c = new Object();
  }
  
  private native String a(String paramString, Intent paramIntent);
  
  public native String a(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\PayHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */