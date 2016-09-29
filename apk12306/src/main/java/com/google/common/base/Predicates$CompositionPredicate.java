package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$CompositionPredicate<A, B>
  implements Predicate<A>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Function<A, ? extends B> f;
  final Predicate<B> p;
  
  static
  {
    JniLib.a(CompositionPredicate.class, 301);
  }
  
  private Predicates$CompositionPredicate(Predicate<B> paramPredicate, Function<A, ? extends B> paramFunction)
  {
    this.p = ((Predicate)Preconditions.checkNotNull(paramPredicate));
    this.f = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  public native boolean apply(A paramA);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$CompositionPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */