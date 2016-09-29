package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$FilteredSet<E>
  extends Collections2.FilteredCollection<E>
  implements Set<E>
{
  static
  {
    JniLib.a(FilteredSet.class, 723);
  }
  
  Sets$FilteredSet(Set<E> paramSet, Predicate<? super E> paramPredicate)
  {
    super(paramSet, paramPredicate);
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$FilteredSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */