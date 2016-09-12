package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Map.Entry;

class Multimaps$TransformedEntriesMultimap$3
  implements Function<Map.Entry<K, V1>, V2>
{
  static
  {
    JniLib.a(3.class, 666);
  }
  
  Multimaps$TransformedEntriesMultimap$3(Multimaps.TransformedEntriesMultimap paramTransformedEntriesMultimap) {}
  
  public native V2 apply(Map.Entry<K, V1> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesMultimap$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */