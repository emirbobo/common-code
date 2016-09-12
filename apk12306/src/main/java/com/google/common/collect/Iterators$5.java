package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$5
  implements Iterator<T>
{
  Iterator<? extends T> current = Iterators.emptyIterator();
  Iterator<? extends T> removeFrom;
  
  static
  {
    JniLib.a(5.class, 540);
  }
  
  Iterators$5(Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native T next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */