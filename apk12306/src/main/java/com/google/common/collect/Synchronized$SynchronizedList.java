package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedList<E>
  extends Synchronized.SynchronizedCollection<E>
  implements List<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedList.class, 788);
  }
  
  Synchronized$SynchronizedList(List<E> paramList, @Nullable Object paramObject)
  {
    super(paramList, paramObject, null);
  }
  
  public native void add(int paramInt, E paramE);
  
  public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
  
  native List<E> delegate();
  
  public native boolean equals(Object paramObject);
  
  public native E get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native int lastIndexOf(Object paramObject);
  
  public native ListIterator<E> listIterator();
  
  public native ListIterator<E> listIterator(int paramInt);
  
  public native E remove(int paramInt);
  
  public native E set(int paramInt, E paramE);
  
  public native List<E> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */