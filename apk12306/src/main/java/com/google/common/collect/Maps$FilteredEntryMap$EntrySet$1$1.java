package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1$1
  extends ForwardingMapEntry<K, V>
{
  static
  {
    JniLib.a(1.class, 623);
  }
  
  Maps$FilteredEntryMap$EntrySet$1$1(Maps.FilteredEntryMap.EntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected native Map.Entry<K, V> delegate();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap$EntrySet$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */