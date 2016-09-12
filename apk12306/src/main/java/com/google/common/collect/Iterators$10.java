package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$10
  extends UnmodifiableIterator<T>
{
  static
  {
    JniLib.a(10.class, 530);
  }
  
  Iterators$10(Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native T next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */