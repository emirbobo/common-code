package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class ImmutableMultiset$EntrySet$1
  extends UnmodifiableIterator<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(1.class, 485);
  }
  
  ImmutableMultiset$EntrySet$1(ImmutableMultiset.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<E> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultiset$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */