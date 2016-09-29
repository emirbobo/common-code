package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class PairwiseEquivalence<T>
  implements Equivalence<Iterable<T>>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Equivalence<? super T> elementEquivalence;
  
  static
  {
    JniLib.a(PairwiseEquivalence.class, 296);
  }
  
  PairwiseEquivalence(Equivalence<? super T> paramEquivalence)
  {
    this.elementEquivalence = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native boolean equivalent(@Nullable Iterable<T> paramIterable1, @Nullable Iterable<T> paramIterable2);
  
  public native int hash(@Nullable Iterable<T> paramIterable);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\PairwiseEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */