package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Map.Entry;

final class Maps$4
  implements Predicate<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(4.class, 618);
  }
  
  Maps$4(Predicate paramPredicate) {}
  
  public native boolean apply(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */