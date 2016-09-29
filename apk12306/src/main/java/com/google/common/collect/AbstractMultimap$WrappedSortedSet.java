package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class AbstractMultimap$WrappedSortedSet
  extends AbstractMultimap<K, V>.WrappedCollection
  implements SortedSet<V>
{
  static
  {
    JniLib.a(WrappedSortedSet.class, 363);
  }
  
  AbstractMultimap$WrappedSortedSet(@Nullable K paramK, SortedSet<V> paramSortedSet, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramSortedSet, paramAbstractMultimap, localWrappedCollection);
  }
  
  public native Comparator<? super V> comparator();
  
  public native V first();
  
  native SortedSet<V> getSortedSetDelegate();
  
  public native SortedSet<V> headSet(V paramV);
  
  public native V last();
  
  public native SortedSet<V> subSet(V paramV1, V paramV2);
  
  public native SortedSet<V> tailSet(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */