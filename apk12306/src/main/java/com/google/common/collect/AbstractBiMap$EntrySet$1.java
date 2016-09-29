package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> entry;
  
  static
  {
    JniLib.a(1.class, 329);
  }
  
  AbstractBiMap$EntrySet$1(AbstractBiMap.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */