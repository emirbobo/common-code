package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class CustomConcurrentHashMap$EntrySet
  extends AbstractSet<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(EntrySet.class, 399);
  }
  
  CustomConcurrentHashMap$EntrySet(CustomConcurrentHashMap paramCustomConcurrentHashMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */