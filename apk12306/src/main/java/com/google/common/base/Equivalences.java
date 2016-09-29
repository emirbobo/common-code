package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class Equivalences
{
  static
  {
    JniLib.a(Equivalences.class, 278);
  }
  
  public static native Equivalence<Object> equals();
  
  public static native Equivalence<Object> identity();
  
  @GwtCompatible(serializable=true)
  public static native <T> Equivalence<Iterable<T>> pairwise(Equivalence<? super T> paramEquivalence);
  
  private static abstract enum Impl
    implements Equivalence<Object>
  {
    EQUALS,  IDENTITY;
    
    private Impl() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Equivalences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */