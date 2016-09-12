package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue<E>
  extends ForwardingCollection<E>
  implements Queue<E>
{
  protected abstract Queue<E> delegate();
  
  public E element()
  {
    return (E)delegate().element();
  }
  
  public boolean offer(E paramE)
  {
    return delegate().offer(paramE);
  }
  
  public E peek()
  {
    return (E)delegate().peek();
  }
  
  public E poll()
  {
    return (E)delegate().poll();
  }
  
  public E remove()
  {
    return (E)delegate().remove();
  }
  
  @Beta
  protected boolean standardOffer(E paramE)
  {
    try
    {
      bool = add(paramE);
      return bool;
    }
    catch (IllegalStateException paramE)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  @Beta
  protected E standardPeek()
  {
    try
    {
      Object localObject1 = element();
      return (E)localObject1;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  @Beta
  protected E standardPoll()
  {
    try
    {
      Object localObject1 = remove();
      return (E)localObject1;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ForwardingQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */