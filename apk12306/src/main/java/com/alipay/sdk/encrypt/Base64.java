package com.alipay.sdk.encrypt;

import com.bangcle.andjni.JniLib;

public final class Base64
{
  private static final int a = 128;
  private static final int b = 64;
  private static final int c = 24;
  private static final int d = 8;
  private static final int e = 16;
  private static final int f = 4;
  private static final int g = -128;
  private static final char h = '=';
  private static final byte[] i;
  private static final char[] j;
  
  static
  {
    JniLib.a(Base64.class, 103);
    int n = 0;
    i = new byte[''];
    j = new char[64];
    for (int k = 0; k < 128; k++) {
      i[k] = ((byte)-1);
    }
    for (k = 90; k >= 65; k--) {
      i[k] = ((byte)(byte)(k - 65));
    }
    for (k = 122; k >= 97; k--) {
      i[k] = ((byte)(byte)(k - 97 + 26));
    }
    for (k = 57; k >= 48; k--) {
      i[k] = ((byte)(byte)(k - 48 + 52));
    }
    i[43] = ((byte)62);
    i[47] = ((byte)63);
    for (k = 0; k <= 25; k++) {
      j[k] = ((char)(char)(k + 65));
    }
    int m = 26;
    for (k = 0; m <= 51; k++)
    {
      j[m] = ((char)(char)(k + 97));
      m++;
    }
    m = 52;
    for (k = n; m <= 61; k++)
    {
      j[m] = ((char)(char)(k + 48));
      m++;
    }
    j[62] = ((char)43);
    j[63] = ((char)47);
  }
  
  private static native int a(char[] paramArrayOfChar);
  
  public static native String a(byte[] paramArrayOfByte);
  
  private static native boolean a(char paramChar);
  
  public static native byte[] a(String paramString);
  
  private static native boolean b(char paramChar);
  
  private static native boolean c(char paramChar);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\encrypt\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */