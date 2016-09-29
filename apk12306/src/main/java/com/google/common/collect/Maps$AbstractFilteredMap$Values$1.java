package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Maps$AbstractFilteredMap$Values$1
  extends UnmodifiableIterator<V>
{
  static
  {
    JniLib.a(1.class, 619);
  }
  
  Maps$AbstractFilteredMap$Values$1(Maps.AbstractFilteredMap.Values paramValues, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$AbstractFilteredMap$Values$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */