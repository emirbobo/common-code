package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

class TreeMultiset$SortedMapBasedElementSet
  extends AbstractMapBasedMultiset<E>.MapBasedElementSet
  implements SortedSet<E>
{
  static
  {
    JniLib.a(SortedMapBasedElementSet.class, 810);
  }
  
  TreeMultiset$SortedMapBasedElementSet(SortedMap<E, AtomicInteger> paramSortedMap)
  {
    super(paramSortedMap, localMap);
  }
  
  public native Comparator<? super E> comparator();
  
  public native E first();
  
  public native SortedSet<E> headSet(E paramE);
  
  public native E last();
  
  public native boolean remove(Object paramObject);
  
  native SortedMap<E, AtomicInteger> sortedMap();
  
  public native SortedSet<E> subSet(E paramE1, E paramE2);
  
  public native SortedSet<E> tailSet(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeMultiset$SortedMapBasedElementSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */