package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSet<E>
  extends ForwardingCollection<E>
  implements Set<E>
{
  protected abstract Set<E> delegate();
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject == this) || (delegate().equals(paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  @Beta
  protected boolean standardEquals(@Nullable Object paramObject)
  {
    return Sets.equalsImpl(this, paramObject);
  }
  
  @Beta
  protected int standardHashCode()
  {
    return Sets.hashCodeImpl(this);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ForwardingSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */