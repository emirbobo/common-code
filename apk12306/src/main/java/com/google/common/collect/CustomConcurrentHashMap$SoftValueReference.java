package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.FinalizableSoftReference;

class CustomConcurrentHashMap$SoftValueReference<K, V>
  extends FinalizableSoftReference<V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final CustomConcurrentHashMap.ReferenceEntry<K, V> entry;
  
  static
  {
    JniLib.a(SoftValueReference.class, 414);
  }
  
  CustomConcurrentHashMap$SoftValueReference(V paramV, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$SoftValueReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */