package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  final BiMap<? extends K, ? extends V> delegate;
  transient BiMap<V, K> inverse;
  final Map<K, V> unmodifiableMap;
  transient Set<V> values;
  
  static
  {
    JniLib.a(UnmodifiableBiMap.class, 637);
  }
  
  Maps$UnmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1)
  {
    this.unmodifiableMap = Collections.unmodifiableMap(paramBiMap);
    this.delegate = paramBiMap;
    this.inverse = paramBiMap1;
  }
  
  protected native Map<K, V> delegate();
  
  public native V forcePut(K paramK, V paramV);
  
  public native BiMap<V, K> inverse();
  
  public native Set<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$UnmodifiableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */