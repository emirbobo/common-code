package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$KeySet$1
  implements Iterator<K>
{
  Map.Entry<K, V> entry;
  
  static
  {
    JniLib.a(1.class, 332);
  }
  
  AbstractBiMap$KeySet$1(AbstractBiMap.KeySet paramKeySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native K next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$KeySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */