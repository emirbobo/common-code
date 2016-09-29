package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class CharMatcher$LookupTable
{
  int[] data = new int['ࠀ'];
  
  static
  {
    JniLib.a(LookupTable.class, 273);
  }
  
  native boolean get(char paramChar);
  
  native void set(char paramChar);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\CharMatcher$LookupTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */