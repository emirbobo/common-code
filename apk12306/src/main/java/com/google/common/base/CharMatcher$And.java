package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.util.List;

class CharMatcher$And
  extends CharMatcher
{
  List<CharMatcher> components;
  
  static
  {
    JniLib.a(And.class, 272);
  }
  
  CharMatcher$And(List<CharMatcher> paramList)
  {
    this.components = paramList;
  }
  
  public native CharMatcher and(CharMatcher paramCharMatcher);
  
  public native boolean matches(char paramChar);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$And.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */