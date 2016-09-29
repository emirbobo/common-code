package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;

class ConcurrentHashMultiset$1
  extends ForwardingSet<E>
{
  static
  {
    JniLib.a(1.class, 385);
  }
  
  ConcurrentHashMultiset$1(ConcurrentHashMultiset paramConcurrentHashMultiset, Set paramSet) {}
  
  protected native Set<E> delegate();
  
  public native boolean remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ConcurrentHashMultiset$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */