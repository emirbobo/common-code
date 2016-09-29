package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$14
  implements Iterable<T>
{
  static
  {
    JniLib.a(14.class, 518);
  }
  
  Iterables$14(Iterable paramIterable) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */