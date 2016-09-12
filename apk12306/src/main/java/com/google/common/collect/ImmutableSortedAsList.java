package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

final class ImmutableSortedAsList<E>
  extends ImmutableList<E>
{
  private final transient ImmutableList<E> backingList;
  private final transient ImmutableSortedSet<E> backingSet;
  
  static
  {
    JniLib.a(ImmutableSortedAsList.class, 493);
  }
  
  ImmutableSortedAsList(ImmutableSortedSet<E> paramImmutableSortedSet, ImmutableList<E> paramImmutableList)
  {
    this.backingSet = paramImmutableSortedSet;
    this.backingList = paramImmutableList;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native E get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native int lastIndexOf(Object paramObject);
  
  public native UnmodifiableListIterator<E> listIterator();
  
  public native UnmodifiableListIterator<E> listIterator(int paramInt);
  
  public native int size();
  
  public native ImmutableList<E> subList(int paramInt1, int paramInt2);
  
  native Object writeReplace();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */