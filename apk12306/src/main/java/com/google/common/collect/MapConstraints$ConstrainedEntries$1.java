package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries$1
  extends ForwardingIterator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(1.class, 598);
  }
  
  MapConstraints$ConstrainedEntries$1(MapConstraints.ConstrainedEntries paramConstrainedEntries, Iterator paramIterator) {}
  
  protected native Iterator<Map.Entry<K, V>> delegate();
  
  public native Map.Entry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */