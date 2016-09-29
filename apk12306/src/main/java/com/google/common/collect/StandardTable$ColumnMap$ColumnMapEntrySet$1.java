package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$ColumnMap$ColumnMapEntrySet$1
  extends UnmodifiableIterator<Map.Entry<C, Map<R, V>>>
{
  static
  {
    JniLib.a(1.class, 765);
  }
  
  StandardTable$ColumnMap$ColumnMapEntrySet$1(StandardTable.ColumnMap.ColumnMapEntrySet paramColumnMapEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<C, Map<R, V>> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnMap$ColumnMapEntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */