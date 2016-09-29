package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class RegularImmutableMap$Values$1
  extends AbstractIndexedListIterator<V>
{
  static
  {
    JniLib.a(1.class, 708);
  }
  
  RegularImmutableMap$Values$1(RegularImmutableMap.Values paramValues, int paramInt)
  {
    super(paramInt);
  }
  
  protected native V get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$Values$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */