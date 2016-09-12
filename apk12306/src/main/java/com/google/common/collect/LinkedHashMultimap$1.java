package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class LinkedHashMultimap$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> entry;
  
  static
  {
    JniLib.a(1.class, 548);
  }
  
  LinkedHashMultimap$1(LinkedHashMultimap paramLinkedHashMultimap, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedHashMultimap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */