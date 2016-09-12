package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

public final class ImmutableMultiset$Builder<E>
  extends ImmutableCollection.Builder<E>
{
  private final Multiset<E> contents = LinkedHashMultiset.create();
  
  static
  {
    JniLib.a(Builder.class, 484);
  }
  
  public native Builder<E> add(E paramE);
  
  public Builder<E> add(E... paramVarArgs)
  {
    super.add(paramVarArgs);
    return this;
  }
  
  public native Builder<E> addAll(Iterable<? extends E> paramIterable);
  
  public native Builder<E> addAll(Iterator<? extends E> paramIterator);
  
  public native Builder<E> addCopies(E paramE, int paramInt);
  
  public native ImmutableMultiset<E> build();
  
  public native Builder<E> setCount(E paramE, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultiset$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */