package com.worklight.utils;

import com.bangcle.andjni.JniLib;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;

public class SecurityUtils$PBKDF2
{
  static
  {
    JniLib.a(PBKDF2.class, 1276);
  }
  
  private static native int ceil(int paramInt1, int paramInt2);
  
  private static native byte[] concat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native byte[] encodedInt(int paramInt);
  
  private static native byte[] f(Mac paramMac, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException;
  
  public static native Key genKey(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException;
  
  private static native byte[] xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\SecurityUtils$PBKDF2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */