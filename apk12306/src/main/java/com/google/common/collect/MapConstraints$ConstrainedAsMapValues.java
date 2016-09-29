package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedAsMapValues<K, V>
  extends ForwardingCollection<Collection<V>>
{
  final Collection<Collection<V>> delegate;
  final Set<Map.Entry<K, Collection<V>>> entrySet;
  
  static
  {
    JniLib.a(ConstrainedAsMapValues.class, 595);
  }
  
  MapConstraints$ConstrainedAsMapValues(Collection<Collection<V>> paramCollection, Set<Map.Entry<K, Collection<V>>> paramSet)
  {
    this.delegate = paramCollection;
    this.entrySet = paramSet;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Collection<Collection<V>> delegate();
  
  public native Iterator<Collection<V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedAsMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */