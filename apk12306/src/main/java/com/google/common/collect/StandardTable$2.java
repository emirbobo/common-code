package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class StandardTable$2
  implements Iterator<V>
{
  static
  {
    JniLib.a(2.class, 751);
  }
  
  StandardTable$2(Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */