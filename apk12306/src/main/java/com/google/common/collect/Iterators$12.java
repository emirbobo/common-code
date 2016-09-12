package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Iterators$12
  extends AbstractIndexedListIterator<T>
{
  static
  {
    JniLib.a(12.class, 532);
  }
  
  Iterators$12(int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    super(paramInt1);
  }
  
  protected native T get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */