package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$TransformedEntriesMap$EntrySet$1
  implements Iterator<Map.Entry<K, V2>>
{
  static
  {
    JniLib.a(1.class, 634);
  }
  
  Maps$TransformedEntriesMap$EntrySet$1(Maps.TransformedEntriesMap.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Map.Entry<K, V2> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$TransformedEntriesMap$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */