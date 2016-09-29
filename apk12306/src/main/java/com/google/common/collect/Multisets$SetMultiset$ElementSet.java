package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Set;

class Multisets$SetMultiset$ElementSet
  extends ForwardingSet<E>
{
  static
  {
    JniLib.a(ElementSet.class, 687);
  }
  
  Multisets$SetMultiset$ElementSet(Multisets.SetMultiset paramSetMultiset) {}
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native Set<E> delegate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$SetMultiset$ElementSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */