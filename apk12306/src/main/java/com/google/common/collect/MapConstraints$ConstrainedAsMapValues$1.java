package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;

class MapConstraints$ConstrainedAsMapValues$1
  implements Iterator<Collection<V>>
{
  static
  {
    JniLib.a(1.class, 594);
  }
  
  MapConstraints$ConstrainedAsMapValues$1(MapConstraints.ConstrainedAsMapValues paramConstrainedAsMapValues, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Collection<V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedAsMapValues$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */