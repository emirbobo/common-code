package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;

class TreeBasedTable$1
  implements Function<Map<C, V>, Iterator<C>>
{
  static
  {
    JniLib.a(1.class, 804);
  }
  
  TreeBasedTable$1(TreeBasedTable paramTreeBasedTable) {}
  
  public native Iterator<C> apply(Map<C, V> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeBasedTable$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */