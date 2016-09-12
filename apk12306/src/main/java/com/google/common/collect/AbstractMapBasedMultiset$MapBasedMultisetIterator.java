package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class AbstractMapBasedMultiset$MapBasedMultisetIterator
  implements Iterator<E>
{
  boolean canRemove;
  Map.Entry<E, AtomicInteger> currentEntry;
  final Iterator<Map.Entry<E, AtomicInteger>> entryIterator;
  int occurrencesLeft;
  
  static
  {
    JniLib.a(MapBasedMultisetIterator.class, 341);
  }
  
  AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset paramAbstractMapBasedMultiset)
  {
    this.entryIterator = AbstractMapBasedMultiset.access$100(paramAbstractMapBasedMultiset).entrySet().iterator();
  }
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$MapBasedMultisetIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */