package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

final class CustomConcurrentHashMap$KeyIterator
  extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<K>
{
  static
  {
    JniLib.a(KeyIterator.class, 400);
  }
  
  CustomConcurrentHashMap$KeyIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }
  
  public native K next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$KeyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */