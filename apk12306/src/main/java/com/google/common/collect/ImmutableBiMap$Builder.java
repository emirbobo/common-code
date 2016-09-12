package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public final class ImmutableBiMap$Builder<K, V>
  extends ImmutableMap.Builder<K, V>
{
  static
  {
    JniLib.a(Builder.class, 459);
  }
  
  public native ImmutableBiMap<K, V> build();
  
  public native Builder<K, V> put(K paramK, V paramV);
  
  public native Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableBiMap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */