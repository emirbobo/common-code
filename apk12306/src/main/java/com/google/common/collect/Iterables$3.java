package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$3
  extends Iterables.IterableWithToString<T>
{
  static
  {
    JniLib.a(3.class, 521);
  }
  
  Iterables$3(Iterable paramIterable) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */