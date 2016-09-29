package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMultimap$SortedKeySet
  extends AbstractMultimap<K, V>.KeySet
  implements SortedSet<K>
{
  static
  {
    JniLib.a(SortedKeySet.class, 358);
  }
  
  AbstractMultimap$SortedKeySet(SortedMap<K, Collection<V>> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }
  
  public native Comparator<? super K> comparator();
  
  public native K first();
  
  public native SortedSet<K> headSet(K paramK);
  
  public native K last();
  
  native SortedMap<K, Collection<V>> sortedMap();
  
  public native SortedSet<K> subSet(K paramK1, K paramK2);
  
  public native SortedSet<K> tailSet(K paramK);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$SortedKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */