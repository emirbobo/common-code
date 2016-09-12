package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.FinalizableWeakReference;

class CustomConcurrentHashMap$WeakValueReference<K, V>
  extends FinalizableWeakReference<V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final CustomConcurrentHashMap.ReferenceEntry<K, V> entry;
  
  static
  {
    JniLib.a(WeakValueReference.class, 426);
  }
  
  CustomConcurrentHashMap$WeakValueReference(V paramV, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramV, CustomConcurrentHashMap.QueueHolder.queue);
    this.entry = paramReferenceEntry;
  }
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void finalizeReferent();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native V waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$WeakValueReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */