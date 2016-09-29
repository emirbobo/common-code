package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class LinkedListMultimap$MultisetView$1
  implements Iterator<K>
{
  static
  {
    JniLib.a(1.class, 565);
  }
  
  LinkedListMultimap$MultisetView$1(LinkedListMultimap.MultisetView paramMultisetView, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native K next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$MultisetView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */