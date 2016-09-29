package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Iterators$11
  extends AbstractIndexedListIterator<T>
{
  static
  {
    JniLib.a(11.class, 531);
  }
  
  Iterators$11(int paramInt, Object[] paramArrayOfObject)
  {
    super(paramInt);
  }
  
  protected native T get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */