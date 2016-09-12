package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class RegularImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private final transient ImmutableList<E> elements;
  
  static
  {
    JniLib.a(RegularImmutableSortedSet.class, 712);
  }
  
  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    this.elements = paramImmutableList;
    if (!paramImmutableList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  private native int binarySearch(Object paramObject);
  
  private native ImmutableSortedSet<E> createSubset(int paramInt1, int paramInt2);
  
  private native int findSubsetIndex(E paramE);
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  native ImmutableList<E> createAsList();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native E first();
  
  native ImmutableSortedSet<E> headSetImpl(E paramE);
  
  native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native E last();
  
  public native int size();
  
  native ImmutableSortedSet<E> subSetImpl(E paramE1, E paramE2);
  
  native ImmutableSortedSet<E> tailSetImpl(E paramE);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */