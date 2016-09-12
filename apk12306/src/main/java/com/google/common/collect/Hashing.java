package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing
{
  static
  {
    JniLib.a(Hashing.class, 454);
  }
  
  static native int smear(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */