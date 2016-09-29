package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableWeakReference;
import com.google.common.base.Function;
import java.util.concurrent.ConcurrentMap;

@Beta
public final class Interners
{
  static
  {
    JniLib.a(Interners.class, 512);
  }
  
  public static native <E> Function<E, E> asFunction(Interner<E> paramInterner);
  
  public static native <E> Interner<E> newStrongInterner();
  
  public static native <E> Interner<E> newWeakInterner();
  
  private static class InternerFunction<E>
    implements Function<E, E>
  {
    private final Interner<E> interner;
    
    static
    {
      JniLib.a(InternerFunction.class, 508);
    }
    
    public InternerFunction(Interner<E> paramInterner)
    {
      this.interner = paramInterner;
    }
    
    public native E apply(E paramE);
    
    public native boolean equals(Object paramObject);
    
    public native int hashCode();
  }
  
  private static class WeakInterner<E>
    implements Interner<E>
  {
    private static final FinalizableReferenceQueue frq = new FinalizableReferenceQueue();
    private final ConcurrentMap<WeakInterner<E>.InternReference, WeakInterner<E>.InternReference> map = new MapMaker().makeMap();
    
    static
    {
      JniLib.a(WeakInterner.class, 511);
    }
    
    public native E intern(E paramE);
    
    class InternReference
      extends FinalizableWeakReference<E>
    {
      final int hashCode;
      
      static
      {
        JniLib.a(InternReference.class, 510);
      }
      
      InternReference(int paramInt)
      {
        super(Interners.WeakInterner.frq);
        int i;
        this.hashCode = i;
      }
      
      public native boolean equals(Object paramObject);
      
      public native void finalizeReferent();
      
      public native E get();
      
      public native int hashCode();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Interners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */