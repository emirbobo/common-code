package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$TransformedEntriesMap$EntrySet
  extends AbstractSet<Map.Entry<K, V2>>
{
  static
  {
    JniLib.a(EntrySet.class, 635);
  }
  
  Maps$TransformedEntriesMap$EntrySet(Maps.TransformedEntriesMap paramTransformedEntriesMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<K, V2>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$TransformedEntriesMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */