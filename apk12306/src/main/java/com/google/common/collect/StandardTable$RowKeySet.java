package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class StandardTable$RowKeySet
  extends StandardTable<R, C, V>.TableSet<R>
{
  static
  {
    JniLib.a(RowKeySet.class, 745);
  }
  
  StandardTable$RowKeySet(StandardTable paramStandardTable)
  {
    super(paramStandardTable, null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<R> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$RowKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */