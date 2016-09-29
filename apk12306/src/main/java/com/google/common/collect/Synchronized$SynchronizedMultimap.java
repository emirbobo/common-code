package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultimap<K, V>
  extends Synchronized.SynchronizedObject
  implements Multimap<K, V>
{
  private static final long serialVersionUID = 0L;
  transient Map<K, Collection<V>> asMap;
  transient Collection<Map.Entry<K, V>> entries;
  transient Set<K> keySet;
  transient Multiset<K> keys;
  transient Collection<V> valuesCollection;
  
  static
  {
    JniLib.a(SynchronizedMultimap.class, 789);
  }
  
  Synchronized$SynchronizedMultimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject)
  {
    super(paramMultimap, paramObject);
  }
  
  public native Map<K, Collection<V>> asMap();
  
  public native void clear();
  
  public native boolean containsEntry(Object paramObject1, Object paramObject2);
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  native Multimap<K, V> delegate();
  
  public native Collection<Map.Entry<K, V>> entries();
  
  public native boolean equals(Object paramObject);
  
  public native Collection<V> get(K paramK);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Set<K> keySet();
  
  public native Multiset<K> keys();
  
  public native boolean put(K paramK, V paramV);
  
  public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
  
  public native boolean remove(Object paramObject1, Object paramObject2);
  
  public native Collection<V> removeAll(Object paramObject);
  
  public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native int size();
  
  public native Collection<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */