package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.concurrent.GuardedBy;

class ComputingConcurrentHashMap$ComputingValueReference
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  @GuardedBy("ComputingValueReference.this")
  CustomConcurrentHashMap.ValueReference<K, V> computedReference = CustomConcurrentHashMap.unset();
  
  static
  {
    JniLib.a(ComputingValueReference.class, 381);
  }
  
  private ComputingConcurrentHashMap$ComputingValueReference(ComputingConcurrentHashMap paramComputingConcurrentHashMap) {}
  
  public native void clear();
  
  native V compute(K paramK, int paramInt);
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native V get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  native void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
  
  public native V waitForValue()
    throws InterruptedException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$ComputingValueReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */