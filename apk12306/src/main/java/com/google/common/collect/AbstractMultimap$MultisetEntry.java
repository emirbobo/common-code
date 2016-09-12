package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map.Entry;

class AbstractMultimap$MultisetEntry
  extends Multisets.AbstractEntry<K>
{
  final Map.Entry<K, Collection<V>> entry;
  
  static
  {
    JniLib.a(MultisetEntry.class, 350);
  }
  
  public AbstractMultimap$MultisetEntry(Map.Entry<K, Collection<V>> paramEntry)
  {
    Map.Entry localEntry;
    this.entry = localEntry;
  }
  
  public native int getCount();
  
  public native K getElement();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$MultisetEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */