package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class SingletonImmutableSet<E>
  extends ImmutableSet<E>
{
  private transient Integer cachedHashCode;
  final transient E element;
  
  static
  {
    JniLib.a(SingletonImmutableSet.class, 736);
  }
  
  SingletonImmutableSet(E paramE)
  {
    this.element = Preconditions.checkNotNull(paramE);
  }
  
  SingletonImmutableSet(E paramE, int paramInt)
  {
    this.element = paramE;
    this.cachedHashCode = Integer.valueOf(paramInt);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public final native int hashCode();
  
  public native boolean isEmpty();
  
  native boolean isHashCodeFast();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SingletonImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */