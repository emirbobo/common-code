package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$9
  extends CharMatcher
{
  static
  {
    JniLib.a(9.class, 271);
  }
  
  CharMatcher$9(char paramChar) {}
  
  public native CharMatcher and(CharMatcher paramCharMatcher);
  
  public native boolean matches(char paramChar);
  
  public native CharMatcher negate();
  
  public native CharMatcher or(CharMatcher paramCharMatcher);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */