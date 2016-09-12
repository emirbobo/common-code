package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

class AbstractMapBasedMultiset$EntrySet
  extends AbstractSet<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(EntrySet.class, 338);
  }
  
  private AbstractMapBasedMultiset$EntrySet(AbstractMapBasedMultiset paramAbstractMapBasedMultiset) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Multiset.Entry<E>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */