package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Multisets$MultisetIteratorImpl<E>
  implements Iterator<E>
{
  private boolean canRemove;
  private Multiset.Entry<E> currentEntry;
  private final Iterator<Multiset.Entry<E>> entryIterator;
  private int laterCount;
  private final Multiset<E> multiset;
  private int totalCount;
  
  static
  {
    JniLib.a(MultisetIteratorImpl.class, 686);
  }
  
  Multisets$MultisetIteratorImpl(Multiset<E> paramMultiset, Iterator<Multiset.Entry<E>> paramIterator)
  {
    this.multiset = paramMultiset;
    this.entryIterator = paramIterator;
  }
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$MultisetIteratorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */