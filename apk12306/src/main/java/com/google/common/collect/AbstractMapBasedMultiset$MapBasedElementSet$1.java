package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

class AbstractMapBasedMultiset$MapBasedElementSet$1
  implements Iterator<E>
{
  Map.Entry<E, AtomicInteger> toRemove;
  
  static
  {
    JniLib.a(1.class, 339);
  }
  
  AbstractMapBasedMultiset$MapBasedElementSet$1(AbstractMapBasedMultiset.MapBasedElementSet paramMapBasedElementSet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$MapBasedElementSet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */