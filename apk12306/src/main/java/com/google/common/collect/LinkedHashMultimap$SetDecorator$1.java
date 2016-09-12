package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class LinkedHashMultimap$SetDecorator$1
  implements Iterator<V>
{
  V value;
  
  static
  {
    JniLib.a(1.class, 549);
  }
  
  LinkedHashMultimap$SetDecorator$1(LinkedHashMultimap.SetDecorator paramSetDecorator, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedHashMultimap$SetDecorator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */