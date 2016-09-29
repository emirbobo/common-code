package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedListMultimap$AsMapEntries
  extends AbstractSet<Map.Entry<K, Collection<V>>>
{
  static
  {
    JniLib.a(AsMapEntries.class, 563);
  }
  
  private LinkedListMultimap$AsMapEntries(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$AsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */