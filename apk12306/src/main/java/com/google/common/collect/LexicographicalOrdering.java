package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class LexicographicalOrdering<T>
  extends Ordering<Iterable<T>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Ordering<? super T> elementOrder;
  
  static
  {
    JniLib.a(LexicographicalOrdering.class, 547);
  }
  
  LexicographicalOrdering(Ordering<? super T> paramOrdering)
  {
    this.elementOrder = paramOrdering;
  }
  
  public native int compare(Iterable<T> paramIterable1, Iterable<T> paramIterable2);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LexicographicalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */