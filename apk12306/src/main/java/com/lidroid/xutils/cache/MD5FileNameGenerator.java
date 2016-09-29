package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;

public class MD5FileNameGenerator
  implements FileNameGenerator
{
  static
  {
    JniLib.a(MD5FileNameGenerator.class, 946);
  }
  
  private native String bytesToHexString(byte[] paramArrayOfByte);
  
  public native String generate(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\MD5FileNameGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */