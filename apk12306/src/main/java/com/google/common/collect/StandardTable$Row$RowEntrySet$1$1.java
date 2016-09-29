package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class StandardTable$Row$RowEntrySet$1$1
  extends ForwardingMapEntry<C, V>
{
  static
  {
    JniLib.a(1.class, 769);
  }
  
  StandardTable$Row$RowEntrySet$1$1(StandardTable.Row.RowEntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected native Map.Entry<C, V> delegate();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Row$RowEntrySet$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */