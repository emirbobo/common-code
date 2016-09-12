package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;
import javax.annotation.Nullable;

class Synchronized$SynchronizedListMultimap<K, V>
  extends Synchronized.SynchronizedMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedListMultimap.class, 790);
  }
  
  Synchronized$SynchronizedListMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject)
  {
    super(paramListMultimap, paramObject);
  }
  
  native ListMultimap<K, V> delegate();
  
  public native List<V> get(K paramK);
  
  public native List<V> removeAll(Object paramObject);
  
  public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */