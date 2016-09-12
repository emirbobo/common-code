package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedCollection<E>
  extends Synchronized.SynchronizedObject
  implements Collection<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedCollection.class, 782);
  }
  
  private Synchronized$SynchronizedCollection(Collection<E> paramCollection, @Nullable Object paramObject)
  {
    super(paramCollection, paramObject);
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  native Collection<E> delegate();
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */