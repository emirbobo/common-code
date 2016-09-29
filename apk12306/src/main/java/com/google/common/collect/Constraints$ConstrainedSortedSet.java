package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.SortedSet;

class Constraints$ConstrainedSortedSet<E>
  extends ForwardingSortedSet<E>
{
  final Constraint<? super E> constraint;
  final SortedSet<E> delegate;
  
  static
  {
    JniLib.a(ConstrainedSortedSet.class, 394);
  }
  
  Constraints$ConstrainedSortedSet(SortedSet<E> paramSortedSet, Constraint<? super E> paramConstraint)
  {
    this.delegate = ((SortedSet)Preconditions.checkNotNull(paramSortedSet));
    this.constraint = ((Constraint)Preconditions.checkNotNull(paramConstraint));
  }
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  protected native SortedSet<E> delegate();
  
  public native SortedSet<E> headSet(E paramE);
  
  public native SortedSet<E> subSet(E paramE1, E paramE2);
  
  public native SortedSet<E> tailSet(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Constraints$ConstrainedSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */