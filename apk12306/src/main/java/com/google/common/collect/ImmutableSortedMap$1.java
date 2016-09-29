package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import java.util.Map.Entry;

final class ImmutableSortedMap$1
  implements Comparator<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(1.class, 494);
  }
  
  ImmutableSortedMap$1(Comparator paramComparator) {}
  
  public native int compare(Map.Entry<K, V> paramEntry1, Map.Entry<K, V> paramEntry2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */