package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class ImmutableSortedMap$3
  extends TransformedImmutableList<Map.Entry<K, V>, K>
{
  static
  {
    JniLib.a(3.class, 496);
  }
  
  ImmutableSortedMap$3(ImmutableSortedMap paramImmutableSortedMap, ImmutableList paramImmutableList)
  {
    super(paramImmutableList);
  }
  
  native K transform(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */