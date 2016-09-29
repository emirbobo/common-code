package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.bangcle.andjni.JniLib;

public class Utils
{
  static final String a = "com.alipay.android.app";
  static final String b = "com.eg.android.AlipayGphone";
  private static final String c = "7.0.0";
  private static final String d = "5.0.0";
  
  static
  {
    JniLib.a(Utils.class, 139);
  }
  
  public static native String a();
  
  public static native String a(String paramString);
  
  public static native String a(byte[] paramArrayOfByte);
  
  public static native void a(Activity paramActivity, String paramString);
  
  public static native void a(String paramString1, String paramString2);
  
  public static native boolean a(Context paramContext);
  
  public static native boolean a(Context paramContext, String paramString1, String paramString2);
  
  public static native byte[] a(Context paramContext, String paramString);
  
  public static native int b(String paramString1, String paramString2);
  
  public static native PackageInfo b(Context paramContext, String paramString);
  
  public static native String b(String paramString);
  
  public static native boolean b(Context paramContext);
  
  public static native boolean c(Context paramContext);
  
  public static native boolean c(Context paramContext, String paramString);
  
  public static native boolean c(String paramString);
  
  public static native NetConnectionType d(Context paramContext);
  
  public static native boolean e(Context paramContext);
  
  public static native String f(Context paramContext);
  
  public static native String g(Context paramContext);
  
  public static native String h(Context paramContext);
  
  public static native String i(Context paramContext);
  
  public static native String j(Context paramContext);
  
  public static native DisplayMetrics k(Context paramContext);
  
  private static native String l(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */