package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Iterables$11$1
  implements Iterator<T>
{
  boolean atStart = true;
  
  static
  {
    JniLib.a(1.class, 514);
  }
  
  Iterables$11$1(Iterables.11 param11, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native T next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$11$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */