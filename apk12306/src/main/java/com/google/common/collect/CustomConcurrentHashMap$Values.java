package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Iterator;

final class CustomConcurrentHashMap$Values
  extends AbstractCollection<V>
{
  static
  {
    JniLib.a(Values.class, 421);
  }
  
  CustomConcurrentHashMap$Values(CustomConcurrentHashMap paramCustomConcurrentHashMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */