package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$NotPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Predicate<T> predicate;
  
  static
  {
    JniLib.a(NotPredicate.class, 306);
  }
  
  Predicates$NotPredicate(Predicate<T> paramPredicate)
  {
    this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  public native boolean apply(T paramT);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$NotPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */