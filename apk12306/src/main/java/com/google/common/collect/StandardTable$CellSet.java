package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class StandardTable$CellSet
  extends StandardTable<R, C, V>.TableSet<Table.Cell<R, C, V>>
{
  static
  {
    JniLib.a(CellSet.class, 753);
  }
  
  private StandardTable$CellSet(StandardTable paramStandardTable)
  {
    super(paramStandardTable, null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Table.Cell<R, C, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$CellSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */