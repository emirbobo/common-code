package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;

class StandardTable$ColumnKeySet
  extends StandardTable<R, C, V>.TableSet<C>
{
  static
  {
    JniLib.a(ColumnKeySet.class, 764);
  }
  
  private StandardTable$ColumnKeySet(StandardTable paramStandardTable)
  {
    super(paramStandardTable, null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<C> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */