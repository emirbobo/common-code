package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import javax.annotation.Nullable;

class ImmutableList$ReverseImmutableList<E>
  extends ImmutableList<E>
{
  private final transient ImmutableList<E> forwardList;
  private final transient int size;
  
  static
  {
    JniLib.a(ReverseImmutableList.class, 473);
  }
  
  ImmutableList$ReverseImmutableList(ImmutableList<E> paramImmutableList)
  {
    this.forwardList = paramImmutableList;
    this.size = paramImmutableList.size();
  }
  
  private native int reverseIndex(int paramInt);
  
  private native int reversePosition(int paramInt);
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native E get(int paramInt);
  
  public native int indexOf(@Nullable Object paramObject);
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native int lastIndexOf(@Nullable Object paramObject);
  
  public native UnmodifiableListIterator<E> listIterator(int paramInt);
  
  public native ImmutableList<E> reverse();
  
  public native int size();
  
  public native ImmutableList<E> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableList$ReverseImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */