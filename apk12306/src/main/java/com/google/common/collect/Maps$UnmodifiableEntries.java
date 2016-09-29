package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$UnmodifiableEntries<K, V>
  extends ForwardingCollection<Map.Entry<K, V>>
{
  private final Collection<Map.Entry<K, V>> entries;
  
  static
  {
    JniLib.a(UnmodifiableEntries.class, 639);
  }
  
  Maps$UnmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection)
  {
    this.entries = paramCollection;
  }
  
  public native boolean add(Map.Entry<K, V> paramEntry);
  
  public native boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection);
  
  public native void clear();
  
  protected native Collection<Map.Entry<K, V>> delegate();
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$UnmodifiableEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */