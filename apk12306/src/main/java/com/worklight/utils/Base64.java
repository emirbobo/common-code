package com.worklight.utils;

import com.bangcle.andjni.JniLib;
import java.io.UnsupportedEncodingException;

public class Base64
{
  private static final byte[] map = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  
  static
  {
    JniLib.a(Base64.class, 1273);
  }
  
  public static native byte[] decode(byte[] paramArrayOfByte);
  
  public static native byte[] decode(byte[] paramArrayOfByte, int paramInt);
  
  public static native String encode(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException;
  
  public static native String encodeUrlSafe(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */