package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map.Entry;

class StandardTable$Column$KeySet$1
  implements Predicate<Map.Entry<R, V>>
{
  static
  {
    JniLib.a(1.class, 757);
  }
  
  StandardTable$Column$KeySet$1(StandardTable.Column.KeySet paramKeySet, Collection paramCollection) {}
  
  public native boolean apply(Map.Entry<R, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Column$KeySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */