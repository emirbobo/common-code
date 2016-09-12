package com.google.common.base;

import com.bangcle.andjni.JniLib;

class CharMatcher$15
  extends CharMatcher
{
  static
  {
    JniLib.a(15.class, 262);
  }
  
  CharMatcher$15(CharMatcher paramCharMatcher, CharMatcher.LookupTable paramLookupTable) {}
  
  public native boolean matches(char paramChar);
  
  public native CharMatcher precomputed();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */