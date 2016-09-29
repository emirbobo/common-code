package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

class LinkedListMultimap$2
  extends AbstractSet<K>
{
  static
  {
    JniLib.a(2.class, 554);
  }
  
  LinkedListMultimap$2(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<K> iterator();
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */