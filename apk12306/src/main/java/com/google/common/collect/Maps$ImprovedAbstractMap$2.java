package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;

class Maps$ImprovedAbstractMap$2
  extends ForwardingCollection<V>
{
  static
  {
    JniLib.a(2.class, 631);
  }
  
  Maps$ImprovedAbstractMap$2(Maps.ImprovedAbstractMap paramImprovedAbstractMap, Collection paramCollection) {}
  
  protected native Collection<V> delegate();
  
  public native boolean isEmpty();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$ImprovedAbstractMap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */