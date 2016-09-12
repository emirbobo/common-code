package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableSet$TransformedImmutableSet$1
  extends AbstractIndexedListIterator<E>
{
  static
  {
    JniLib.a(1.class, 489);
  }
  
  ImmutableSet$TransformedImmutableSet$1(ImmutableSet.TransformedImmutableSet paramTransformedImmutableSet, int paramInt)
  {
    super(paramInt);
  }
  
  protected native E get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSet$TransformedImmutableSet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */