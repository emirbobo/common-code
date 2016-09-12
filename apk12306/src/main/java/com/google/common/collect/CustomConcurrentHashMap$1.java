package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class CustomConcurrentHashMap$1
  implements CustomConcurrentHashMap.ValueReference<Object, Object>
{
  static
  {
    JniLib.a(1.class, 396);
  }
  
  public native void clear();
  
  public native CustomConcurrentHashMap.ValueReference<Object, Object> copyFor(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry);
  
  public native Object get();
  
  public native boolean isComputingReference();
  
  public native void notifyValueReclaimed();
  
  public native Object waitForValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */