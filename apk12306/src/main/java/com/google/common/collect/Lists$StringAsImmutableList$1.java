package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class Lists$StringAsImmutableList$1
  extends AbstractIndexedListIterator<Character>
{
  static
  {
    JniLib.a(1.class, 582);
  }
  
  Lists$StringAsImmutableList$1(Lists.StringAsImmutableList paramStringAsImmutableList, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected native Character get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$StringAsImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */