package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$11
  extends CharMatcher
{
  static
  {
    JniLib.a(11.class, 258);
  }
  
  CharMatcher$11(char[] paramArrayOfChar) {}
  
  public native boolean matches(char paramChar);
  
  native void setBits(CharMatcher.LookupTable paramLookupTable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */