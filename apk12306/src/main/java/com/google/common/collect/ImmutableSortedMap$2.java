package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Map.Entry;

class ImmutableSortedMap$2
  implements Function<Map.Entry<K, V>, K>
{
  static
  {
    JniLib.a(2.class, 495);
  }
  
  ImmutableSortedMap$2(ImmutableSortedMap paramImmutableSortedMap) {}
  
  public native K apply(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */