package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSet<E>
  extends ForwardingSet<E>
  implements SortedSet<E>
{
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null) {}
    for (int i = ((Comparable)paramObject1).compareTo(paramObject2);; i = localComparator.compare(paramObject1, paramObject2)) {
      return i;
    }
  }
  
  public Comparator<? super E> comparator()
  {
    return delegate().comparator();
  }
  
  protected abstract SortedSet<E> delegate();
  
  public E first()
  {
    return (E)delegate().first();
  }
  
  public SortedSet<E> headSet(E paramE)
  {
    return delegate().headSet(paramE);
  }
  
  public E last()
  {
    return (E)delegate().last();
  }
  
  @Beta
  protected boolean standardContains(@Nullable Object paramObject)
  {
    boolean bool = false;
    try
    {
      int i = unsafeCompare(tailSet(paramObject).first(), paramObject);
      if (i == 0) {
        bool = true;
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;) {}
    }
    catch (NoSuchElementException paramObject)
    {
      for (;;) {}
    }
    catch (NullPointerException paramObject)
    {
      for (;;) {}
    }
    return bool;
  }
  
  @Beta
  protected boolean standardRemove(@Nullable Object paramObject)
  {
    bool2 = false;
    try
    {
      Iterator localIterator = tailSet(paramObject).iterator();
      bool1 = bool2;
      if (localIterator.hasNext())
      {
        bool1 = bool2;
        if (unsafeCompare(localIterator.next(), paramObject) == 0)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    catch (NullPointerException paramObject)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    return bool1;
  }
  
  @Beta
  protected SortedSet<E> standardSubSet(E paramE1, E paramE2)
  {
    return tailSet(paramE1).headSet(paramE2);
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2)
  {
    return delegate().subSet(paramE1, paramE2);
  }
  
  public SortedSet<E> tailSet(E paramE)
  {
    return delegate().tailSet(paramE);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ForwardingSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */