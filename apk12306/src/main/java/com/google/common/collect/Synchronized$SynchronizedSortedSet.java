package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSet<E>
  extends Synchronized.SynchronizedSet<E>
  implements SortedSet<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedSortedSet.class, 794);
  }
  
  Synchronized$SynchronizedSortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject)
  {
    super(paramSortedSet, paramObject);
  }
  
  public native Comparator<? super E> comparator();
  
  native SortedSet<E> delegate();
  
  public native E first();
  
  public native SortedSet<E> headSet(E paramE);
  
  public native E last();
  
  public native SortedSet<E> subSet(E paramE1, E paramE2);
  
  public native SortedSet<E> tailSet(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */