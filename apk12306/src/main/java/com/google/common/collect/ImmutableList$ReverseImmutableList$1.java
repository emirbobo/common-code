package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableList$ReverseImmutableList$1
  extends UnmodifiableListIterator<E>
{
  static
  {
    JniLib.a(1.class, 472);
  }
  
  ImmutableList$ReverseImmutableList$1(ImmutableList.ReverseImmutableList paramReverseImmutableList, UnmodifiableListIterator paramUnmodifiableListIterator) {}
  
  public native boolean hasNext();
  
  public native boolean hasPrevious();
  
  public native E next();
  
  public native int nextIndex();
  
  public native E previous();
  
  public native int previousIndex();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableList$ReverseImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */