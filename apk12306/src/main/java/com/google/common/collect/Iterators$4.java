package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$4
  implements Iterator<T>
{
  Iterator<T> iterator = Iterators.emptyIterator();
  Iterator<T> removeFrom;
  
  static
  {
    JniLib.a(4.class, 539);
  }
  
  Iterators$4(Iterable paramIterable) {}
  
  public native boolean hasNext();
  
  public native T next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */