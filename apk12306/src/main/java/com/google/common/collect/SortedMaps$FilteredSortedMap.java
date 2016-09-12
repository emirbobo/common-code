package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedMap;

class SortedMaps$FilteredSortedMap<K, V>
  extends Maps.FilteredEntryMap<K, V>
  implements SortedMap<K, V>
{
  static
  {
    JniLib.a(FilteredSortedMap.class, 741);
  }
  
  SortedMaps$FilteredSortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    super(paramSortedMap, paramPredicate);
  }
  
  public native Comparator<? super K> comparator();
  
  public native K firstKey();
  
  public native SortedMap<K, V> headMap(K paramK);
  
  public native K lastKey();
  
  native SortedMap<K, V> sortedMap();
  
  public native SortedMap<K, V> subMap(K paramK1, K paramK2);
  
  public native SortedMap<K, V> tailMap(K paramK);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedMaps$FilteredSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */