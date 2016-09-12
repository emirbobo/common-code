package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection$1
  extends UnmodifiableIterator<Map.Entry<K, V>>
{
  K key;
  Iterator<V> valueIterator;
  
  static
  {
    JniLib.a(1.class, 478);
  }
  
  ImmutableMultimap$EntryCollection$1(ImmutableMultimap.EntryCollection paramEntryCollection, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultimap$EntryCollection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */