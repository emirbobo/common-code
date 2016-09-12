package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class Multimaps$3
  implements Maps.EntryTransformer<K, V1, V2>
{
  static
  {
    JniLib.a(3.class, 649);
  }
  
  Multimaps$3(Function paramFunction) {}
  
  public native V2 transformEntry(K paramK, V1 paramV1);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */