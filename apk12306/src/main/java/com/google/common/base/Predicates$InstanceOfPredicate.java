package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Predicates$InstanceOfPredicate
  implements Predicate<Object>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Class<?> clazz;
  
  static
  {
    JniLib.a(InstanceOfPredicate.class, 304);
  }
  
  private Predicates$InstanceOfPredicate(Class<?> paramClass)
  {
    this.clazz = ((Class)Preconditions.checkNotNull(paramClass));
  }
  
  public native boolean apply(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Predicates$InstanceOfPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */