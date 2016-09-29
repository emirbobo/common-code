package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMap<K, V>
  extends ForwardingMap<K, V>
{
  final MapConstraint<? super K, ? super V> constraint;
  private final Map<K, V> delegate;
  private transient Set<Map.Entry<K, V>> entrySet;
  
  static
  {
    JniLib.a(ConstrainedMap.class, 596);
  }
  
  MapConstraints$ConstrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    this.delegate = ((Map)Preconditions.checkNotNull(paramMap));
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
  }
  
  protected native Map<K, V> delegate();
  
  public native Set<Map.Entry<K, V>> entrySet();
  
  public native V put(K paramK, V paramV);
  
  public native void putAll(Map<? extends K, ? extends V> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */