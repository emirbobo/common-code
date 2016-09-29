package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Iterator;

class AbstractMultimap$Values
  extends AbstractCollection<V>
{
  static
  {
    JniLib.a(Values.class, 360);
  }
  
  private AbstractMultimap$Values(AbstractMultimap paramAbstractMultimap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */