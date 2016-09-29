package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;
import java.util.ListIterator;

class AbstractMultimap$WrappedList$WrappedListIterator
  extends AbstractMultimap<K, V>.WrappedCollection.WrappedIterator
  implements ListIterator<V>
{
  static
  {
    JniLib.a(WrappedListIterator.class, 362);
  }
  
  AbstractMultimap$WrappedList$WrappedListIterator(AbstractMultimap.WrappedList paramWrappedList)
  {
    super(paramWrappedList);
  }
  
  public AbstractMultimap$WrappedList$WrappedListIterator(AbstractMultimap.WrappedList paramWrappedList, int paramInt)
  {
    super(paramWrappedList, paramWrappedList.getListDelegate().listIterator(paramInt));
  }
  
  private native ListIterator<V> getDelegateListIterator();
  
  public native void add(V paramV);
  
  public native boolean hasPrevious();
  
  public native int nextIndex();
  
  public native V previous();
  
  public native int previousIndex();
  
  public native void set(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedList$WrappedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */