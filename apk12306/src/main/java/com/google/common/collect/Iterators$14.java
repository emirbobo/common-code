package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Enumeration;

final class Iterators$14
  extends UnmodifiableIterator<T>
{
  static
  {
    JniLib.a(14.class, 534);
  }
  
  Iterators$14(Enumeration paramEnumeration) {}
  
  public native boolean hasNext();
  
  public native T next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */