package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedBiMap<K, V>
  extends MapConstraints.ConstrainedMap<K, V>
  implements BiMap<K, V>
{
  volatile BiMap<V, K> inverse;
  
  static
  {
    JniLib.a(ConstrainedBiMap.class, 597);
  }
  
  MapConstraints$ConstrainedBiMap(BiMap<K, V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    super(paramBiMap, paramMapConstraint);
    this.inverse = paramBiMap1;
  }
  
  protected native BiMap<K, V> delegate();
  
  public native V forcePut(K paramK, V paramV);
  
  public native BiMap<V, K> inverse();
  
  public native Set<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */