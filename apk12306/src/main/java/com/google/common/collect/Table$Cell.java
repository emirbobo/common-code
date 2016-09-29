package com.google.common.collect;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public abstract interface Table$Cell<R, C, V>
{
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract C getColumnKey();
  
  public abstract R getRowKey();
  
  public abstract V getValue();
  
  public abstract int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Table$Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */