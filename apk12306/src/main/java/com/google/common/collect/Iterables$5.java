package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.List;

final class Iterables$5
  extends Iterables.IterableWithToString<List<T>>
{
  static
  {
    JniLib.a(5.class, 523);
  }
  
  Iterables$5(Iterable paramIterable, int paramInt) {}
  
  public native Iterator<List<T>> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */