package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

final class Multisets$ElementSetImpl<E>
  extends AbstractSet<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Multiset<E> multiset;
  
  static
  {
    JniLib.a(ElementSetImpl.class, 685);
  }
  
  Multisets$ElementSetImpl(Multiset<E> paramMultiset)
  {
    this.multiset = paramMultiset;
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$ElementSetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */