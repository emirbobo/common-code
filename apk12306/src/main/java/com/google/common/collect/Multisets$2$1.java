package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;

class Multisets$2$1
  extends AbstractSet<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(1.class, 682);
  }
  
  Multisets$2$1(Multisets.2 param2) {}
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<Multiset.Entry<E>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */