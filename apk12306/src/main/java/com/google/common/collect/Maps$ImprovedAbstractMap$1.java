package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;

class Maps$ImprovedAbstractMap$1
  extends ForwardingSet<K>
{
  static
  {
    JniLib.a(1.class, 630);
  }
  
  Maps$ImprovedAbstractMap$1(Maps.ImprovedAbstractMap paramImprovedAbstractMap, Set paramSet) {}
  
  protected native Set<K> delegate();
  
  public native boolean isEmpty();
  
  public native boolean remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$ImprovedAbstractMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */