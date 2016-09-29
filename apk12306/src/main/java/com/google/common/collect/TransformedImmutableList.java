package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
abstract class TransformedImmutableList<D, E>
  extends ImmutableList<E>
{
  private final transient ImmutableList<D> backingList;
  
  TransformedImmutableList(ImmutableList<D> paramImmutableList)
  {
    this.backingList = ((ImmutableList)Preconditions.checkNotNull(paramImmutableList));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if ((size() != ((List)paramObject).size()) || (!Iterators.elementsEqual(iterator(), ((List)paramObject).iterator()))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public E get(int paramInt)
  {
    return (E)transform(this.backingList.get(paramInt));
  }
  
  public int hashCode()
  {
    int i = 1;
    Iterator localIterator = iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null) {}
      for (int j = 0;; j = localObject.hashCode())
      {
        i = i * 31 + j;
        break;
      }
    }
    return i;
  }
  
  public int indexOf(@Nullable Object paramObject)
  {
    int j;
    if (paramObject == null) {
      j = -1;
    }
    for (;;)
    {
      return j;
      for (int i = 0;; i++)
      {
        if (i >= size()) {
          break label38;
        }
        j = i;
        if (get(i).equals(paramObject)) {
          break;
        }
      }
      label38:
      j = -1;
    }
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int lastIndexOf(@Nullable Object paramObject)
  {
    int j;
    if (paramObject == null) {
      j = -1;
    }
    for (;;)
    {
      return j;
      for (int i = size() - 1;; i--)
      {
        if (i < 0) {
          break label39;
        }
        j = i;
        if (get(i).equals(paramObject)) {
          break;
        }
      }
      label39:
      j = -1;
    }
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    new AbstractIndexedListIterator(size(), paramInt)
    {
      static
      {
        JniLib.a(1.class, 802);
      }
      
      protected native E get(int paramAnonymousInt);
    };
  }
  
  public int size()
  {
    return this.backingList.size();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    return new TransformedView(this.backingList.subList(paramInt1, paramInt2));
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.toArrayImpl(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfT);
  }
  
  abstract E transform(D paramD);
  
  private class TransformedView
    extends TransformedImmutableList<D, E>
  {
    static
    {
      JniLib.a(TransformedView.class, 803);
    }
    
    TransformedView()
    {
      super();
    }
    
    native E transform(D paramD);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TransformedImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */