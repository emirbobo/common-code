package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Multisets$2$1$1
  extends AbstractIterator<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(1.class, 681);
  }
  
  Multisets$2$1$1(Multisets.2.1 param1, Iterator paramIterator) {}
  
  protected native Multiset.Entry<E> computeNext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$2$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */