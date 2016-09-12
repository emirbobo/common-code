package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

@Beta
public final class MinMaxPriorityQueue<E>
  extends AbstractQueue<E>
{
  private static final int DEFAULT_CAPACITY = 11;
  private static final int EVEN_POWERS_OF_TWO = 1431655765;
  private static final int ODD_POWERS_OF_TWO = -1431655766;
  private final MinMaxPriorityQueue<E>.Heap maxHeap;
  @VisibleForTesting
  final int maximumSize;
  private final MinMaxPriorityQueue<E>.Heap minHeap;
  private int modCount;
  private Object[] queue;
  private int size;
  
  static
  {
    JniLib.a(MinMaxPriorityQueue.class, 646);
  }
  
  private MinMaxPriorityQueue(Builder<? super E> paramBuilder, int paramInt)
  {
    Ordering localOrdering = paramBuilder.ordering();
    this.minHeap = new Heap(localOrdering);
    this.maxHeap = new Heap(localOrdering.reverse());
    this.minHeap.otherHeap = this.maxHeap;
    this.maxHeap.otherHeap = this.minHeap;
    this.maximumSize = paramBuilder.maximumSize;
    this.queue = new Object[paramInt];
  }
  
  private native int calculateNewCapacity();
  
  private static native int capAtMaximumSize(int paramInt1, int paramInt2);
  
  public static native <E extends Comparable<E>> MinMaxPriorityQueue<E> create();
  
  public static native <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> paramIterable);
  
  public static native Builder<Comparable> expectedSize(int paramInt);
  
  private native MoveDesc<E> fillHole(int paramInt, E paramE);
  
  private native int getMaxElementIndex();
  
  private native void growIfNeeded();
  
  private native MinMaxPriorityQueue<E>.Heap heapForIndex(int paramInt);
  
  @VisibleForTesting
  static native int initialQueueSize(int paramInt1, int paramInt2, Iterable<?> paramIterable);
  
  @VisibleForTesting
  static native boolean isEvenLevel(int paramInt);
  
  public static native Builder<Comparable> maximumSize(int paramInt);
  
  public static native <B> Builder<B> orderedBy(Comparator<B> paramComparator);
  
  private native E removeAndGet(int paramInt);
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  @VisibleForTesting
  native int capacity();
  
  public native void clear();
  
  public native Comparator<? super E> comparator();
  
  native E elementData(int paramInt);
  
  @VisibleForTesting
  native boolean isIntact();
  
  public native Iterator<E> iterator();
  
  public native boolean offer(E paramE);
  
  public native E peek();
  
  public native E peekFirst();
  
  public native E peekLast();
  
  public native E poll();
  
  public native E pollFirst();
  
  public native E pollLast();
  
  @VisibleForTesting
  native MoveDesc<E> removeAt(int paramInt);
  
  public native E removeFirst();
  
  public native E removeLast();
  
  public native int size();
  
  public native Object[] toArray();
  
  @Beta
  public static final class Builder<B>
  {
    private static final int UNSET_EXPECTED_SIZE = -1;
    private final Comparator<B> comparator;
    private int expectedSize = -1;
    private int maximumSize = Integer.MAX_VALUE;
    
    static
    {
      JniLib.a(Builder.class, 643);
    }
    
    private Builder(Comparator<B> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    private native <T extends B> Ordering<T> ordering();
    
    public native <T extends B> MinMaxPriorityQueue<T> create();
    
    public native <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> paramIterable);
    
    public native Builder<B> expectedSize(int paramInt);
    
    public native Builder<B> maximumSize(int paramInt);
  }
  
  private class Heap
  {
    final Ordering<E> ordering;
    MinMaxPriorityQueue<E>.Heap otherHeap;
    
    static
    {
      JniLib.a(Heap.class, 644);
    }
    
    Heap()
    {
      Ordering localOrdering;
      this.ordering = localOrdering;
    }
    
    private native int getGrandparentIndex(int paramInt);
    
    private native int getLeftChildIndex(int paramInt);
    
    private native int getParentIndex(int paramInt);
    
    private native int getRightChildIndex(int paramInt);
    
    private native boolean verifyIndex(int paramInt);
    
    native void bubbleUp(int paramInt, E paramE);
    
    native int bubbleUpAlternatingLevels(int paramInt, E paramE);
    
    native int compareElements(int paramInt1, int paramInt2);
    
    native int crossOver(int paramInt, E paramE);
    
    native int crossOverUp(int paramInt, E paramE);
    
    native int fillHoleAt(int paramInt);
    
    native int findMin(int paramInt1, int paramInt2);
    
    native int findMinChild(int paramInt);
    
    native int findMinGrandChild(int paramInt);
    
    native int getCorrectLastElement(E paramE);
    
    native MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int paramInt1, int paramInt2, E paramE);
  }
  
  static class MoveDesc<E>
  {
    final E replaced;
    final E toTrickle;
    
    MoveDesc(E paramE1, E paramE2)
    {
      this.toTrickle = paramE1;
      this.replaced = paramE2;
    }
  }
  
  private class QueueIterator
    implements Iterator<E>
  {
    private boolean canRemove;
    private int cursor = -1;
    private int expectedModCount = MinMaxPriorityQueue.this.modCount;
    private Queue<E> forgetMeNot;
    private E lastFromForgetMeNot;
    private List<E> skipMe;
    
    static
    {
      JniLib.a(QueueIterator.class, 645);
    }
    
    private QueueIterator() {}
    
    private native boolean containsExact(Iterable<E> paramIterable, E paramE);
    
    private native int nextNotInSkipMe(int paramInt);
    
    native void checkModCount();
    
    public native boolean hasNext();
    
    public native E next();
    
    public native void remove();
    
    native boolean removeExact(Object paramObject);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MinMaxPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */