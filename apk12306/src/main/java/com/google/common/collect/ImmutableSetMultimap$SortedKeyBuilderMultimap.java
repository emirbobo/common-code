package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;

class ImmutableSetMultimap$SortedKeyBuilderMultimap<K, V>
  extends AbstractMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SortedKeyBuilderMultimap.class, 492);
  }
  
  ImmutableSetMultimap$SortedKeyBuilderMultimap(Comparator<? super K> paramComparator, Multimap<K, V> paramMultimap)
  {
    super(new TreeMap(paramComparator));
    putAll(paramMultimap);
  }
  
  native Collection<V> createCollection();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSetMultimap$SortedKeyBuilderMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */