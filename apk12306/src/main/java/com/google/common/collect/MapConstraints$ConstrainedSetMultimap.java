package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedSetMultimap<K, V>
  extends MapConstraints.ConstrainedMultimap<K, V>
  implements SetMultimap<K, V>
{
  static
  {
    JniLib.a(ConstrainedSetMultimap.class, 605);
  }
  
  MapConstraints$ConstrainedSetMultimap(SetMultimap<K, V> paramSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    super(paramSetMultimap, paramMapConstraint);
  }
  
  public native Set<Map.Entry<K, V>> entries();
  
  public native Set<V> get(K paramK);
  
  public native Set<V> removeAll(Object paramObject);
  
  public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */