package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;

class Constraints$ConstrainedSet<E>
  extends ForwardingSet<E>
{
  private final Constraint<? super E> constraint;
  private final Set<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedSet.class, 393);
  }
  
  public Constraints$ConstrainedSet(Set<E> paramSet, Constraint<? super E> paramConstraint)
  {
    this.delegate = ((Set)Preconditions.checkNotNull(paramSet));
    this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native Set<E> delegate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */