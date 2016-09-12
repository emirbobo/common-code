package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

class Multimaps$TransformedEntriesListMultimap$1
  implements Function<V1, V2>
{
  static
  {
    JniLib.a(1.class, 661);
  }
  
  Multimaps$TransformedEntriesListMultimap$1(Multimaps.TransformedEntriesListMultimap paramTransformedEntriesListMultimap, Object paramObject) {}
  
  public native V2 apply(V1 paramV1);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesListMultimap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */