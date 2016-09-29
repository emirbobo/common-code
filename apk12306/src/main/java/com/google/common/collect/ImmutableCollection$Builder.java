package com.google.common.collect;

import java.util.Iterator;

abstract class ImmutableCollection$Builder<E>
{
  public abstract Builder<E> add(E paramE);
  
  public Builder<E> add(E... paramVarArgs)
  {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      add(paramVarArgs[i]);
    }
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add(paramIterable.next());
    }
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> paramIterator)
  {
    while (paramIterator.hasNext()) {
      add(paramIterator.next());
    }
    return this;
  }
  
  public abstract ImmutableCollection<E> build();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableCollection$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */