package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;

@GwtCompatible(serializable=true)
final class NaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final NaturalOrdering INSTANCE = new NaturalOrdering();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(NaturalOrdering.class, 695);
  }
  
  private native Object readResolve();
  
  public native int binarySearch(List<? extends Comparable> paramList, Comparable paramComparable);
  
  public native int compare(Comparable paramComparable1, Comparable paramComparable2);
  
  public native <S extends Comparable> Ordering<S> reverse();
  
  public native <E extends Comparable> List<E> sortedCopy(Iterable<E> paramIterable);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\NaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */