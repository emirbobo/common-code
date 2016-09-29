package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterables$7
  extends Iterables.IterableWithToString<T>
{
  static
  {
    JniLib.a(7.class, 525);
  }
  
  Iterables$7(Iterable paramIterable, Predicate paramPredicate) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */