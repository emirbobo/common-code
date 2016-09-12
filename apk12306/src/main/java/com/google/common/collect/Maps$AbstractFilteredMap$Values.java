package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Maps$AbstractFilteredMap$Values
  extends AbstractCollection<V>
{
  static
  {
    JniLib.a(Values.class, 620);
  }
  
  Maps$AbstractFilteredMap$Values(Maps.AbstractFilteredMap paramAbstractFilteredMap) {}
  
  public native void clear();
  
  public native boolean isEmpty();
  
  public native Iterator<V> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$AbstractFilteredMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */