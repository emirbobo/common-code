package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@GwtCompatible(serializable=true)
final class CompoundOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableList<Comparator<? super T>> comparators;
  
  static
  {
    JniLib.a(CompoundOrdering.class, 375);
  }
  
  CompoundOrdering(Iterable<? extends Comparator<? super T>> paramIterable)
  {
    this.comparators = ImmutableList.copyOf(paramIterable);
  }
  
  CompoundOrdering(Comparator<? super T> paramComparator1, Comparator<? super T> paramComparator2)
  {
    this.comparators = ImmutableList.of(paramComparator1, paramComparator2);
  }
  
  CompoundOrdering(List<? extends Comparator<? super T>> paramList, Comparator<? super T> paramComparator)
  {
    this.comparators = new ImmutableList.Builder().addAll(paramList).add(paramComparator).build();
  }
  
  public native int compare(T paramT1, T paramT2);
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CompoundOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */