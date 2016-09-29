package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;

public class MimeTypeUtils
{
  static
  {
    JniLib.a(MimeTypeUtils.class, 1024);
  }
  
  public static native String getMimeType(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\MimeTypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */