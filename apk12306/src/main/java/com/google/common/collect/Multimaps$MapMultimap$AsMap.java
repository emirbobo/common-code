package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$MapMultimap$AsMap
  extends Maps.ImprovedAbstractMap<K, Collection<V>>
{
  static
  {
    JniLib.a(AsMap.class, 656);
  }
  
  Multimaps$MapMultimap$AsMap(Multimaps.MapMultimap paramMapMultimap) {}
  
  public native boolean containsKey(Object paramObject);
  
  protected native Set<Map.Entry<K, Collection<V>>> createEntrySet();
  
  public native Collection<V> get(Object paramObject);
  
  public native Collection<V> remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap$AsMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */