package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;

final class CustomConcurrentHashMap$KeySet
  extends AbstractSet<K>
{
  static
  {
    JniLib.a(KeySet.class, 401);
  }
  
  CustomConcurrentHashMap$KeySet(CustomConcurrentHashMap paramCustomConcurrentHashMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<K> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */