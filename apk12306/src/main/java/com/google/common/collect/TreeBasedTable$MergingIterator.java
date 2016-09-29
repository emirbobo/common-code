package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class TreeBasedTable$MergingIterator<T>
  extends AbstractIterator<T>
{
  private final Comparator<? super T> comparator;
  private T lastValue = null;
  private final Queue<PeekingIterator<T>> queue;
  
  static
  {
    JniLib.a(MergingIterator.class, 807);
  }
  
  public TreeBasedTable$MergingIterator(Iterable<? extends Iterator<T>> paramIterable, Comparator<? super T> paramComparator)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeBasedTable$MergingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */