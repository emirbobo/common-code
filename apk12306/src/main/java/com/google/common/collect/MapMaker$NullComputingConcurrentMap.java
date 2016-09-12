package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

final class MapMaker$NullComputingConcurrentMap<K, V>
  extends MapMaker.NullConcurrentMap<K, V>
  implements MapMaker.Cache<K, V>
{
  private static final long serialVersionUID = 0L;
  final Function<? super K, ? extends V> computingFunction;
  
  static
  {
    JniLib.a(NullComputingConcurrentMap.class, 613);
  }
  
  MapMaker$NullComputingConcurrentMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  private native V compute(K paramK);
  
  public native V apply(K paramK);
  
  public native ConcurrentMap<K, V> asMap();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker$NullComputingConcurrentMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */