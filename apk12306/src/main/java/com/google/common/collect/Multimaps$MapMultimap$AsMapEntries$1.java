package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$MapMultimap$AsMapEntries$1
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  final Iterator<K> keys = this.this$1.this$0.map.keySet().iterator();
  
  static
  {
    JniLib.a(1.class, 658);
  }
  
  Multimaps$MapMultimap$AsMapEntries$1(Multimaps.MapMultimap.AsMapEntries paramAsMapEntries) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, Collection<V>> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap$AsMapEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */