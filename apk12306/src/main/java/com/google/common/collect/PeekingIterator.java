package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract interface PeekingIterator<E>
  extends Iterator<E>
{
  public abstract E next();
  
  public abstract E peek();
  
  public abstract void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\PeekingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */