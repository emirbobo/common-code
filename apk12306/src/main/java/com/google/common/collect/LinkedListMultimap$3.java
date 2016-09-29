package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Iterator;

class LinkedListMultimap$3
  extends AbstractCollection<V>
{
  static
  {
    JniLib.a(3.class, 556);
  }
  
  LinkedListMultimap$3(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native Iterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */