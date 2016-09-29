package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedAsMapEntries<K, V>
  extends ForwardingSet<Map.Entry<K, Collection<V>>>
{
  private final MapConstraint<? super K, ? super V> constraint;
  private final Set<Map.Entry<K, Collection<V>>> entries;
  
  static
  {
    JniLib.a(ConstrainedAsMapEntries.class, 593);
  }
  
  MapConstraints$ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    this.entries = paramSet;
    this.constraint = paramMapConstraint;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Set<Map.Entry<K, Collection<V>>> delegate();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedAsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */