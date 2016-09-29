package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class ImmutableMultiset$1
  extends UnmodifiableIterator<E>
{
  E element;
  int remaining;
  
  static
  {
    JniLib.a(1.class, 483);
  }
  
  ImmutableMultiset$1(ImmutableMultiset paramImmutableMultiset, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native E next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultiset$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */