package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedBiMap<K, V>
  extends Synchronized.SynchronizedMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  private transient BiMap<V, K> inverse;
  private transient Set<V> valueSet;
  
  static
  {
    JniLib.a(SynchronizedBiMap.class, 787);
  }
  
  private Synchronized$SynchronizedBiMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject, @Nullable BiMap<V, K> paramBiMap1)
  {
    super(paramBiMap, paramObject);
    this.inverse = paramBiMap1;
  }
  
  native BiMap<K, V> delegate();
  
  public native V forcePut(K paramK, V paramV);
  
  public native BiMap<V, K> inverse();
  
  public native Set<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */