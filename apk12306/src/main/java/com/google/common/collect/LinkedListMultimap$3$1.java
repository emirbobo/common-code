package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class LinkedListMultimap$3$1
  implements Iterator<V>
{
  static
  {
    JniLib.a(1.class, 555);
  }
  
  LinkedListMultimap$3$1(LinkedListMultimap.3 param3, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */