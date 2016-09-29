package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class NullsFirstOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Ordering<? super T> ordering;
  
  static
  {
    JniLib.a(NullsFirstOrdering.class, 696);
  }
  
  NullsFirstOrdering(Ordering<? super T> paramOrdering)
  {
    this.ordering = paramOrdering;
  }
  
  public native int compare(@Nullable T paramT1, @Nullable T paramT2);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native <S extends T> Ordering<S> nullsFirst();
  
  public native <S extends T> Ordering<S> nullsLast();
  
  public native <S extends T> Ordering<S> reverse();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\NullsFirstOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */