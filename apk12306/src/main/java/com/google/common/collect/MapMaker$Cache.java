package com.google.common.collect;

import com.google.common.base.Function;
import java.util.concurrent.ConcurrentMap;

abstract interface MapMaker$Cache<K, V>
  extends Function<K, V>
{
  public abstract ConcurrentMap<K, V> asMap();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker$Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */