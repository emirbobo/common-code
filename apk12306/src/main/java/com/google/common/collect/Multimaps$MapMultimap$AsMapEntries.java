package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$MapMultimap$AsMapEntries
  extends AbstractSet<Map.Entry<K, Collection<V>>>
{
  static
  {
    JniLib.a(AsMapEntries.class, 659);
  }
  
  Multimaps$MapMultimap$AsMapEntries(Multimaps.MapMultimap paramMapMultimap) {}
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<K, Collection<V>>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap$AsMapEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */