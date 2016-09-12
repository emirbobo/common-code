package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Multisets$ElementSetImpl$1
  implements Iterator<E>
{
  static
  {
    JniLib.a(1.class, 684);
  }
  
  Multisets$ElementSetImpl$1(Multisets.ElementSetImpl paramElementSetImpl, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$ElementSetImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */