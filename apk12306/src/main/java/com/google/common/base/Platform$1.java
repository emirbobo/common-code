package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class Platform$1
  extends ThreadLocal<char[]>
{
  static
  {
    JniLib.a(1.class, 297);
  }
  
  protected native char[] initialValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Platform$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */