package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder<E>
  extends ImmutableSet.Builder<E>
{
  private final Comparator<? super E> comparator;
  
  static
  {
    JniLib.a(Builder.class, 505);
  }
  
  public ImmutableSortedSet$Builder(Comparator<? super E> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public native Builder<E> add(E paramE);
  
  public Builder<E> add(E... paramVarArgs)
  {
    super.add(paramVarArgs);
    return this;
  }
  
  public native Builder<E> addAll(Iterable<? extends E> paramIterable);
  
  public native Builder<E> addAll(Iterator<? extends E> paramIterator);
  
  public native ImmutableSortedSet<E> build();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedSet$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */