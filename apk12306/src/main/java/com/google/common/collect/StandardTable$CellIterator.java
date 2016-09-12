package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$CellIterator
  implements Iterator<Table.Cell<R, C, V>>
{
  Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
  Map.Entry<R, Map<C, V>> rowEntry;
  final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = this.this$0.backingMap.entrySet().iterator();
  
  static
  {
    JniLib.a(CellIterator.class, 752);
  }
  
  private StandardTable$CellIterator(StandardTable paramStandardTable) {}
  
  public native boolean hasNext();
  
  public native Table.Cell<R, C, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$CellIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */