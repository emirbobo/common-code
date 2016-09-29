package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$FunctionForMapNoDefault<K, V>
  implements Function<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Map<K, V> map;
  
  static
  {
    JniLib.a(FunctionForMapNoDefault.class, 286);
  }
  
  Functions$FunctionForMapNoDefault(Map<K, V> paramMap)
  {
    this.map = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  public native V apply(K paramK);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$FunctionForMapNoDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */