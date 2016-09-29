package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class LinkedListMultimap$NodeIterator
  implements Iterator<LinkedListMultimap.Node<K, V>>
{
  LinkedListMultimap.Node<K, V> current;
  LinkedListMultimap.Node<K, V> next = LinkedListMultimap.access$000(this.this$0);
  
  static
  {
    JniLib.a(NodeIterator.class, 571);
  }
  
  private LinkedListMultimap$NodeIterator(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native boolean hasNext();
  
  public native LinkedListMultimap.Node<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$NodeIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */