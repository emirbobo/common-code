package com.google.common.base;

import com.bangcle.andjni.JniLib;

class CharMatcher$14
  extends CharMatcher
{
  static
  {
    JniLib.a(14.class, 261);
  }
  
  CharMatcher$14(CharMatcher paramCharMatcher1, CharMatcher paramCharMatcher2) {}
  
  public native int countIn(CharSequence paramCharSequence);
  
  public native boolean matches(char paramChar);
  
  public native boolean matchesAllOf(CharSequence paramCharSequence);
  
  public native boolean matchesNoneOf(CharSequence paramCharSequence);
  
  public native CharMatcher negate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */