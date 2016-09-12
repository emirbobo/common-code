package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMap<K, V>
  extends Synchronized.SynchronizedMap<K, Collection<V>>
{
  private static final long serialVersionUID = 0L;
  transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
  transient Collection<Collection<V>> asMapValues;
  
  static
  {
    JniLib.a(SynchronizedAsMap.class, 779);
  }
  
  Synchronized$SynchronizedAsMap(Map<K, Collection<V>> paramMap, @Nullable Object paramObject)
  {
    super(paramMap, paramObject);
  }
  
  public native boolean containsValue(Object paramObject);
  
  public native Set<Map.Entry<K, Collection<V>>> entrySet();
  
  public native Collection<V> get(Object paramObject);
  
  public native Collection<Collection<V>> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedAsMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */