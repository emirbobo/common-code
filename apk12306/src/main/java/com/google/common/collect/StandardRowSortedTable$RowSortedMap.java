package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

class StandardRowSortedTable$RowSortedMap
  extends StandardTable<R, C, V>.RowMap
  implements SortedMap<R, Map<C, V>>
{
  static
  {
    JniLib.a(RowSortedMap.class, 748);
  }
  
  private StandardRowSortedTable$RowSortedMap(StandardRowSortedTable paramStandardRowSortedTable)
  {
    super(paramStandardRowSortedTable);
  }
  
  public native Comparator<? super R> comparator();
  
  public native R firstKey();
  
  public native SortedMap<R, Map<C, V>> headMap(R paramR);
  
  public native R lastKey();
  
  public native SortedMap<R, Map<C, V>> subMap(R paramR1, R paramR2);
  
  public native SortedMap<R, Map<C, V>> tailMap(R paramR);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardRowSortedTable$RowSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */