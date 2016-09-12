package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Multimaps$UnmodifiableAsMapEntries<K, V>
  extends ForwardingSet<Map.Entry<K, Collection<V>>>
{
  private final Set<Map.Entry<K, Collection<V>>> delegate;
  
  static
  {
    JniLib.a(UnmodifiableAsMapEntries.class, 671);
  }
  
  Multimaps$UnmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet)
  {
    this.delegate = paramSet;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Set<Map.Entry<K, Collection<V>>> delegate();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableAsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */