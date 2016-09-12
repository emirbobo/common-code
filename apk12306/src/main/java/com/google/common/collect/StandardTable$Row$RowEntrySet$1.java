package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Row$RowEntrySet$1
  implements Iterator<Map.Entry<C, V>>
{
  static
  {
    JniLib.a(1.class, 770);
  }
  
  StandardTable$Row$RowEntrySet$1(StandardTable.Row.RowEntrySet paramRowEntrySet, Iterator paramIterator, Map paramMap) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<C, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Row$RowEntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */