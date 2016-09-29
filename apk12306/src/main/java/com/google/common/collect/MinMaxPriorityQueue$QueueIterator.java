package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

class MinMaxPriorityQueue$QueueIterator
  implements Iterator<E>
{
  private boolean canRemove;
  private int cursor = -1;
  private int expectedModCount = MinMaxPriorityQueue.access$700(this.this$0);
  private Queue<E> forgetMeNot;
  private E lastFromForgetMeNot;
  private List<E> skipMe;
  
  static
  {
    JniLib.a(QueueIterator.class, 645);
  }
  
  private MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue paramMinMaxPriorityQueue) {}
  
  private native boolean containsExact(Iterable<E> paramIterable, E paramE);
  
  private native int nextNotInSkipMe(int paramInt);
  
  native void checkModCount();
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
  
  native boolean removeExact(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MinMaxPriorityQueue$QueueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */