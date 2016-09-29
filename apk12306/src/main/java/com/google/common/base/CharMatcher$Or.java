package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.util.List;

class CharMatcher$Or
  extends CharMatcher
{
  List<CharMatcher> components;
  
  static
  {
    JniLib.a(Or.class, 274);
  }
  
  CharMatcher$Or(List<CharMatcher> paramList)
  {
    this.components = paramList;
  }
  
  public native boolean matches(char paramChar);
  
  public native CharMatcher or(CharMatcher paramCharMatcher);
  
  native void setBits(CharMatcher.LookupTable paramLookupTable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$Or.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */