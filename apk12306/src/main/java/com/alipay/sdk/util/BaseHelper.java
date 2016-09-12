package com.alipay.sdk.util;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bangcle.andjni.JniLib;

public class BaseHelper
{
  static
  {
    JniLib.a(BaseHelper.class, 127);
  }
  
  public static native String a();
  
  public static native String a(int paramInt);
  
  public static native String a(Context paramContext);
  
  public static native String a(String paramString);
  
  public static native void a(Context paramContext, String paramString);
  
  public static native void a(String paramString1, String paramString2);
  
  public static native String b();
  
  public static native String b(Context paramContext);
  
  public static native DisplayMetrics c(Context paramContext);
  
  public static native String c();
  
  public static native String d(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\BaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */