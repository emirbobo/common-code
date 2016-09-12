package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Map.Entry;

final class Maps$3
  implements Predicate<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(3.class, 617);
  }
  
  Maps$3(Predicate paramPredicate) {}
  
  public native boolean apply(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */