package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class SortedMaps$1
  implements Maps.EntryTransformer<K, V1, V2>
{
  static
  {
    JniLib.a(1.class, 738);
  }
  
  SortedMaps$1(Function paramFunction) {}
  
  public native V2 transformEntry(K paramK, V1 paramV1);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedMaps$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */