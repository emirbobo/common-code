package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class ReverseNaturalOrdering
  extends Ordering<Comparable>
  implements Serializable
{
  static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(ReverseNaturalOrdering.class, 713);
  }
  
  private native Object readResolve();
  
  public native int compare(Comparable paramComparable1, Comparable paramComparable2);
  
  public native <E extends Comparable> E max(E paramE1, E paramE2);
  
  public <E extends Comparable> E max(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.min(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public native <E extends Comparable> E max(Iterable<E> paramIterable);
  
  public native <E extends Comparable> E min(E paramE1, E paramE2);
  
  public <E extends Comparable> E min(E paramE1, E paramE2, E paramE3, E... paramVarArgs)
  {
    return (Comparable)NaturalOrdering.INSTANCE.max(paramE1, paramE2, paramE3, paramVarArgs);
  }
  
  public native <E extends Comparable> E min(Iterable<E> paramIterable);
  
  public native <S extends Comparable> Ordering<S> reverse();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ReverseNaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */