package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class Maps$FilteredEntryMap$KeySet$1
  extends UnmodifiableIterator<K>
{
  static
  {
    JniLib.a(1.class, 626);
  }
  
  Maps$FilteredEntryMap$KeySet$1(Maps.FilteredEntryMap.KeySet paramKeySet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native K next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap$KeySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */