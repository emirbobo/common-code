package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class StandardTable$Values$1
  implements Iterator<V>
{
  static
  {
    JniLib.a(1.class, 775);
  }
  
  StandardTable$Values$1(StandardTable.Values paramValues, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Values$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */