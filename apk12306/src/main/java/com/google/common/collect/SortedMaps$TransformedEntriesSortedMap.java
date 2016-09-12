package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedMap;

class SortedMaps$TransformedEntriesSortedMap<K, V1, V2>
  extends Maps.TransformedEntriesMap<K, V1, V2>
  implements SortedMap<K, V2>
{
  static
  {
    JniLib.a(TransformedEntriesSortedMap.class, 743);
  }
  
  SortedMaps$TransformedEntriesSortedMap(SortedMap<K, V1> paramSortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    super(paramSortedMap, paramEntryTransformer);
  }
  
  public native Comparator<? super K> comparator();
  
  public native K firstKey();
  
  protected native SortedMap<K, V1> fromMap();
  
  public native SortedMap<K, V2> headMap(K paramK);
  
  public native K lastKey();
  
  public native SortedMap<K, V2> subMap(K paramK1, K paramK2);
  
  public native SortedMap<K, V2> tailMap(K paramK);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedMaps$TransformedEntriesSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */