package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class Iterables$8
  extends Iterables.IterableWithToString<T>
{
  static
  {
    JniLib.a(8.class, 526);
  }
  
  Iterables$8(Iterable paramIterable, Class paramClass) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */