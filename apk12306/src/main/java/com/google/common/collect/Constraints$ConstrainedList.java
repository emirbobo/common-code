package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
class Constraints$ConstrainedList<E>
  extends ForwardingList<E>
{
  final Constraint<? super E> constraint;
  final List<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedList.class, 390);
  }
  
  Constraints$ConstrainedList(List<E> paramList, Constraint<? super E> paramConstraint)
  {
    this.delegate = ((List)Preconditions.checkNotNull(paramList));
    this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
  }
  
  public native void add(int paramInt, E paramE);
  
  public native boolean add(E paramE);
  
  public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native List<E> delegate();
  
  public native ListIterator<E> listIterator();
  
  public native ListIterator<E> listIterator(int paramInt);
  
  public native E set(int paramInt, E paramE);
  
  public native List<E> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */