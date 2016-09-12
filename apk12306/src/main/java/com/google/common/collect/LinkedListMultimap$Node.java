package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

final class LinkedListMultimap$Node<K, V>
{
  final K key;
  Node<K, V> next;
  Node<K, V> nextSibling;
  Node<K, V> previous;
  Node<K, V> previousSibling;
  V value;
  
  static
  {
    JniLib.a(Node.class, 570);
  }
  
  LinkedListMultimap$Node(@Nullable K paramK, @Nullable V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */