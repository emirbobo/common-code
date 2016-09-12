package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredKeyMap<K, V>
  extends Maps.AbstractFilteredMap<K, V>
{
  Set<Map.Entry<K, V>> entrySet;
  Predicate<? super K> keyPredicate;
  Set<K> keySet;
  
  static
  {
    JniLib.a(FilteredKeyMap.class, 629);
  }
  
  Maps$FilteredKeyMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<Map.Entry<K, V>> paramPredicate1)
  {
    super(paramMap, paramPredicate1);
    this.keyPredicate = paramPredicate;
  }
  
  public native boolean containsKey(Object paramObject);
  
  public native Set<Map.Entry<K, V>> entrySet();
  
  public native Set<K> keySet();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredKeyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */