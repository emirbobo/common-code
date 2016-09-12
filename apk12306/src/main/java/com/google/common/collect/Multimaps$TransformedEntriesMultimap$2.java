package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;

class Multimaps$TransformedEntriesMultimap$2
  implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>
{
  static
  {
    JniLib.a(2.class, 665);
  }
  
  Multimaps$TransformedEntriesMultimap$2(Multimaps.TransformedEntriesMultimap paramTransformedEntriesMultimap) {}
  
  public native Collection<V2> transformEntry(K paramK, Collection<V1> paramCollection);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesMultimap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */