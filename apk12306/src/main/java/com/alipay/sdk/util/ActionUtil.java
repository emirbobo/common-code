package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;

public class ActionUtil
{
  private static String a = "#@";
  private static String b = "@#";
  
  static
  {
    JniLib.a(ActionUtil.class, 126);
  }
  
  public static native String a(String paramString1, String paramString2);
  
  public static native String[] a(String paramString);
  
  public static native void b(String paramString);
  
  public static native String c(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\ActionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */