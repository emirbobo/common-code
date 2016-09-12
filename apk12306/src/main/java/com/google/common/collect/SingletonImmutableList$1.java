package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class SingletonImmutableList$1
  extends UnmodifiableListIterator<E>
{
  boolean hasNext;
  
  static
  {
    JniLib.a(1.class, 732);
  }
  
  SingletonImmutableList$1(SingletonImmutableList paramSingletonImmutableList, int paramInt)
  {
    if (this.val$start == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasNext = bool;
      return;
    }
  }
  
  public native boolean hasNext();
  
  public native boolean hasPrevious();
  
  public native E next();
  
  public native int nextIndex();
  
  public native E previous();
  
  public native int previousIndex();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SingletonImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */