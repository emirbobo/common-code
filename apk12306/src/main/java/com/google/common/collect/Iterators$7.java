package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Iterator;

final class Iterators$7
  extends AbstractIterator<T>
{
  static
  {
    JniLib.a(7.class, 542);
  }
  
  Iterators$7(Iterator paramIterator, Predicate paramPredicate) {}
  
  protected native T computeNext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */