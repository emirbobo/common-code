package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;

class MapConstraints$ConstrainedListMultimap<K, V>
  extends MapConstraints.ConstrainedMultimap<K, V>
  implements ListMultimap<K, V>
{
  static
  {
    JniLib.a(ConstrainedListMultimap.class, 602);
  }
  
  MapConstraints$ConstrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    super(paramListMultimap, paramMapConstraint);
  }
  
  public native List<V> get(K paramK);
  
  public native List<V> removeAll(Object paramObject);
  
  public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */