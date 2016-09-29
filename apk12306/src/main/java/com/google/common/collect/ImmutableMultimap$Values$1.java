package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class ImmutableMultimap$Values$1
  extends UnmodifiableIterator<V>
{
  static
  {
    JniLib.a(1.class, 481);
  }
  
  ImmutableMultimap$Values$1(ImmutableMultimap.Values paramValues, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultimap$Values$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */