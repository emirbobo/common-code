package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSetMultimap<K, V>
  extends Synchronized.SynchronizedMultimap<K, V>
  implements SetMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  transient Set<Map.Entry<K, V>> entrySet;
  
  static
  {
    JniLib.a(SynchronizedSetMultimap.class, 792);
  }
  
  Synchronized$SynchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject)
  {
    super(paramSetMultimap, paramObject);
  }
  
  native SetMultimap<K, V> delegate();
  
  public native Set<Map.Entry<K, V>> entries();
  
  public native Set<V> get(K paramK);
  
  public native Set<V> removeAll(Object paramObject);
  
  public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */