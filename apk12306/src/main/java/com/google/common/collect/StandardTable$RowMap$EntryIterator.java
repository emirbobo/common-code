package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$RowMap$EntryIterator
  implements Iterator<Map.Entry<R, Map<C, V>>>
{
  final Iterator<R> delegate = this.this$1.this$0.backingMap.keySet().iterator();
  
  static
  {
    JniLib.a(EntryIterator.class, 773);
  }
  
  StandardTable$RowMap$EntryIterator(StandardTable.RowMap paramRowMap) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<R, Map<C, V>> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$RowMap$EntryIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */