package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries<K, V>
  extends ForwardingCollection<Map.Entry<K, V>>
{
  final MapConstraint<? super K, ? super V> constraint;
  final Collection<Map.Entry<K, V>> entries;
  
  static
  {
    JniLib.a(ConstrainedEntries.class, 599);
  }
  
  MapConstraints$ConstrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    this.entries = paramCollection;
    this.constraint = paramMapConstraint;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Collection<Map.Entry<K, V>> delegate();
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */