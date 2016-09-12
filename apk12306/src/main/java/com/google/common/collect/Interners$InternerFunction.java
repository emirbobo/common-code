package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

class Interners$InternerFunction<E>
  implements Function<E, E>
{
  private final Interner<E> interner;
  
  static
  {
    JniLib.a(InternerFunction.class, 508);
  }
  
  public Interners$InternerFunction(Interner<E> paramInterner)
  {
    this.interner = paramInterner;
  }
  
  public native E apply(E paramE);
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Interners$InternerFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */