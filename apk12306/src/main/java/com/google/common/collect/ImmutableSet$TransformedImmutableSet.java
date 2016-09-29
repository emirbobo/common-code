package com.google.common.collect;

import com.bangcle.andjni.JniLib;

abstract class ImmutableSet$TransformedImmutableSet<D, E>
  extends ImmutableSet<E>
{
  final int hashCode;
  final D[] source;
  
  ImmutableSet$TransformedImmutableSet(D[] paramArrayOfD, int paramInt)
  {
    this.source = paramArrayOfD;
    this.hashCode = paramInt;
  }
  
  public final int hashCode()
  {
    return this.hashCode;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    new AbstractIndexedListIterator(this.source.length)
    {
      static
      {
        JniLib.a(1.class, 489);
      }
      
      protected native E get(int paramAnonymousInt);
    };
  }
  
  public int size()
  {
    return this.source.length;
  }
  
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
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
      for (i = 0; i < this.source.length; i++) {
        localObject[i] = transform(this.source[i]);
      }
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
    return (T[])localObject;
  }
  
  abstract E transform(D paramD);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSet$TransformedImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */