package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$UnmodifiableMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Multimap<K, V> delegate;
  transient Collection<Map.Entry<K, V>> entries;
  transient Set<K> keySet;
  transient Multiset<K> keys;
  transient Map<K, Collection<V>> map;
  transient Collection<V> values;
  
  static
  {
    JniLib.a(UnmodifiableMultimap.class, 674);
  }
  
  Multimaps$UnmodifiableMultimap(Multimap<K, V> paramMultimap)
  {
    this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
  }
  
  public native Map<K, Collection<V>> asMap();
  
  public native void clear();
  
  protected native Multimap<K, V> delegate();
  
  public native Collection<Map.Entry<K, V>> entries();
  
  public native Collection<V> get(K paramK);
  
  public native Set<K> keySet();
  
  public native Multiset<K> keys();
  
  public native boolean put(K paramK, V paramV);
  
  public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
  
  public native boolean remove(Object paramObject1, Object paramObject2);
  
  public native Collection<V> removeAll(Object paramObject);
  
  public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native Collection<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */