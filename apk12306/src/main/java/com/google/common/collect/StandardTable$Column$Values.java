package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class StandardTable$Column$Values
  extends AbstractCollection<V>
{
  static
  {
    JniLib.a(Values.class, 761);
  }
  
  StandardTable$Column$Values(StandardTable.Column paramColumn) {}
  
  public native void clear();
  
  public native boolean isEmpty();
  
  public native Iterator<V> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Column$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */