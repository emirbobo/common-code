package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class AbstractMapBasedMultiset$MapBasedElementSet
  extends ForwardingSet<E>
{
  private final Set<E> delegate;
  private final Map<E, AtomicInteger> map;
  
  static
  {
    JniLib.a(MapBasedElementSet.class, 340);
  }
  
  AbstractMapBasedMultiset$MapBasedElementSet(Map<E, AtomicInteger> paramMap)
  {
    Map localMap;
    this.map = localMap;
    this.delegate = localMap.keySet();
  }
  
  public native void clear();
  
  protected native Set<E> delegate();
  
  public native Map<E, AtomicInteger> getMap();
  
  public native Iterator<E> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$MapBasedElementSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */