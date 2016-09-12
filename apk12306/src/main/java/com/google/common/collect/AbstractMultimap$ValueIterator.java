package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMultimap$ValueIterator
  implements Iterator<V>
{
  final Iterator<Map.Entry<K, V>> entryIterator = this.this$0.createEntryIterator();
  
  static
  {
    JniLib.a(ValueIterator.class, 359);
  }
  
  private AbstractMultimap$ValueIterator(AbstractMultimap paramAbstractMultimap) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$ValueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */