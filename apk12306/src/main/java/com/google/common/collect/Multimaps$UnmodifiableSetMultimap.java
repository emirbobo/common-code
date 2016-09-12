package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$UnmodifiableSetMultimap<K, V>
  extends Multimaps.UnmodifiableMultimap<K, V>
  implements SetMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(UnmodifiableSetMultimap.class, 677);
  }
  
  Multimaps$UnmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap)
  {
    super(paramSetMultimap);
  }
  
  public native SetMultimap<K, V> delegate();
  
  public native Set<Map.Entry<K, V>> entries();
  
  public native Set<V> get(K paramK);
  
  public native Set<V> removeAll(Object paramObject);
  
  public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */