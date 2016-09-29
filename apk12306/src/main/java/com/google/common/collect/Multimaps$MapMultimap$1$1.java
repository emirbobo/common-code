package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Multimaps$MapMultimap$1$1
  implements Iterator<V>
{
  int i;
  
  static
  {
    JniLib.a(1.class, 654);
  }
  
  Multimaps$MapMultimap$1$1(Multimaps.MapMultimap.1 param1) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */