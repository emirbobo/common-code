package com.worklight.androidgap.jsonstore.security;

import com.bangcle.andjni.JniLib;

public class FipsWrapper
{
  static
  {
    JniLib.a(FipsWrapper.class, 1158);
    System.loadLibrary("openssl_fips");
  }
  
  private static native byte[] _decryptAES(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3);
  
  private static native int _disableFips();
  
  private static native int _enableFips();
  
  private static native byte[] _encryptAES(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, String paramString, int paramInt3);
  
  private static native int _getFipsMode();
  
  private static native int _setFips(int paramInt);
  
  public static native String decryptAES(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public static native int disableFips();
  
  public static native int enableFips();
  
  public static native byte[] encryptAES(String paramString1, String paramString2, String paramString3);
  
  public static native int getFipsMode();
  
  public static native int setFips(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\security\FipsWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */