package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapEntries<K, V>
  extends Synchronized.SynchronizedSet<Map.Entry<K, Collection<V>>>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedAsMapEntries.class, 784);
  }
  
  Synchronized$SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, @Nullable Object paramObject)
  {
    super(paramSet, paramObject);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(Object paramObject);
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedAsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */