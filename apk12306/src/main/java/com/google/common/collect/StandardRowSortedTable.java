package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable<R, C, V>
  extends StandardTable<R, C, V>
  implements RowSortedTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  private transient SortedSet<R> rowKeySet;
  private transient StandardRowSortedTable<R, C, V>.RowSortedMap rowMap;
  
  static
  {
    JniLib.a(StandardRowSortedTable.class, 749);
  }
  
  StandardRowSortedTable(SortedMap<R, Map<C, V>> paramSortedMap, Supplier<? extends Map<C, V>> paramSupplier)
  {
    super(paramSortedMap, paramSupplier);
  }
  
  private native SortedMap<R, Map<C, V>> sortedBackingMap();
  
  public native SortedSet<R> rowKeySet();
  
  public native SortedMap<R, Map<C, V>> rowMap();
  
  private class RowKeySortedSet
    extends StandardTable<R, C, V>.RowKeySet
    implements SortedSet<R>
  {
    static
    {
      JniLib.a(RowKeySortedSet.class, 746);
    }
    
    private RowKeySortedSet()
    {
      super();
    }
    
    public native Comparator<? super R> comparator();
    
    public native R first();
    
    public native SortedSet<R> headSet(R paramR);
    
    public native R last();
    
    public native SortedSet<R> subSet(R paramR1, R paramR2);
    
    public native SortedSet<R> tailSet(R paramR);
  }
  
  private class RowSortedMap
    extends StandardTable<R, C, V>.RowMap
    implements SortedMap<R, Map<C, V>>
  {
    static
    {
      JniLib.a(RowSortedMap.class, 748);
    }
    
    private RowSortedMap()
    {
      super();
    }
    
    public native Comparator<? super R> comparator();
    
    public native R firstKey();
    
    public native SortedMap<R, Map<C, V>> headMap(R paramR);
    
    public native R lastKey();
    
    public native SortedMap<R, Map<C, V>> subMap(R paramR1, R paramR2);
    
    public native SortedMap<R, Map<C, V>> tailMap(R paramR);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardRowSortedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */