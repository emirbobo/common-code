package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class AbstractLinkedIterator<T>
  extends UnmodifiableIterator<T>
{
  private T nextOrNull;
  
  protected AbstractLinkedIterator(@Nullable T paramT)
  {
    this.nextOrNull = paramT;
  }
  
  protected abstract T computeNext(T paramT);
  
  public final boolean hasNext()
  {
    if (this.nextOrNull != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    try
    {
      Object localObject1 = this.nextOrNull;
      return (T)localObject1;
    }
    finally
    {
      this.nextOrNull = computeNext(this.nextOrNull);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractLinkedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */