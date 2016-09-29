package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class PriorityObjectBlockingQueue$Itr
  implements Iterator<E>
{
  private Node<E> current;
  private E currentElement;
  private Node<E> lastRet;
  
  static
  {
    JniLib.a(Itr.class, 1017);
  }
  
  PriorityObjectBlockingQueue$Itr(PriorityObjectBlockingQueue paramPriorityObjectBlockingQueue)
  {
    paramPriorityObjectBlockingQueue.fullyLock();
    try
    {
      this.current = paramPriorityObjectBlockingQueue.head.next;
      if (this.current != null) {
        this.currentElement = this.current.getValue();
      }
      return;
    }
    finally
    {
      paramPriorityObjectBlockingQueue.fullyUnlock();
    }
  }
  
  private native Node<E> nextNode(Node<E> paramNode);
  
  public native boolean hasNext();
  
  public native E next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityObjectBlockingQueue$Itr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */