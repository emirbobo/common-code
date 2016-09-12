package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ListIterator;

class LinkedListMultimap$1
  extends AbstractSequentialList<V>
{
  static
  {
    JniLib.a(1.class, 553);
  }
  
  LinkedListMultimap$1(LinkedListMultimap paramLinkedListMultimap, Object paramObject) {}
  
  public native ListIterator<V> listIterator(int paramInt);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */