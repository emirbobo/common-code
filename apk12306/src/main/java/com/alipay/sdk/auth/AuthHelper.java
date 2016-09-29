package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Context;
import com.bangcle.andjni.JniLib;

public class AuthHelper
{
  private static final String a = "com.eg.android.AlipayGphone";
  private static final int b = 65;
  
  static
  {
    JniLib.a(AuthHelper.class, 92);
  }
  
  public static native void a(Activity paramActivity, APAuthInfo paramAPAuthInfo);
  
  public static native void a(Activity paramActivity, String paramString);
  
  private static native boolean a(Context paramContext);
  
  private static native void b(Activity paramActivity, APAuthInfo paramAPAuthInfo);
  
  private static native void c(Activity paramActivity, APAuthInfo paramAPAuthInfo);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AuthHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */