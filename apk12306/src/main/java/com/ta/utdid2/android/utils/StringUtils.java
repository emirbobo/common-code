package com.ta.utdid2.android.utils;

import com.bangcle.andjni.JniLib;

public class StringUtils
{
  static
  {
    JniLib.a(StringUtils.class, 1065);
  }
  
  public static native String convertObjectToString(Object paramObject);
  
  public static native int hashCode(String paramString);
  
  public static native boolean isEmpty(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */