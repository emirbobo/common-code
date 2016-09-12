package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class LinkedListMultimap$MultisetView$2$1
  implements Iterator<Multiset.Entry<K>>
{
  static
  {
    JniLib.a(1.class, 567);
  }
  
  LinkedListMultimap$MultisetView$2$1(LinkedListMultimap.MultisetView.2 param2, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<K> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$MultisetView$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */