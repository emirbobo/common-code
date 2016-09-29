package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterators$2
  implements Iterator<Object>
{
  static
  {
    JniLib.a(2.class, 537);
  }
  
  public native boolean hasNext();
  
  public native Object next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */