package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredEntryMap<K, V>
  extends Maps.AbstractFilteredMap<K, V>
{
  Set<Map.Entry<K, V>> entrySet;
  final Set<Map.Entry<K, V>> filteredEntrySet = Sets.filter(paramMap.entrySet(), this.predicate);
  Set<K> keySet;
  
  static
  {
    JniLib.a(FilteredEntryMap.class, 628);
  }
  
  Maps$FilteredEntryMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    super(paramMap, paramPredicate);
  }
  
  public native Set<Map.Entry<K, V>> entrySet();
  
  public native Set<K> keySet();
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    static
    {
      JniLib.a(EntrySet.class, 625);
    }
    
    private EntrySet() {}
    
    protected native Set<Map.Entry<K, V>> delegate();
    
    public native Iterator<Map.Entry<K, V>> iterator();
  }
  
  private class KeySet
    extends AbstractSet<K>
  {
    static
    {
      JniLib.a(KeySet.class, 627);
    }
    
    private KeySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<K> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */