package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedListMultimap$4$1
  implements Iterator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(1.class, 558);
  }
  
  LinkedListMultimap$4$1(LinkedListMultimap.4 param4, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */