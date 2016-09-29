package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedListMultimap$4
  extends AbstractCollection<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(4.class, 559);
  }
  
  LinkedListMultimap$4(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */