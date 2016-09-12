package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSetMultimap<K, V>
  extends Synchronized.SynchronizedSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedSortedSetMultimap.class, 795);
  }
  
  Synchronized$SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject)
  {
    super(paramSortedSetMultimap, paramObject);
  }
  
  native SortedSetMultimap<K, V> delegate();
  
  public native SortedSet<V> get(K paramK);
  
  public native SortedSet<V> removeAll(Object paramObject);
  
  public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public native Comparator<? super V> valueComparator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedSortedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */