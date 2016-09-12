package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$10
  extends CharMatcher
{
  static
  {
    JniLib.a(10.class, 257);
  }
  
  CharMatcher$10(char paramChar1, char paramChar2) {}
  
  public native boolean matches(char paramChar);
  
  public native CharMatcher precomputed();
  
  native void setBits(CharMatcher.LookupTable paramLookupTable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */