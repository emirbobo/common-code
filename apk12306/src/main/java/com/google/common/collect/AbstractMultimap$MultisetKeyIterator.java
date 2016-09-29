package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMultimap$MultisetKeyIterator
  implements Iterator<K>
{
  final Iterator<Map.Entry<K, V>> entryIterator = this.this$0.entries().iterator();
  
  static
  {
    JniLib.a(MultisetKeyIterator.class, 352);
  }
  
  private AbstractMultimap$MultisetKeyIterator(AbstractMultimap paramAbstractMultimap) {}
  
  public native boolean hasNext();
  
  public native K next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$MultisetKeyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */