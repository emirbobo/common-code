package com.alipay.sdk.encrypt;

import com.bangcle.andjni.JniLib;

public class Des
{
  static
  {
    JniLib.a(Des.class, 104);
  }
  
  public static native String a(int paramInt, String paramString1, String paramString2);
  
  public static native String a(String paramString1, String paramString2);
  
  public static native String b(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\encrypt\Des.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */