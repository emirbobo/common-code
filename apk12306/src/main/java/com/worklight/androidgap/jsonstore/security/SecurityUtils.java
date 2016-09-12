package com.worklight.androidgap.jsonstore.security;

import com.bangcle.andjni.JniLib;
import javax.crypto.SecretKey;

public class SecurityUtils
{
  private static final int KEY_SIZE_AES256 = 32;
  protected static final int PBKDF2_ITERATIONS = 10000;
  
  static
  {
    JniLib.a(SecurityUtils.class, 1161);
  }
  
  public static native byte[] decode(String paramString1, String paramString2, String paramString3)
    throws Exception;
  
  public static native String encodeBytesAsHexString(byte[] paramArrayOfByte);
  
  public static native String encodeKeyAsHexString(SecretKey paramSecretKey);
  
  public static native byte[] encrypt(String paramString1, String paramString2, String paramString3)
    throws Exception;
  
  public static native byte[] generateIV(int paramInt);
  
  public static native SecretKey generateKey(String paramString1, String paramString2)
    throws Exception;
  
  public static native byte[] generateLocalKey(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\security\SecurityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */