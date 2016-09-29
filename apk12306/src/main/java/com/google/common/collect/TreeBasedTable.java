package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(serializable=true)
public class TreeBasedTable<R, C, V>
  extends StandardRowSortedTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  private final Comparator<? super C> columnComparator;
  
  static
  {
    JniLib.a(TreeBasedTable.class, 808);
  }
  
  TreeBasedTable(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1)
  {
    super(new TreeMap(paramComparator), new Factory(paramComparator1));
    this.columnComparator = paramComparator1;
  }
  
  public static native <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create();
  
  public static native <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> paramTreeBasedTable);
  
  public static native <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1);
  
  public native Comparator<? super C> columnComparator();
  
  public native boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native boolean containsColumn(@Nullable Object paramObject);
  
  public native boolean containsRow(@Nullable Object paramObject);
  
  public native boolean containsValue(@Nullable Object paramObject);
  
  native Iterator<C> createColumnKeyIterator();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native V get(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native V remove(@Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public native Comparator<? super R> rowComparator();
  
  public native SortedSet<R> rowKeySet();
  
  public native SortedMap<R, Map<C, V>> rowMap();
  
  private static class Factory<C, V>
    implements Supplier<TreeMap<C, V>>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final Comparator<? super C> comparator;
    
    static
    {
      JniLib.a(Factory.class, 805);
    }
    
    Factory(Comparator<? super C> paramComparator)
    {
      this.comparator = paramComparator;
    }
    
    public native TreeMap<C, V> get();
  }
  
  private static class MergingIterator<T>
    extends AbstractIterator<T>
  {
    private final Comparator<? super T> comparator;
    private T lastValue = null;
    private final Queue<PeekingIterator<T>> queue;
    
    static
    {
      JniLib.a(MergingIterator.class, 807);
    }
    
    public MergingIterator(Iterable<? extends Iterator<T>> paramIterable, Comparator<? super T> paramComparator)
    {
      this.comparator = paramComparator;
      paramComparator = new Comparator()
      {
        static
        {
          JniLib.a(1.class, 806);
        }
        
        public native int compare(PeekingIterator<T> paramAnonymousPeekingIterator1, PeekingIterator<T> paramAnonymousPeekingIterator2);
      };
      this.queue = new PriorityQueue(Math.max(1, Iterables.size(paramIterable)), paramComparator);
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        paramComparator = (Iterator)paramIterable.next();
        if (paramComparator.hasNext()) {
          this.queue.add(Iterators.peekingIterator(paramComparator));
        }
      }
    }
    
    protected native T computeNext();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */