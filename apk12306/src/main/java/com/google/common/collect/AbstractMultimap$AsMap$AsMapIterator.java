package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$AsMap$AsMapIterator
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  Collection<V> collection;
  final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = this.this$1.submap.entrySet().iterator();
  
  static
  {
    JniLib.a(AsMapIterator.class, 343);
  }
  
  AbstractMultimap$AsMap$AsMapIterator(AbstractMultimap.AsMap paramAsMap) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, Collection<V>> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$AsMap$AsMapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */