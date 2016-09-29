package com.alipay.sdk.encrypt;

import com.bangcle.andjni.JniLib;

public class MD5
{
  static
  {
    JniLib.a(MD5.class, 105);
  }
  
  public static native String a(String paramString);
  
  public static native String a(byte[] paramArrayOfByte);
  
  private static native String b(byte[] paramArrayOfByte);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\encrypt\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */