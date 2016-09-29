package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class StandardTable$ColumnMap$ColumnMapValues
  extends StandardTable<R, C, V>.TableCollection<Map<R, V>>
{
  static
  {
    JniLib.a(ColumnMapValues.class, 767);
  }
  
  private StandardTable$ColumnMap$ColumnMapValues(StandardTable.ColumnMap paramColumnMap)
  {
    super(paramColumnMap.this$0, null);
  }
  
  public native Iterator<Map<R, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnMap$ColumnMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */