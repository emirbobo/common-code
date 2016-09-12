package com.google.common.collect;

import java.util.Collection;

abstract class ImmutableSet$ArrayImmutableSet<E>
  extends ImmutableSet<E>
{
  final transient Object[] elements;
  
  ImmutableSet$ArrayImmutableSet(Object[] paramArrayOfObject)
  {
    this.elements = paramArrayOfObject;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramCollection == this) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (!(paramCollection instanceof ArrayImmutableSet))
      {
        bool1 = super.containsAll(paramCollection);
      }
      else
      {
        if (paramCollection.size() <= size()) {
          break;
        }
        bool1 = false;
      }
    }
    paramCollection = ((ArrayImmutableSet)paramCollection).elements;
    int j = paramCollection.length;
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (!contains(paramCollection[i]))
      {
        bool1 = false;
        break;
      }
    }
  }
  
  ImmutableList<E> createAsList()
  {
    return new ImmutableAsList(this.elements, this);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.forArray(this.elements);
  }
  
  public int size()
  {
    return this.elements.length;
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    System.arraycopy(this.elements, 0, arrayOfObject, 0, size());
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i) {
      localObject = ObjectArrays.newArray(paramArrayOfT, i);
    }
    for (;;)
    {
      System.arraycopy(this.elements, 0, localObject, 0, i);
      return (T[])localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSet$ArrayImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */