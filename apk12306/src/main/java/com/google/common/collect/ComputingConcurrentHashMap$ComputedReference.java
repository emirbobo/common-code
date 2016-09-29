package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

class ComputingConcurrentHashMap$ComputedReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final V value;
  
  static
  {
    JniLib.a(ComputedReference.class, 377);
  }
  
  ComputingConcurrentHashMap$ComputedReference(@Nullable V paramV)
  {
    this.value = paramV;
  }
  
  public native void clear();
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native V get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native V waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$ComputedReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */