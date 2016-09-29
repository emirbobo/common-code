package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class RegularImmutableList$1
  extends AbstractIndexedListIterator<E>
{
  static
  {
    JniLib.a(1.class, 703);
  }
  
  RegularImmutableList$1(RegularImmutableList paramRegularImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected native E get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */