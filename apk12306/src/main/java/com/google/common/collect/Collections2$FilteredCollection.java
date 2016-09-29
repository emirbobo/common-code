package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;

class Collections2$FilteredCollection<E>
  implements Collection<E>
{
  final Predicate<? super E> predicate;
  final Collection<E> unfiltered;
  
  static
  {
    JniLib.a(FilteredCollection.class, 369);
  }
  
  Collections2$FilteredCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate)
  {
    this.unfiltered = paramCollection;
    this.predicate = paramPredicate;
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  native FilteredCollection<E> createCombined(Predicate<? super E> paramPredicate);
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Collections2$FilteredCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */