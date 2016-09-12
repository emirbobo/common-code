package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class Multisets$UnmodifiableMultiset<E>
  extends ForwardingMultiset<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Multiset<? extends E> delegate;
  transient Set<E> elementSet;
  transient Set<Multiset.Entry<E>> entrySet;
  
  static
  {
    JniLib.a(UnmodifiableMultiset.class, 691);
  }
  
  Multisets$UnmodifiableMultiset(Multiset<? extends E> paramMultiset)
  {
    this.delegate = paramMultiset;
  }
  
  public native int add(E paramE, int paramInt);
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  public native void clear();
  
  protected native Multiset<E> delegate();
  
  public native Set<E> elementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
  
  public native Iterator<E> iterator();
  
  public native int remove(Object paramObject, int paramInt);
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$UnmodifiableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */