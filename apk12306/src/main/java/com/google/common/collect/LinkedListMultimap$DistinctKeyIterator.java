package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class LinkedListMultimap$DistinctKeyIterator
  implements Iterator<K>
{
  LinkedListMultimap.Node<K, V> current;
  LinkedListMultimap.Node<K, V> next = LinkedListMultimap.access$000(this.this$0);
  final Set<K> seenKeys = new HashSet(Maps.capacity(this.this$0.keySet().size()));
  
  static
  {
    JniLib.a(DistinctKeyIterator.class, 564);
  }
  
  private LinkedListMultimap$DistinctKeyIterator(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native boolean hasNext();
  
  public native K next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$DistinctKeyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */