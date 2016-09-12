package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Enumeration;
import java.util.Iterator;

final class Iterators$15
  implements Enumeration<T>
{
  static
  {
    JniLib.a(15.class, 535);
  }
  
  Iterators$15(Iterator paramIterator) {}
  
  public native boolean hasMoreElements();
  
  public native T nextElement();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */