package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.Map.Entry;

@GwtCompatible(emulated=true, serializable=true)
class RegularImmutableBiMap<K, V>
  extends ImmutableBiMap<K, V>
{
  final transient ImmutableMap<K, V> delegate;
  final transient ImmutableBiMap<V, K> inverse;
  
  static
  {
    JniLib.a(RegularImmutableBiMap.class, 702);
  }
  
  RegularImmutableBiMap(ImmutableMap<K, V> paramImmutableMap)
  {
    this.delegate = paramImmutableMap;
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Iterator localIterator = paramImmutableMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramImmutableMap = (Map.Entry)localIterator.next();
      localBuilder.put(paramImmutableMap.getValue(), paramImmutableMap.getKey());
    }
    this.inverse = new RegularImmutableBiMap(localBuilder.build(), this);
  }
  
  RegularImmutableBiMap(ImmutableMap<K, V> paramImmutableMap, ImmutableBiMap<V, K> paramImmutableBiMap)
  {
    this.delegate = paramImmutableMap;
    this.inverse = paramImmutableBiMap;
  }
  
  native ImmutableMap<K, V> delegate();
  
  public native ImmutableBiMap<V, K> inverse();
  
  native boolean isPartialView();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */