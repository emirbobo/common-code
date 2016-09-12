package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.List;

final class Iterables$6
  extends Iterables.IterableWithToString<List<T>>
{
  static
  {
    JniLib.a(6.class, 524);
  }
  
  Iterables$6(Iterable paramIterable, int paramInt) {}
  
  public native Iterator<List<T>> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */