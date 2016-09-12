package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ExplicitOrdering<T>
  extends Ordering<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableMap<T, Integer> rankMap;
  
  static
  {
    JniLib.a(ExplicitOrdering.class, 447);
  }
  
  ExplicitOrdering(ImmutableMap<T, Integer> paramImmutableMap)
  {
    this.rankMap = paramImmutableMap;
  }
  
  ExplicitOrdering(List<T> paramList)
  {
    this(buildRankMap(paramList));
  }
  
  private static native <T> ImmutableMap<T, Integer> buildRankMap(List<T> paramList);
  
  private native int rank(T paramT);
  
  public native int compare(T paramT1, T paramT2);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ExplicitOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */