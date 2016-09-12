package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ComparatorOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<T> comparator;
  
  static
  {
    JniLib.a(ComparatorOrdering.class, 372);
  }
  
  ComparatorOrdering(Comparator<T> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public native int binarySearch(List<? extends T> paramList, T paramT);
  
  public native int compare(T paramT1, T paramT2);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native <E extends T> List<E> sortedCopy(Iterable<E> paramIterable);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComparatorOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */