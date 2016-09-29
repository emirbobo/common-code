package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$KeySet$1
  implements Iterator<K>
{
  Map.Entry<K, Collection<V>> entry;
  final Iterator<Map.Entry<K, Collection<V>>> entryIterator = this.this$1.subMap.entrySet().iterator();
  
  static
  {
    JniLib.a(1.class, 348);
  }
  
  AbstractMultimap$KeySet$1(AbstractMultimap.KeySet paramKeySet) {}
  
  public native boolean hasNext();
  
  public native K next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$KeySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */