package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ReverseOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Ordering<? super T> forwardOrder;
  
  static
  {
    JniLib.a(ReverseOrdering.class, 714);
  }
  
  ReverseOrdering(Ordering<? super T> paramOrdering)
  {
    this.forwardOrder = ((Ordering)Preconditions.checkNotNull(paramOrdering));
  }
  
  public native int compare(T paramT1, T paramT2);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native <E extends T> E max(Iterable<E> paramIterable);
  
  public native <E extends T> E max(E paramE1, E paramE2);
  
  public <E extends T> E max(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (E)this.forwardOrder.min(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public native <E extends T> E min(Iterable<E> paramIterable);
  
  public native <E extends T> E min(E paramE1, E paramE2);
  
  public <E extends T> E min(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (E)this.forwardOrder.max(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public native <S extends T> Ordering<S> reverse();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ReverseOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */