package com.alipay.sdk.app;

import com.bangcle.andjni.JniLib;

public class Result
{
  private static String a;
  
  static
  {
    JniLib.a(Result.class, 73);
  }
  
  public static native String a();
  
  public static native String a(int paramInt, String paramString1, String paramString2);
  
  public static native void a(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */