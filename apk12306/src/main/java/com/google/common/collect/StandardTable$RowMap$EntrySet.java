package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$RowMap$EntrySet
  extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
{
  static
  {
    JniLib.a(EntrySet.class, 774);
  }
  
  StandardTable$RowMap$EntrySet(StandardTable.RowMap paramRowMap)
  {
    super(paramRowMap.this$0, null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<R, Map<C, V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$RowMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */