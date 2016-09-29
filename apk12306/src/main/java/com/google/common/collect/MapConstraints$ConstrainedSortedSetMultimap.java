package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;

class MapConstraints$ConstrainedSortedSetMultimap<K, V>
  extends MapConstraints.ConstrainedSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  static
  {
    JniLib.a(ConstrainedSortedSetMultimap.class, 606);
  }
  
  MapConstraints$ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    super(paramSortedSetMultimap, paramMapConstraint);
  }
  
  public native SortedSet<V> get(K paramK);
  
  public native SortedSet<V> removeAll(Object paramObject);
  
  public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native Comparator<? super V> valueComparator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */