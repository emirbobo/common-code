package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableWeakReference;
import java.util.concurrent.ConcurrentMap;

class Interners$WeakInterner<E>
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Interners$WeakInterner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */