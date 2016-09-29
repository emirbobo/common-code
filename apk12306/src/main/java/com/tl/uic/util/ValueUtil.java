package com.tl.uic.util;

import com.bangcle.andjni.JniLib;

public final class ValueUtil
{
  private static volatile ValueUtil _myInstance;
  
  static
  {
    JniLib.a(ValueUtil.class, 1130);
  }
  
  public static native String compareListAndMask(String paramString1, String paramString2);
  
  public static native ValueUtil getInstance();
  
  public static native String maskValue(String paramString);
  
  public static native String trimValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ValueUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */