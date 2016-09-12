package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableCollection$ArrayImmutableCollection<E>
  extends ImmutableCollection<E>
{
  private final E[] elements;
  
  static
  {
    JniLib.a(ArrayImmutableCollection.class, 465);
  }
  
  ImmutableCollection$ArrayImmutableCollection(E[] paramArrayOfE)
  {
    this.elements = paramArrayOfE;
  }
  
  native ImmutableList<E> createAsList();
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableCollection$ArrayImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */