package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable<R, C, V>
  implements Table<R, C, V>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Map<R, Map<C, V>> backingMap;
  private transient StandardTable<R, C, V>.CellSet cellSet;
  private transient Set<C> columnKeySet;
  private transient StandardTable<R, C, V>.ColumnMap columnMap;
  final Supplier<? extends Map<C, V>> factory;
  private transient StandardTable<R, C, V>.RowKeySet rowKeySet;
  private transient StandardTable<R, C, V>.RowMap rowMap;
  private transient StandardTable<R, C, V>.Values values;
  
  static
  {
    JniLib.a(StandardTable.class, 449);
  }
  
  StandardTable(Map<R, Map<C, V>> paramMap, Supplier<? extends Map<C, V>> paramSupplier)
  {
    this.backingMap = paramMap;
    this.factory = paramSupplier;
  }
  
  private native boolean containsMapping(Object paramObject1, Object paramObject2, Object paramObject3);
  
  private native Map<C, V> getOrCreate(R paramR);
  
  static native <K, V> Iterator<K> keyIteratorImpl(Map<K, V> paramMap);
  
  private native Map<R, V> removeColumn(Object paramObject);
  
  private native boolean removeMapping(Object paramObject1, Object paramObject2, Object paramObject3);
  
  static native <K, V> Iterator<V> valueIteratorImpl(Map<K, V> paramMap);
  
  public native Set<Table.Cell<R, C, V>> cellSet();
  
  public native void clear();
  
  public native Map<R, V> column(C paramC);
  
  public native Set<C> columnKeySet();
  
  public native Map<C, Map<R, V>> columnMap();
  
  public native boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native boolean containsColumn(@Nullable Object paramObject);
  
  public native boolean containsRow(@Nullable Object paramObject);
  
  public native boolean containsValue(@Nullable Object paramObject);
  
  native Iterator<C> createColumnKeyIterator();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native V get(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native V put(R paramR, C paramC, V paramV);
  
  public native void putAll(Table<? extends R, ? extends C, ? extends V> paramTable);
  
  public native V remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native Map<C, V> row(R paramR);
  
  public native Set<R> rowKeySet();
  
  public native Map<R, Map<C, V>> rowMap();
  
  public native int size();
  
  public native String toString();
  
  public native Collection<V> values();
  
  private class CellIterator
    implements Iterator<Table.Cell<R, C, V>>
  {
    Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
    Map.Entry<R, Map<C, V>> rowEntry;
    final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = StandardTable.this.backingMap.entrySet().iterator();
    
    static
    {
      JniLib.a(CellIterator.class, 752);
    }
    
    private CellIterator() {}
    
    public native boolean hasNext();
    
    public native Table.Cell<R, C, V> next();
    
    public native void remove();
  }
  
  private class CellSet
    extends StandardTable<R, C, V>.TableSet<Table.Cell<R, C, V>>
  {
    static
    {
      JniLib.a(CellSet.class, 753);
    }
    
    private CellSet()
    {
      super(null);
    }
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Table.Cell<R, C, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  private class Column
    extends Maps.ImprovedAbstractMap<R, V>
  {
    final C columnKey;
    StandardTable<R, C, V>.Column.Values columnValues;
    StandardTable<R, C, V>.Column.KeySet keySet;
    
    static
    {
      JniLib.a(Column.class, 762);
    }
    
    Column()
    {
      Object localObject;
      this.columnKey = Preconditions.checkNotNull(localObject);
    }
    
    public native boolean containsKey(Object paramObject);
    
    public native Set<Map.Entry<R, V>> createEntrySet();
    
    public native V get(Object paramObject);
    
    public native Set<R> keySet();
    
    public native V put(R paramR, V paramV);
    
    public native V remove(Object paramObject);
    
    native boolean removePredicate(Predicate<? super Map.Entry<R, V>> paramPredicate);
    
    public native Collection<V> values();
    
    class EntrySet
      extends AbstractSet<Map.Entry<R, V>>
    {
      static
      {
        JniLib.a(EntrySet.class, 754);
      }
      
      EntrySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native boolean isEmpty();
      
      public native Iterator<Map.Entry<R, V>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
    }
    
    class EntrySetIterator
      extends AbstractIterator<Map.Entry<R, V>>
    {
      final Iterator<Map.Entry<R, Map<C, V>>> iterator = StandardTable.this.backingMap.entrySet().iterator();
      
      static
      {
        JniLib.a(EntrySetIterator.class, 756);
      }
      
      EntrySetIterator() {}
      
      protected native Map.Entry<R, V> computeNext();
    }
    
    class KeySet
      extends AbstractSet<R>
    {
      static
      {
        JniLib.a(KeySet.class, 758);
      }
      
      KeySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native boolean isEmpty();
      
      public native Iterator<R> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
    }
    
    class Values
      extends AbstractCollection<V>
    {
      static
      {
        JniLib.a(Values.class, 761);
      }
      
      Values() {}
      
      public native void clear();
      
      public native boolean isEmpty();
      
      public native Iterator<V> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
    }
  }
  
  private class ColumnKeyIterator
    extends AbstractIterator<C>
  {
    Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
    final Iterator<Map<C, V>> mapIterator = StandardTable.this.backingMap.values().iterator();
    final Map<C, V> seen = (Map)StandardTable.this.factory.get();
    
    static
    {
      JniLib.a(ColumnKeyIterator.class, 763);
    }
    
    private ColumnKeyIterator() {}
    
    protected native C computeNext();
  }
  
  private class ColumnKeySet
    extends StandardTable<R, C, V>.TableSet<C>
  {
    static
    {
      JniLib.a(ColumnKeySet.class, 764);
    }
    
    private ColumnKeySet()
    {
      super(null);
    }
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<C> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
  
  private class ColumnMap
    extends Maps.ImprovedAbstractMap<C, Map<R, V>>
  {
    StandardTable<R, C, V>.ColumnMap.ColumnMapValues columnMapValues;
    
    static
    {
      JniLib.a(ColumnMap.class, 768);
    }
    
    private ColumnMap() {}
    
    public native boolean containsKey(Object paramObject);
    
    public native Set<Map.Entry<C, Map<R, V>>> createEntrySet();
    
    public native Map<R, V> get(Object paramObject);
    
    public native Set<C> keySet();
    
    public native Map<R, V> remove(Object paramObject);
    
    public native Collection<Map<R, V>> values();
    
    class ColumnMapEntrySet
      extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
    {
      static
      {
        JniLib.a(ColumnMapEntrySet.class, 766);
      }
      
      ColumnMapEntrySet()
      {
        super(null);
      }
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<C, Map<R, V>>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
    }
    
    private class ColumnMapValues
      extends StandardTable<R, C, V>.TableCollection<Map<R, V>>
    {
      static
      {
        JniLib.a(ColumnMapValues.class, 767);
      }
      
      private ColumnMapValues()
      {
        super(null);
      }
      
      public native Iterator<Map<R, V>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
    }
  }
  
  private class Row
    extends Maps.ImprovedAbstractMap<C, V>
  {
    final R rowKey;
    
    static
    {
      JniLib.a(Row.class, 772);
    }
    
    Row()
    {
      Object localObject;
      this.rowKey = Preconditions.checkNotNull(localObject);
    }
    
    public native boolean containsKey(Object paramObject);
    
    protected native Set<Map.Entry<C, V>> createEntrySet();
    
    public native V get(Object paramObject);
    
    public native V put(C paramC, V paramV);
    
    public native V remove(Object paramObject);
    
    private class RowEntrySet
      extends AbstractSet<Map.Entry<C, V>>
    {
      static
      {
        JniLib.a(RowEntrySet.class, 771);
      }
      
      private RowEntrySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<C, V>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
  }
  
  class RowKeySet
    extends StandardTable<R, C, V>.TableSet<R>
  {
    static
    {
      JniLib.a(RowKeySet.class, 745);
    }
    
    RowKeySet()
    {
      super(null);
    }
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<R> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  class RowMap
    extends Maps.ImprovedAbstractMap<R, Map<C, V>>
  {
    static
    {
      JniLib.a(RowMap.class, 747);
    }
    
    RowMap() {}
    
    public native boolean containsKey(Object paramObject);
    
    protected native Set<Map.Entry<R, Map<C, V>>> createEntrySet();
    
    public native Map<C, V> get(Object paramObject);
    
    public native Set<R> keySet();
    
    public native Map<C, V> remove(Object paramObject);
    
    class EntryIterator
      implements Iterator<Map.Entry<R, Map<C, V>>>
    {
      final Iterator<R> delegate = StandardTable.this.backingMap.keySet().iterator();
      
      static
      {
        JniLib.a(EntryIterator.class, 773);
      }
      
      EntryIterator() {}
      
      public native boolean hasNext();
      
      public native Map.Entry<R, Map<C, V>> next();
      
      public native void remove();
    }
    
    class EntrySet
      extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
    {
      static
      {
        JniLib.a(EntrySet.class, 774);
      }
      
      EntrySet()
      {
        super(null);
      }
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<R, Map<C, V>>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
  }
  
  private abstract class TableCollection<T>
    extends AbstractCollection<T>
  {
    private TableCollection() {}
    
    public void clear()
    {
      StandardTable.this.backingMap.clear();
    }
    
    public boolean isEmpty()
    {
      return StandardTable.this.backingMap.isEmpty();
    }
  }
  
  private abstract class TableSet<T>
    extends AbstractSet<T>
  {
    private TableSet() {}
    
    public void clear()
    {
      StandardTable.this.backingMap.clear();
    }
    
    public boolean isEmpty()
    {
      return StandardTable.this.backingMap.isEmpty();
    }
  }
  
  private class Values
    extends StandardTable<R, C, V>.TableCollection<V>
  {
    static
    {
      JniLib.a(Values.class, 776);
    }
    
    private Values()
    {
      super(null);
    }
    
    public native Iterator<V> iterator();
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */