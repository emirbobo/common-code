package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$UnmodifiableEntries$1
  extends ForwardingIterator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(1.class, 638);
  }
  
  Maps$UnmodifiableEntries$1(Maps.UnmodifiableEntries paramUnmodifiableEntries, Iterator paramIterator) {}
  
  protected native Iterator<Map.Entry<K, V>> delegate();
  
  public native Map.Entry<K, V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$UnmodifiableEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */