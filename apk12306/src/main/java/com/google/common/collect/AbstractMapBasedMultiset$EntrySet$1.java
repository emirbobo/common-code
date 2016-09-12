package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

class AbstractMapBasedMultiset$EntrySet$1
  implements Iterator<Multiset.Entry<E>>
{
  Map.Entry<E, AtomicInteger> toRemove;
  
  static
  {
    JniLib.a(1.class, 337);
  }
  
  AbstractMapBasedMultiset$EntrySet$1(AbstractMapBasedMultiset.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<E> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */