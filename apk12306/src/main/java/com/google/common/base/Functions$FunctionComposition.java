package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$FunctionComposition<A, B, C>
  implements Function<A, C>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Function<A, ? extends B> f;
  private final Function<B, C> g;
  
  static
  {
    JniLib.a(FunctionComposition.class, 285);
  }
  
  public Functions$FunctionComposition(Function<B, C> paramFunction, Function<A, ? extends B> paramFunction1)
  {
    this.g = ((Function)Preconditions.checkNotNull(paramFunction));
    this.f = ((Function)Preconditions.checkNotNull(paramFunction1));
  }
  
  public native C apply(A paramA);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$FunctionComposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */