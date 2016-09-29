package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableSortedMap$4
  extends UnmodifiableIterator<V>
{
  static
  {
    JniLib.a(4.class, 497);
  }
  
  ImmutableSortedMap$4(ImmutableSortedMap paramImmutableSortedMap, UnmodifiableIterator paramUnmodifiableIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */