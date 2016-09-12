package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class StandardTable$Column$EntrySetIterator$1
  extends AbstractMapEntry<R, V>
{
  static
  {
    JniLib.a(1.class, 755);
  }
  
  StandardTable$Column$EntrySetIterator$1(StandardTable.Column.EntrySetIterator paramEntrySetIterator, Map.Entry paramEntry) {}
  
  public native R getKey();
  
  public native V getValue();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Column$EntrySetIterator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */