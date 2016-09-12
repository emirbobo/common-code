package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$IsEqualToPredicate<T>
  implements Predicate<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final T target;
  
  static
  {
    JniLib.a(IsEqualToPredicate.class, 305);
  }
  
  private Predicates$IsEqualToPredicate(T paramT)
  {
    this.target = paramT;
  }
  
  public native boolean apply(T paramT);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$IsEqualToPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */