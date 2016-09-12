package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

class Predicates$OrPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final List<? extends Predicate<? super T>> components;
  
  static
  {
    JniLib.a(OrPredicate.class, 307);
  }
  
  private Predicates$OrPredicate(List<? extends Predicate<? super T>> paramList)
  {
    this.components = paramList;
  }
  
  public native boolean apply(T paramT);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$OrPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */