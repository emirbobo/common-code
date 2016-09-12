package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Map.Entry;

class Multimaps$TransformedEntriesMultimap$TransformedEntries$1
  implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>>
{
  static
  {
    JniLib.a(1.class, 668);
  }
  
  Multimaps$TransformedEntriesMultimap$TransformedEntries$1(Multimaps.TransformedEntriesMultimap paramTransformedEntriesMultimap, Maps.EntryTransformer paramEntryTransformer) {}
  
  public native Map.Entry<K, V2> apply(Map.Entry<K, V1> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesMultimap$TransformedEntries$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */