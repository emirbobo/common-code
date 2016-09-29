package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class StandardTable$Values
  extends StandardTable<R, C, V>.TableCollection<V>
{
  static
  {
    JniLib.a(Values.class, 776);
  }
  
  private StandardTable$Values(StandardTable paramStandardTable)
  {
    super(paramStandardTable, null);
  }
  
  public native Iterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */