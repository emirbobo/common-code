package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1
  extends UnmodifiableIterator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(1.class, 624);
  }
  
  Maps$FilteredEntryMap$EntrySet$1(Maps.FilteredEntryMap.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */