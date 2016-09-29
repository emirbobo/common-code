package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import java.util.Collection;
import java.util.List;

@GwtIncompatible("untested")
final class Multimaps$TransformedEntriesListMultimap<K, V1, V2>
  extends Multimaps.TransformedEntriesMultimap<K, V1, V2>
  implements ListMultimap<K, V2>
{
  static
  {
    JniLib.a(TransformedEntriesListMultimap.class, 663);
  }
  
  Multimaps$TransformedEntriesListMultimap(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    super(paramListMultimap, paramEntryTransformer);
  }
  
  public native List<V2> get(K paramK);
  
  public native List<V2> removeAll(Object paramObject);
  
  public native List<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable);
  
  native List<V2> transform(K paramK, Collection<V1> paramCollection);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */