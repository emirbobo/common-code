package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$4
  extends UnmodifiableIterator<Iterator<? extends T>>
{
  static
  {
    JniLib.a(4.class, 522);
  }
  
  Iterables$4(Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Iterator<? extends T> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */