package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.SortedMap;

class SortedMaps$SortedMapDifferenceImpl<K, V>
  extends Maps.MapDifferenceImpl<K, V>
  implements SortedMapDifference<K, V>
{
  static
  {
    JniLib.a(SortedMapDifferenceImpl.class, 742);
  }
  
  SortedMaps$SortedMapDifferenceImpl(boolean paramBoolean, SortedMap<K, V> paramSortedMap1, SortedMap<K, V> paramSortedMap2, SortedMap<K, V> paramSortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> paramSortedMap)
  {
    super(paramBoolean, paramSortedMap1, paramSortedMap2, paramSortedMap3, paramSortedMap);
  }
  
  public native SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();
  
  public native SortedMap<K, V> entriesInCommon();
  
  public native SortedMap<K, V> entriesOnlyOnLeft();
  
  public native SortedMap<K, V> entriesOnlyOnRight();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedMaps$SortedMapDifferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */