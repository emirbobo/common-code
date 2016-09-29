package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$UnmodifiableMultimap$1
  extends ForwardingMap<K, Collection<V>>
{
  Collection<Collection<V>> asMapValues;
  Set<Map.Entry<K, Collection<V>>> entrySet;
  
  static
  {
    JniLib.a(1.class, 676);
  }
  
  Multimaps$UnmodifiableMultimap$1(Multimaps.UnmodifiableMultimap paramUnmodifiableMultimap, Map paramMap) {}
  
  public native boolean containsValue(Object paramObject);
  
  protected native Map<K, Collection<V>> delegate();
  
  public native Set<Map.Entry<K, Collection<V>>> entrySet();
  
  public native Collection<V> get(Object paramObject);
  
  public native Collection<Collection<V>> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableMultimap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */