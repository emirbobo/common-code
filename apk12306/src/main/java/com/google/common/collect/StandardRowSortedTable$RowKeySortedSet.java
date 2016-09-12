package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;

class StandardRowSortedTable$RowKeySortedSet
  extends StandardTable<R, C, V>.RowKeySet
  implements SortedSet<R>
{
  static
  {
    JniLib.a(RowKeySortedSet.class, 746);
  }
  
  private StandardRowSortedTable$RowKeySortedSet(StandardRowSortedTable paramStandardRowSortedTable)
  {
    super(paramStandardRowSortedTable);
  }
  
  public native Comparator<? super R> comparator();
  
  public native R first();
  
  public native SortedSet<R> headSet(R paramR);
  
  public native R last();
  
  public native SortedSet<R> subSet(R paramR1, R paramR2);
  
  public native SortedSet<R> tailSet(R paramR);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardRowSortedTable$RowKeySortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */