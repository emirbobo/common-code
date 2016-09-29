package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedMap;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedMap<K, V>
  extends Synchronized.SynchronizedMap<K, V>
  implements SortedMap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedSortedMap.class, 793);
  }
  
  Synchronized$SynchronizedSortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject)
  {
    super(paramSortedMap, paramObject);
  }
  
  public native Comparator<? super K> comparator();
  
  native SortedMap<K, V> delegate();
  
  public native K firstKey();
  
  public native SortedMap<K, V> headMap(K paramK);
  
  public native K lastKey();
  
  public native SortedMap<K, V> subMap(K paramK1, K paramK2);
  
  public native SortedMap<K, V> tailMap(K paramK);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */