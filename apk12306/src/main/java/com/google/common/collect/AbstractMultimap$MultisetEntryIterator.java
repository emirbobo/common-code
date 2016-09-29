package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$MultisetEntryIterator
  implements Iterator<Multiset.Entry<K>>
{
  final Iterator<Map.Entry<K, Collection<V>>> asMapIterator = this.this$0.asMap().entrySet().iterator();
  
  static
  {
    JniLib.a(MultisetEntryIterator.class, 351);
  }
  
  private AbstractMultimap$MultisetEntryIterator(AbstractMultimap paramAbstractMultimap) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<K> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$MultisetEntryIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */