package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$AsMap
  extends AbstractMap<K, Collection<V>>
{
  transient Set<Map.Entry<K, Collection<V>>> entrySet;
  final transient Map<K, Collection<V>> submap;
  
  static
  {
    JniLib.a(AsMap.class, 344);
  }
  
  AbstractMultimap$AsMap(Map<K, Collection<V>> paramMap)
  {
    Map localMap;
    this.submap = localMap;
  }
  
  public native boolean containsKey(Object paramObject);
  
  public native Set<Map.Entry<K, Collection<V>>> entrySet();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Collection<V> get(Object paramObject);
  
  public native int hashCode();
  
  public native Set<K> keySet();
  
  public native Collection<V> remove(Object paramObject);
  
  public native String toString();
  
  class AsMapEntries
    extends AbstractSet<Map.Entry<K, Collection<V>>>
  {
    static
    {
      JniLib.a(AsMapEntries.class, 342);
    }
    
    AsMapEntries() {}
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  class AsMapIterator
    implements Iterator<Map.Entry<K, Collection<V>>>
  {
    Collection<V> collection;
    final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = AbstractMultimap.AsMap.this.submap.entrySet().iterator();
    
    static
    {
      JniLib.a(AsMapIterator.class, 343);
    }
    
    AsMapIterator() {}
    
    public native boolean hasNext();
    
    public native Map.Entry<K, Collection<V>> next();
    
    public native void remove();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$AsMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */