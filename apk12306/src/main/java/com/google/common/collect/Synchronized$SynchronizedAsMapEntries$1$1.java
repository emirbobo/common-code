package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1$1
  extends ForwardingMapEntry<K, Collection<V>>
{
  static
  {
    JniLib.a(1.class, 780);
  }
  
  Synchronized$SynchronizedAsMapEntries$1$1(Synchronized.SynchronizedAsMapEntries.1 param1, Map.Entry paramEntry) {}
  
  protected native Map.Entry<K, Collection<V>> delegate();
  
  public native Collection<V> getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedAsMapEntries$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */