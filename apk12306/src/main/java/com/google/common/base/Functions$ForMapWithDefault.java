package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$ForMapWithDefault<K, V>
  implements Function<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  final V defaultValue;
  final Map<K, ? extends V> map;
  
  static
  {
    JniLib.a(ForMapWithDefault.class, 284);
  }
  
  Functions$ForMapWithDefault(Map<K, ? extends V> paramMap, @Nullable V paramV)
  {
    this.map = ((Map)Preconditions.checkNotNull(paramMap));
    this.defaultValue = paramV;
  }
  
  public native V apply(K paramK);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$ForMapWithDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */