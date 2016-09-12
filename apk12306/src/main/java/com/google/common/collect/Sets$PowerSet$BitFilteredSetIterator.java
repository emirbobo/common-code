package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Sets$PowerSet$BitFilteredSetIterator<E>
  extends UnmodifiableIterator<E>
{
  final ImmutableList<E> input;
  int remainingSetBits;
  
  static
  {
    JniLib.a(BitFilteredSetIterator.class, 727);
  }
  
  Sets$PowerSet$BitFilteredSetIterator(ImmutableList<E> paramImmutableList, int paramInt)
  {
    this.input = paramImmutableList;
    this.remainingSetBits = paramInt;
  }
  
  public native boolean hasNext();
  
  public native E next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$PowerSet$BitFilteredSetIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */