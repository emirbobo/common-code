package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
class EmptyImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  
  static
  {
    JniLib.a(EmptyImmutableSortedSet.class, 438);
  }
  
  EmptyImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    super(paramComparator);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native E first();
  
  public native int hashCode();
  
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
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */