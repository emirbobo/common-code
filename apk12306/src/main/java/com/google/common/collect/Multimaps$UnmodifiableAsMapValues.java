package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

class Multimaps$UnmodifiableAsMapValues<V>
  extends ForwardingCollection<Collection<V>>
{
  final Collection<Collection<V>> delegate;
  
  static
  {
    JniLib.a(UnmodifiableAsMapValues.class, 673);
  }
  
  Multimaps$UnmodifiableAsMapValues(Collection<Collection<V>> paramCollection)
  {
    this.delegate = Collections.unmodifiableCollection(paramCollection);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Collection<Collection<V>> delegate();
  
  public native Iterator<Collection<V>> iterator();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableAsMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */