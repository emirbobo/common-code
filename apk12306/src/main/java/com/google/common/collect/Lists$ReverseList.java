package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Lists$ReverseList<T>
  extends AbstractList<T>
{
  private final List<T> forwardList;
  
  static
  {
    JniLib.a(ReverseList.class, 580);
  }
  
  Lists$ReverseList(List<T> paramList)
  {
    this.forwardList = ((List)Preconditions.checkNotNull(paramList));
  }
  
  private native int reverseIndex(int paramInt);
  
  private native int reversePosition(int paramInt);
  
  public native void add(int paramInt, @Nullable T paramT);
  
  public native void clear();
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native T get(int paramInt);
  
  native List<T> getForwardList();
  
  public native int indexOf(@Nullable Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<T> iterator();
  
  public native int lastIndexOf(@Nullable Object paramObject);
  
  public native ListIterator<T> listIterator(int paramInt);
  
  public native T remove(int paramInt);
  
  protected native void removeRange(int paramInt1, int paramInt2);
  
  public native T set(int paramInt, @Nullable T paramT);
  
  public native int size();
  
  public native List<T> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$ReverseList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */