package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredEntryMap$EntrySet
  extends ForwardingSet<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(EntrySet.class, 625);
  }
  
  private Maps$FilteredEntryMap$EntrySet(Maps.FilteredEntryMap paramFilteredEntryMap) {}
  
  protected native Set<Map.Entry<K, V>> delegate();
  
  public native Iterator<Map.Entry<K, V>> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */