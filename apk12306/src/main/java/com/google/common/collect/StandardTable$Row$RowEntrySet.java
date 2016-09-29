package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Row$RowEntrySet
  extends AbstractSet<Map.Entry<C, V>>
{
  static
  {
    JniLib.a(RowEntrySet.class, 771);
  }
  
  private StandardTable$Row$RowEntrySet(StandardTable.Row paramRow) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Map.Entry<C, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Row$RowEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */