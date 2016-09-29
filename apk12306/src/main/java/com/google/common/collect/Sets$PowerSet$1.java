package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class Sets$PowerSet$1
  extends AbstractIndexedListIterator<Set<E>>
{
  static
  {
    JniLib.a(1.class, 726);
  }
  
  Sets$PowerSet$1(Sets.PowerSet paramPowerSet, int paramInt)
  {
    super(paramInt);
  }
  
  protected native Set<E> get(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$PowerSet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */