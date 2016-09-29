package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMultimap$SortedAsMap
  extends AbstractMultimap<K, V>.AsMap
  implements SortedMap<K, Collection<V>>
{
  SortedSet<K> sortedKeySet;
  
  static
  {
    JniLib.a(SortedAsMap.class, 357);
  }
  
  AbstractMultimap$SortedAsMap(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }
  
  public native Comparator<? super K> comparator();
  
  public native K firstKey();
  
  public native SortedMap<K, Collection<V>> headMap(K paramK);
  
  public native SortedSet<K> keySet();
  
  public native K lastKey();
  
  native SortedMap<K, Collection<V>> sortedMap();
  
  public native SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2);
  
  public native SortedMap<K, Collection<V>> tailMap(K paramK);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$SortedAsMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */