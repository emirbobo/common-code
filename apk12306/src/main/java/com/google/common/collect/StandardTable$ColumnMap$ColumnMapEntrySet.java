package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$ColumnMap$ColumnMapEntrySet
  extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
{
  static
  {
    JniLib.a(ColumnMapEntrySet.class, 766);
  }
  
  StandardTable$ColumnMap$ColumnMapEntrySet(StandardTable.ColumnMap paramColumnMap)
  {
    super(paramColumnMap.this$0, null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<C, Map<R, V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnMap$ColumnMapEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */