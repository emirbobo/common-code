package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Iterator;

final class Iterators$8
  implements Iterator<T>
{
  static
  {
    JniLib.a(8.class, 543);
  }
  
  Iterators$8(Iterator paramIterator, Function paramFunction) {}
  
  public native boolean hasNext();
  
  public native T next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */