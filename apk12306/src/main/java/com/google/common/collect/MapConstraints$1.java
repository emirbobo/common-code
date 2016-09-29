package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

final class MapConstraints$1
  extends ForwardingMapEntry<K, V>
{
  static
  {
    JniLib.a(1.class, 589);
  }
  
  MapConstraints$1(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected native Map.Entry<K, V> delegate();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */