package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.FinalizableWeakReference;

class Interners$WeakInterner$InternReference
  extends FinalizableWeakReference<E>
{
  final int hashCode;
  
  static
  {
    JniLib.a(InternReference.class, 510);
  }
  
  Interners$WeakInterner$InternReference(E paramE, int paramInt)
  {
    super(paramInt, Interners.WeakInterner.access$100());
    int i;
    this.hashCode = i;
  }
  
  public native boolean equals(Object paramObject);
  
  public native void finalizeReferent();
  
  public native E get();
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Interners$WeakInterner$InternReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */