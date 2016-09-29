package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMultimap$EntryIterator
  implements Iterator<Map.Entry<K, V>>
{
  Collection<V> collection;
  K key;
  final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
  Iterator<V> valueIterator;
  
  static
  {
    JniLib.a(EntryIterator.class, 346);
  }
  
  AbstractMultimap$EntryIterator(AbstractMultimap paramAbstractMultimap)
  {
    this.keyIterator = AbstractMultimap.access$000(paramAbstractMultimap).entrySet().iterator();
    if (this.keyIterator.hasNext()) {
      findValueIteratorAndKey();
    }
    for (;;)
    {
      return;
      this.valueIterator = Iterators.emptyModifiableIterator();
    }
  }
  
  native void findValueIteratorAndKey();
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$EntryIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */