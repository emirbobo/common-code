package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class Maps$AbstractFilteredMap<K, V>
  extends AbstractMap<K, V>
{
  final Predicate<? super Map.Entry<K, V>> predicate;
  final Map<K, V> unfiltered;
  Collection<V> values;
  
  Maps$AbstractFilteredMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    this.unfiltered = paramMap;
    this.predicate = paramPredicate;
  }
  
  boolean apply(Object paramObject, V paramV)
  {
    return this.predicate.apply(Maps.immutableEntry(paramObject, paramV));
  }
  
  public boolean containsKey(Object paramObject)
  {
    if ((this.unfiltered.containsKey(paramObject)) && (apply(paramObject, this.unfiltered.get(paramObject)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public V get(Object paramObject)
  {
    Object localObject = this.unfiltered.get(paramObject);
    if ((localObject != null) && (apply(paramObject, localObject))) {}
    for (paramObject = localObject;; paramObject = null) {
      return (V)paramObject;
    }
  }
  
  public boolean isEmpty()
  {
    return entrySet().isEmpty();
  }
  
  public V put(K paramK, V paramV)
  {
    Preconditions.checkArgument(apply(paramK, paramV));
    return (V)this.unfiltered.put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Preconditions.checkArgument(apply(localEntry.getKey(), localEntry.getValue()));
    }
    this.unfiltered.putAll(paramMap);
  }
  
  public V remove(Object paramObject)
  {
    if (containsKey(paramObject)) {}
    for (paramObject = this.unfiltered.remove(paramObject);; paramObject = null) {
      return (V)paramObject;
    }
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.values;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new Values();
      this.values = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  class Values
    extends AbstractCollection<V>
  {
    static
    {
      JniLib.a(Values.class, 620);
    }
    
    Values() {}
    
    public native void clear();
    
    public native boolean isEmpty();
    
    public native Iterator<V> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$AbstractFilteredMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */