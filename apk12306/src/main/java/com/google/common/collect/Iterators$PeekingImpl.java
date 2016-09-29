package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Iterator;

class Iterators$PeekingImpl<E>
  implements PeekingIterator<E>
{
  private boolean hasPeeked;
  private final Iterator<? extends E> iterator;
  private E peekedElement;
  
  static
  {
    JniLib.a(PeekingImpl.class, 545);
  }
  
  public Iterators$PeekingImpl(Iterator<? extends E> paramIterator)
  {
    this.iterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
  }
  
  public native boolean hasNext();
  
  public native E next();
  
  public native E peek();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$PeekingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */