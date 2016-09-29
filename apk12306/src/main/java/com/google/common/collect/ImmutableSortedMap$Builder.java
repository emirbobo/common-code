package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;

public class ImmutableSortedMap$Builder<K, V>
  extends ImmutableMap.Builder<K, V>
{
  private final Comparator<? super K> comparator;
  
  static
  {
    JniLib.a(Builder.class, 498);
  }
  
  public ImmutableSortedMap$Builder(Comparator<? super K> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public native ImmutableSortedMap<K, V> build();
  
  public native Builder<K, V> put(K paramK, V paramV);
  
  public native Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */