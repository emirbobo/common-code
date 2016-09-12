package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Multimaps$MapMultimap<K, V>
  implements SetMultimap<K, V>, Serializable
{
  private static final Joiner.MapJoiner JOINER = Joiner.on("], ").withKeyValueSeparator("=[").useForNull("null");
  private static final long serialVersionUID = 7845222491160860175L;
  transient Map<K, Collection<V>> asMap;
  final Map<K, V> map;
  
  static
  {
    JniLib.a(MapMultimap.class, 660);
  }
  
  Multimaps$MapMultimap(Map<K, V> paramMap)
  {
    this.map = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  public native Map<K, Collection<V>> asMap();
  
  public native void clear();
  
  public native boolean containsEntry(Object paramObject1, Object paramObject2);
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  public native Set<Map.Entry<K, V>> entries();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Set<V> get(K paramK);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Set<K> keySet();
  
  public native Multiset<K> keys();
  
  public native boolean put(K paramK, V paramV);
  
  public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
  
  public native boolean remove(Object paramObject1, Object paramObject2);
  
  public native Set<V> removeAll(Object paramObject);
  
  public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native int size();
  
  public native String toString();
  
  public native Collection<V> values();
  
  class AsMap
    extends Maps.ImprovedAbstractMap<K, Collection<V>>
  {
    static
    {
      JniLib.a(AsMap.class, 656);
    }
    
    AsMap() {}
    
    public native boolean containsKey(Object paramObject);
    
    protected native Set<Map.Entry<K, Collection<V>>> createEntrySet();
    
    public native Collection<V> get(Object paramObject);
    
    public native Collection<V> remove(Object paramObject);
  }
  
  class AsMapEntries
    extends AbstractSet<Map.Entry<K, Collection<V>>>
  {
    static
    {
      JniLib.a(AsMapEntries.class, 659);
    }
    
    AsMapEntries() {}
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */