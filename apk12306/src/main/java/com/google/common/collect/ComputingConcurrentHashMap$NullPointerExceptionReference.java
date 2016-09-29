package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ComputingConcurrentHashMap$NullPointerExceptionReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final String message;
  
  static
  {
    JniLib.a(NullPointerExceptionReference.class, 382);
  }
  
  ComputingConcurrentHashMap$NullPointerExceptionReference(String paramString)
  {
    this.message = paramString;
  }
  
  public native void clear();
  
  public native CustomConcurrentHashMap.ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native V get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native V waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$NullPointerExceptionReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */