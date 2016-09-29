package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractQueue;
import java.util.Iterator;

final class CustomConcurrentHashMap$2
  extends AbstractQueue<CustomConcurrentHashMap.ReferenceEntry<?, ?>>
{
  static
  {
    JniLib.a(2.class, 397);
  }
  
  public native Iterator<CustomConcurrentHashMap.ReferenceEntry<?, ?>> iterator();
  
  public native boolean offer(CustomConcurrentHashMap.ReferenceEntry<?, ?> paramReferenceEntry);
  
  public native CustomConcurrentHashMap.ReferenceEntry<?, ?> peek();
  
  public native CustomConcurrentHashMap.ReferenceEntry<?, ?> poll();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */