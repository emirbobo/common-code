package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

class Predicates$InPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Collection<?> target;
  
  static
  {
    JniLib.a(InPredicate.class, 303);
  }
  
  private Predicates$InPredicate(Collection<?> paramCollection)
  {
    this.target = ((Collection)Preconditions.checkNotNull(paramCollection));
  }
  
  public native boolean apply(T paramT);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$InPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */