package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

class MapMaker$ComputingMapAdapter<K, V>
  extends ForwardingConcurrentMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final MapMaker.Cache<K, V> cache;
  
  static
  {
    JniLib.a(ComputingMapAdapter.class, 611);
  }
  
  MapMaker$ComputingMapAdapter(MapMaker.Cache<K, V> paramCache)
  {
    this.cache = paramCache;
  }
  
  protected native ConcurrentMap<K, V> delegate();
  
  public native V get(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker$ComputingMapAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */