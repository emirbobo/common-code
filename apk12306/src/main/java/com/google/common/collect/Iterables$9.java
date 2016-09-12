package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Iterator;

final class Iterables$9
  extends Iterables.IterableWithToString<T>
{
  static
  {
    JniLib.a(9.class, 527);
  }
  
  Iterables$9(Iterable paramIterable, Function paramFunction) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */