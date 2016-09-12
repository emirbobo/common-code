package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;

public class LogUtils
{
  private static final boolean a = false;
  private static final String b = "sdk";
  
  static
  {
    JniLib.a(LogUtils.class, 135);
  }
  
  public static native void a(Object paramObject);
  
  public static native void a(String paramString);
  
  public static native void a(String paramString1, String paramString2);
  
  public static native void b(String paramString);
  
  public static native void b(String paramString1, String paramString2);
  
  public static native void c(String paramString);
  
  public static native void c(String paramString1, String paramString2);
  
  public static native void d(String paramString);
  
  public static native void d(String paramString1, String paramString2);
  
  public static native void e(String paramString);
  
  public static native void e(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */