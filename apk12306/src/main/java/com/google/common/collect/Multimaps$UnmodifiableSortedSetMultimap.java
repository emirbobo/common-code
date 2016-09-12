package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;

class Multimaps$UnmodifiableSortedSetMultimap<K, V>
  extends Multimaps.UnmodifiableSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(UnmodifiableSortedSetMultimap.class, 678);
  }
  
  Multimaps$UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap)
  {
    super(paramSortedSetMultimap);
  }
  
  public native SortedSetMultimap<K, V> delegate();
  
  public native SortedSet<V> get(K paramK);
  
  public native SortedSet<V> removeAll(Object paramObject);
  
  public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native Comparator<? super V> valueComparator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */