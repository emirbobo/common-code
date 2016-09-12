package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$2
  implements Iterable<T>
{
  static
  {
    JniLib.a(2.class, 520);
  }
  
  Iterables$2(Iterable paramIterable) {}
  
  public native Iterator<T> iterator();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */