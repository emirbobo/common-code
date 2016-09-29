package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityObjectBlockingQueue<E>
  extends AbstractQueue<E>
  implements BlockingQueue<E>, Serializable
{
  private static final long serialVersionUID = -6903933977591709194L;
  private final int capacity;
  private final AtomicInteger count = new AtomicInteger();
  transient Node<E> head;
  private transient Node<E> last;
  private final Condition notEmpty = this.takeLock.newCondition();
  private final Condition notFull = this.putLock.newCondition();
  private final ReentrantLock putLock = new ReentrantLock();
  private final ReentrantLock takeLock = new ReentrantLock();
  
  static
  {
    JniLib.a(PriorityObjectBlockingQueue.class, 1018);
  }
  
  public PriorityObjectBlockingQueue()
  {
    this(Integer.MAX_VALUE);
  }
  
  public PriorityObjectBlockingQueue(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
    Node localNode = new Node(null);
    this.head = localNode;
    this.last = localNode;
  }
  
  public PriorityObjectBlockingQueue(Collection<? extends E> paramCollection)
  {
    this(Integer.MAX_VALUE);
    ReentrantLock localReentrantLock = this.putLock;
    localReentrantLock.lock();
    for (int i = 0;; i++)
    {
      Object localObject;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext())
        {
          this.count.set(i);
          return;
        }
        localObject = (Object)paramCollection.next();
        if (localObject == null)
        {
          paramCollection = new java/lang/NullPointerException;
          paramCollection.<init>();
          throw paramCollection;
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (i == this.capacity)
      {
        paramCollection = new java/lang/IllegalStateException;
        paramCollection.<init>("Queue full");
        throw paramCollection;
      }
      Node localNode = new com/lidroid/xutils/task/Node;
      localNode.<init>(localObject);
      opQueue(localNode);
    }
  }
  
  private native E _dequeue();
  
  private native void _enqueue(Node<E> paramNode);
  
  private native E opQueue(Node<E> paramNode);
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  private native void signalNotEmpty();
  
  private native void signalNotFull();
  
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native int drainTo(Collection<? super E> paramCollection);
  
  public native int drainTo(Collection<? super E> paramCollection, int paramInt);
  
  native void fullyLock();
  
  native void fullyUnlock();
  
  public native Iterator<E> iterator();
  
  public native boolean offer(E paramE);
  
  public native boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public native E peek();
  
  public native E poll();
  
  public native E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public native void put(E paramE)
    throws InterruptedException;
  
  public native int remainingCapacity();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
  
  public native E take()
    throws InterruptedException;
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  native void unlink(Node<E> paramNode1, Node<E> paramNode2);
  
  private class Itr
    implements Iterator<E>
  {
    private Node<E> current;
    private E currentElement;
    private Node<E> lastRet;
    
    static
    {
      JniLib.a(Itr.class, 1017);
    }
    
    Itr()
    {
      PriorityObjectBlockingQueue.this.fullyLock();
      try
      {
        this.current = PriorityObjectBlockingQueue.this.head.next;
        if (this.current != null) {
          this.currentElement = this.current.getValue();
        }
        return;
      }
      finally
      {
        PriorityObjectBlockingQueue.this.fullyUnlock();
      }
    }
    
    private native Node<E> nextNode(Node<E> paramNode);
    
    public native boolean hasNext();
    
    public native E next();
    
    public native void remove();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityObjectBlockingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */