package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class CustomConcurrentHashMap$StrongValueReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final V referent;
  
  static
  {
    JniLib.a(StrongValueReference.class, 419);
  }
  
  CustomConcurrentHashMap$StrongValueReference(V paramV)
  {
    this.referent = paramV;
  }
  
  public native void clear();
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native V get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native V waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$StrongValueReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */