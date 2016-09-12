package com.alipay.sdk.encrypt;

import com.bangcle.andjni.JniLib;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Rsa
{
  public static final String a = "SHA1WithRSA";
  private static final String b = "RSA";
  
  static
  {
    JniLib.a(Rsa.class, 106);
  }
  
  public static native String a(String paramString1, String paramString2);
  
  public static native boolean a(String paramString1, String paramString2, String paramString3);
  
  public static native String b(String paramString1, String paramString2);
  
  public static native String c(String paramString1, String paramString2);
  
  private static native PublicKey d(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\encrypt\Rsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */