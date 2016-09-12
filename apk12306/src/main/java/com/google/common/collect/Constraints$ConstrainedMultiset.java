package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Collection;

class Constraints$ConstrainedMultiset<E>
  extends ForwardingMultiset<E>
{
  private final Constraint<? super E> constraint;
  private Multiset<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedMultiset.class, 392);
  }
  
  public Constraints$ConstrainedMultiset(Multiset<E> paramMultiset, Constraint<? super E> paramConstraint)
  {
    this.delegate = ((Multiset)Preconditions.checkNotNull(paramMultiset));
    this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
  }
  
  public native int add(E paramE, int paramInt);
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native Multiset<E> delegate();
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */