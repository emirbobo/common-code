package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Multimaps$UnmodifiableAsMapEntries$1
  extends ForwardingIterator<Map.Entry<K, Collection<V>>>
{
  static
  {
    JniLib.a(1.class, 670);
  }
  
  Multimaps$UnmodifiableAsMapEntries$1(Multimaps.UnmodifiableAsMapEntries paramUnmodifiableAsMapEntries, Iterator paramIterator) {}
  
  protected native Iterator<Map.Entry<K, Collection<V>>> delegate();
  
  public native Map.Entry<K, Collection<V>> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableAsMapEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */