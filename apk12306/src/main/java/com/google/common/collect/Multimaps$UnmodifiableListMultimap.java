package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;

class Multimaps$UnmodifiableListMultimap<K, V>
  extends Multimaps.UnmodifiableMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(UnmodifiableListMultimap.class, 675);
  }
  
  Multimaps$UnmodifiableListMultimap(ListMultimap<K, V> paramListMultimap)
  {
    super(paramListMultimap);
  }
  
  public native ListMultimap<K, V> delegate();
  
  public native List<V> get(K paramK);
  
  public native List<V> removeAll(Object paramObject);
  
  public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */