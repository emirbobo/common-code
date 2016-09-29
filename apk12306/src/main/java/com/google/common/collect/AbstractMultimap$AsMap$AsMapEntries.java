package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMultimap$AsMap$AsMapEntries
  extends AbstractSet<Map.Entry<K, Collection<V>>>
{
  static
  {
    JniLib.a(AsMapEntries.class, 342);
  }
  
  AbstractMultimap$AsMap$AsMapEntries(AbstractMultimap.AsMap paramAsMap) {}
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$AsMap$AsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */