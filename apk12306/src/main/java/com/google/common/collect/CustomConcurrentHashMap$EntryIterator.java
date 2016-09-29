package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

final class CustomConcurrentHashMap$EntryIterator
  extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(EntryIterator.class, 398);
  }
  
  CustomConcurrentHashMap$EntryIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }
  
  public native Map.Entry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$EntryIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */