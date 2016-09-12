package com.google.common.collect;

import javax.annotation.Nullable;

public abstract interface MapDifference$ValueDifference<V>
{
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract V leftValue();
  
  public abstract V rightValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapDifference$ValueDifference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */