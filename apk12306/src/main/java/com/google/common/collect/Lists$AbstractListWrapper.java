package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

class Lists$AbstractListWrapper<E>
  extends AbstractList<E>
{
  final List<E> backingList;
  
  static
  {
    JniLib.a(AbstractListWrapper.class, 574);
  }
  
  Lists$AbstractListWrapper(List<E> paramList)
  {
    this.backingList = ((List)Preconditions.checkNotNull(paramList));
  }
  
  public native void add(int paramInt, E paramE);
  
  public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
  
  public native boolean contains(Object paramObject);
  
  public native E get(int paramInt);
  
  public native E remove(int paramInt);
  
  public native E set(int paramInt, E paramE);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$AbstractListWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */