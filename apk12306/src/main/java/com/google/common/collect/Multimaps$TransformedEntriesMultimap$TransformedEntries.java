package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Map.Entry;

class Multimaps$TransformedEntriesMultimap$TransformedEntries
  extends Collections2.TransformedCollection<Map.Entry<K, V1>, Map.Entry<K, V2>>
{
  static
  {
    JniLib.a(TransformedEntries.class, 669);
  }
  
  Multimaps$TransformedEntriesMultimap$TransformedEntries(Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    super(paramEntryTransformer.fromMultimap.entries(), new Function()
    {
      static
      {
        JniLib.a(1.class, 668);
      }
      
      public native Map.Entry<K, V2> apply(Map.Entry<K, V1> paramAnonymousEntry);
    });
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesMultimap$TransformedEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */