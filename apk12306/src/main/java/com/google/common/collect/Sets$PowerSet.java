package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$PowerSet<E>
  extends AbstractSet<Set<E>>
{
  final ImmutableList<E> inputList;
  final ImmutableSet<E> inputSet;
  final int powerSetSize;
  
  static
  {
    JniLib.a(PowerSet.class, 728);
  }
  
  Sets$PowerSet(ImmutableSet<E> paramImmutableSet)
  {
    this.inputSet = paramImmutableSet;
    this.inputList = paramImmutableSet.asList();
    this.powerSetSize = (1 << paramImmutableSet.size());
  }
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Iterator<Set<E>> iterator();
  
  public native int size();
  
  public native String toString();
  
  private static final class BitFilteredSetIterator<E>
    extends UnmodifiableIterator<E>
  {
    final ImmutableList<E> input;
    int remainingSetBits;
    
    static
    {
      JniLib.a(BitFilteredSetIterator.class, 727);
    }
    
    BitFilteredSetIterator(ImmutableList<E> paramImmutableList, int paramInt)
    {
      this.input = paramImmutableList;
      this.remainingSetBits = paramInt;
    }
    
    public native boolean hasNext();
    
    public native E next();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$PowerSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */