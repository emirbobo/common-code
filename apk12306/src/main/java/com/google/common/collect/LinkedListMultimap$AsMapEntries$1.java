package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedListMultimap$AsMapEntries$1
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  static
  {
    JniLib.a(1.class, 562);
  }
  
  LinkedListMultimap$AsMapEntries$1(LinkedListMultimap.AsMapEntries paramAsMapEntries, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, Collection<V>> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$AsMapEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */