package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$1
  implements Iterable<T>
{
  static
  {
    JniLib.a(1.class, 519);
  }
  
  Iterables$1(Iterable paramIterable) {}
  
  public native Iterator<T> iterator();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */