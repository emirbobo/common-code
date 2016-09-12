package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class TransformedImmutableList$1
  extends AbstractIndexedListIterator<E>
{
  static
  {
    JniLib.a(1.class, 802);
  }
  
  TransformedImmutableList$1(TransformedImmutableList paramTransformedImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected native E get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TransformedImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */