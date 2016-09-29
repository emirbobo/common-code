package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ComputingConcurrentHashMap$ComputationExceptionReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final Throwable t;
  
  static
  {
    JniLib.a(ComputationExceptionReference.class, 376);
  }
  
  ComputingConcurrentHashMap$ComputationExceptionReference(Throwable paramThrowable)
  {
    this.t = paramThrowable;
  }
  
  public native void clear();
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native V get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native V waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$ComputationExceptionReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */