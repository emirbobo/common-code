package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract interface Equivalence<T>
{
  public abstract boolean equivalent(@Nullable T paramT1, @Nullable T paramT2);
  
  public abstract int hash(@Nullable T paramT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Equivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */