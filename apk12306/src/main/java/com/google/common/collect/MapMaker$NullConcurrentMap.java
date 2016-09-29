package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

class MapMaker$NullConcurrentMap<K, V>
  extends AbstractMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  final MapEvictionListener<K, V> evictionListener;
  
  static
  {
    JniLib.a(NullConcurrentMap.class, 612);
  }
  
  MapMaker$NullConcurrentMap(MapMaker paramMapMaker)
  {
    this.evictionListener = paramMapMaker.getEvictionListener();
  }
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  public native Set<Map.Entry<K, V>> entrySet();
  
  public native V get(Object paramObject);
  
  public native V put(K paramK, V paramV);
  
  public native V putIfAbsent(K paramK, V paramV);
  
  public native V remove(Object paramObject);
  
  public native boolean remove(Object paramObject1, Object paramObject2);
  
  public native V replace(K paramK, V paramV);
  
  public native boolean replace(K paramK, V paramV1, V paramV2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker$NullConcurrentMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */