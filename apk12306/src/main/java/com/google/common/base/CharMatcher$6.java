package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$6
  extends CharMatcher
{
  static
  {
    JniLib.a(6.class, 268);
  }
  
  public native CharMatcher and(CharMatcher paramCharMatcher);
  
  public native String collapseFrom(CharSequence paramCharSequence, char paramChar);
  
  public native int countIn(CharSequence paramCharSequence);
  
  public native int indexIn(CharSequence paramCharSequence);
  
  public native int indexIn(CharSequence paramCharSequence, int paramInt);
  
  public native int lastIndexIn(CharSequence paramCharSequence);
  
  public native boolean matches(char paramChar);
  
  public native boolean matchesAllOf(CharSequence paramCharSequence);
  
  public native boolean matchesNoneOf(CharSequence paramCharSequence);
  
  public native CharMatcher negate();
  
  public native CharMatcher or(CharMatcher paramCharMatcher);
  
  public native CharMatcher precomputed();
  
  public native String removeFrom(CharSequence paramCharSequence);
  
  public native String replaceFrom(CharSequence paramCharSequence, char paramChar);
  
  public native String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
  
  public native String trimFrom(CharSequence paramCharSequence);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */