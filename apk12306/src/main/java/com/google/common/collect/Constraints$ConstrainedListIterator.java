package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.ListIterator;

class Constraints$ConstrainedListIterator<E>
  extends ForwardingListIterator<E>
{
  private final Constraint<? super E> constraint;
  private final ListIterator<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedListIterator.class, 391);
  }
  
  public Constraints$ConstrainedListIterator(ListIterator<E> paramListIterator, Constraint<? super E> paramConstraint)
  {
    this.delegate = paramListIterator;
    this.constraint = paramConstraint;
  }
  
  public native void add(E paramE);
  
  protected native ListIterator<E> delegate();
  
  public native void set(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */