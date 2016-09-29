package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class ConcurrentHashMultiset$EntrySet$1
  implements Iterator<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(1.class, 386);
  }
  
  ConcurrentHashMultiset$EntrySet$1(ConcurrentHashMultiset.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<E> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ConcurrentHashMultiset$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */