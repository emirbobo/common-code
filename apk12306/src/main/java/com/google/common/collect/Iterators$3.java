package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$3
  extends UnmodifiableIterator<T>
{
  static
  {
    JniLib.a(3.class, 538);
  }
  
  Iterators$3(Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native T next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */