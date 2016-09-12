package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Tables
{
  static
  {
    JniLib.a(Tables.class, 801);
  }
  
  public static native <R, C, V> Table.Cell<R, C, V> immutableCell(@Nullable R paramR, @Nullable C paramC, @Nullable V paramV);
  
  public static native <R, C, V> Table<C, R, V> transpose(Table<R, C, V> paramTable);
  
  static abstract class AbstractCell<R, C, V>
    implements Table.Cell<R, C, V>
  {
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {}
      for (;;)
      {
        return bool;
        if ((paramObject instanceof Table.Cell))
        {
          paramObject = (Table.Cell)paramObject;
          if ((!Objects.equal(getRowKey(), ((Table.Cell)paramObject).getRowKey())) || (!Objects.equal(getColumnKey(), ((Table.Cell)paramObject).getColumnKey())) || (!Objects.equal(getValue(), ((Table.Cell)paramObject).getValue()))) {
            bool = false;
          }
        }
        else
        {
          bool = false;
        }
      }
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { getRowKey(), getColumnKey(), getValue() });
    }
    
    public String toString()
    {
      return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
    }
  }
  
  private static class ImmutableCell<R, C, V>
    extends Tables.AbstractCell<R, C, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final C columnKey;
    final R rowKey;
    final V value;
    
    static
    {
      JniLib.a(ImmutableCell.class, 797);
    }
    
    ImmutableCell(@Nullable R paramR, @Nullable C paramC, @Nullable V paramV)
    {
      this.rowKey = paramR;
      this.columnKey = paramC;
      this.value = paramV;
    }
    
    public native C getColumnKey();
    
    public native R getRowKey();
    
    public native V getValue();
  }
  
  private static class TransposeTable<C, R, V>
    implements Table<C, R, V>
  {
    private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = new Function()
    {
      static
      {
        JniLib.a(1.class, 798);
      }
      
      public native Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> paramAnonymousCell);
    };
    TransposeTable<C, R, V>.CellSet cellSet;
    final Table<R, C, V> original;
    
    static
    {
      JniLib.a(TransposeTable.class, 800);
    }
    
    TransposeTable(Table<R, C, V> paramTable)
    {
      this.original = ((Table)Preconditions.checkNotNull(paramTable));
    }
    
    public native Set<Table.Cell<C, R, V>> cellSet();
    
    public native void clear();
    
    public native Map<C, V> column(R paramR);
    
    public native Set<R> columnKeySet();
    
    public native Map<R, Map<C, V>> columnMap();
    
    public native boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2);
    
    public native boolean containsColumn(@Nullable Object paramObject);
    
    public native boolean containsRow(@Nullable Object paramObject);
    
    public native boolean containsValue(@Nullable Object paramObject);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native V get(@Nullable Object paramObject1, @Nullable Object paramObject2);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native V put(C paramC, R paramR, V paramV);
    
    public native void putAll(Table<? extends C, ? extends R, ? extends V> paramTable);
    
    public native V remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
    
    public native Map<R, V> row(C paramC);
    
    public native Set<C> rowKeySet();
    
    public native Map<C, Map<R, V>> rowMap();
    
    public native int size();
    
    public native String toString();
    
    public native Collection<V> values();
    
    class CellSet
      extends Collections2.TransformedCollection<Table.Cell<R, C, V>, Table.Cell<C, R, V>>
      implements Set<Table.Cell<C, R, V>>
    {
      static
      {
        JniLib.a(CellSet.class, 799);
      }
      
      CellSet()
      {
        super(Tables.TransposeTable.TRANSPOSE_CELL);
      }
      
      public native boolean contains(Object paramObject);
      
      public native boolean equals(Object paramObject);
      
      public native int hashCode();
      
      public native boolean remove(Object paramObject);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Tables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */