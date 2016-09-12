package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;

class LinkedListMultimap$MultisetView$2
  extends AbstractSet<Multiset.Entry<K>>
{
  static
  {
    JniLib.a(2.class, 568);
  }
  
  LinkedListMultimap$MultisetView$2(LinkedListMultimap.MultisetView paramMultisetView) {}
  
  public native Iterator<Multiset.Entry<K>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$MultisetView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */