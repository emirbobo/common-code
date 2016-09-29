package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class CustomConcurrentHashMap$ValueIterator
  extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<V>
{
  static
  {
    JniLib.a(ValueIterator.class, 420);
  }
  
  CustomConcurrentHashMap$ValueIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }
  
  public native V next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$ValueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */