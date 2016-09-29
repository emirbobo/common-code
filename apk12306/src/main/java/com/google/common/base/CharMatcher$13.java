package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$13
  extends CharMatcher
{
  static
  {
    JniLib.a(13.class, 260);
  }
  
  CharMatcher$13(Predicate paramPredicate) {}
  
  public native boolean apply(Character paramCharacter);
  
  public native boolean matches(char paramChar);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */