package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$PredicateFunction<T>
  implements Function<T, Boolean>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Predicate<T> predicate;
  
  static
  {
    JniLib.a(PredicateFunction.class, 287);
  }
  
  private Functions$PredicateFunction(Predicate<T> paramPredicate)
  {
    this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  public native Boolean apply(T paramT);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$PredicateFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */