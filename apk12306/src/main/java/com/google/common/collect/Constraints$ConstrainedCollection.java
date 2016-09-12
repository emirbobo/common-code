package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Collection;

class Constraints$ConstrainedCollection<E>
  extends ForwardingCollection<E>
{
  private final Constraint<? super E> constraint;
  private final Collection<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedCollection.class, 389);
  }
  
  public Constraints$ConstrainedCollection(Collection<E> paramCollection, Constraint<? super E> paramConstraint)
  {
    this.delegate = ((Collection)Preconditions.checkNotNull(paramCollection));
    this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native Collection<E> delegate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */