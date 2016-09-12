package com.alipay.mobilesecuritysdk.deviceID;

import com.bangcle.andjni.JniLib;

public class SecurityUtils
{
  public static final String TAG = "SecurityUtils";
  private static String str = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");
  
  static
  {
    JniLib.a(SecurityUtils.class, 40);
  }
  
  private static native void appendHex(StringBuffer paramStringBuffer, byte paramByte);
  
  public static native String decrypt(String paramString1, String paramString2);
  
  private static native byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
  
  public static native String encrypt(String paramString1, String paramString2);
  
  private static native byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception;
  
  public static native String fromHex(String paramString);
  
  private static native byte[] getRawKey(byte[] paramArrayOfByte)
    throws Exception;
  
  public static native String getSeed();
  
  public static native byte[] toByte(String paramString);
  
  public static native String toHex(String paramString);
  
  public static native String toHex(byte[] paramArrayOfByte);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\SecurityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */