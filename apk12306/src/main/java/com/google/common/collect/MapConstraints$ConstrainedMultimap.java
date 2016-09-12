package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMultimap<K, V>
  extends ForwardingMultimap<K, V>
{
  transient Map<K, Collection<V>> asMap;
  final MapConstraint<? super K, ? super V> constraint;
  final Multimap<K, V> delegate;
  transient Collection<Map.Entry<K, V>> entries;
  
  static
  {
    JniLib.a(ConstrainedMultimap.class, 601);
  }
  
  public MapConstraints$ConstrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
  }
  
  public native Map<K, Collection<V>> asMap();
  
  protected native Multimap<K, V> delegate();
  
  public native Collection<Map.Entry<K, V>> entries();
  
  public native Collection<V> get(K paramK);
  
  public native boolean put(K paramK, V paramV);
  
  public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
  
  public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
  
  public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */