package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$8
  extends CharMatcher
{
  static
  {
    JniLib.a(8.class, 270);
  }
  
  CharMatcher$8(char paramChar) {}
  
  public native CharMatcher and(CharMatcher paramCharMatcher);
  
  public native boolean matches(char paramChar);
  
  public native CharMatcher negate();
  
  public native CharMatcher or(CharMatcher paramCharMatcher);
  
  public native CharMatcher precomputed();
  
  public native String replaceFrom(CharSequence paramCharSequence, char paramChar);
  
  native void setBits(CharMatcher.LookupTable paramLookupTable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */