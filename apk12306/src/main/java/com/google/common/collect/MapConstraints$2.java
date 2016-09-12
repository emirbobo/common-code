package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map.Entry;

final class MapConstraints$2
  extends ForwardingMapEntry<K, Collection<V>>
{
  static
  {
    JniLib.a(2.class, 591);
  }
  
  MapConstraints$2(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected native Map.Entry<K, Collection<V>> delegate();
  
  public native Collection<V> getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */