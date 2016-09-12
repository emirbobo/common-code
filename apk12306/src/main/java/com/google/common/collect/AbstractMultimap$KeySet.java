package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$KeySet
  extends AbstractSet<K>
{
  final Map<K, Collection<V>> subMap;
  
  static
  {
    JniLib.a(KeySet.class, 349);
  }
  
  AbstractMultimap$KeySet(Map<K, Collection<V>> paramMap)
  {
    Map localMap;
    this.subMap = localMap;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native Iterator<K> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */