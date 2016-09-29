package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$ConstantFunction<E>
  implements Function<Object, E>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final E value;
  
  static
  {
    JniLib.a(ConstantFunction.class, 283);
  }
  
  public Functions$ConstantFunction(@Nullable E paramE)
  {
    this.value = paramE;
  }
  
  public native E apply(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$ConstantFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */