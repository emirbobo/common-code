package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMultimap$Entries
  extends AbstractCollection<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(Entries.class, 345);
  }
  
  private AbstractMultimap$Entries(AbstractMultimap paramAbstractMultimap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$Entries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */