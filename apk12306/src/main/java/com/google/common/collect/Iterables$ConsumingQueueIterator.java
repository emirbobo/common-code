package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Queue;

class Iterables$ConsumingQueueIterator<T>
  extends AbstractIterator<T>
{
  private final Queue<T> queue;
  
  static
  {
    JniLib.a(ConsumingQueueIterator.class, 528);
  }
  
  private Iterables$ConsumingQueueIterator(Queue<T> paramQueue)
  {
    this.queue = paramQueue;
  }
  
  public native T computeNext();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$ConsumingQueueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */