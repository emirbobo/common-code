package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$9
  implements Iterator<T>
{
  private int count;
  
  static
  {
    JniLib.a(9.class, 544);
  }
  
  Iterators$9(int paramInt, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native T next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */