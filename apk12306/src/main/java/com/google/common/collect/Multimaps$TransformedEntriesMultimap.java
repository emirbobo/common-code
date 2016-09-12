package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtIncompatible("untested")
class Multimaps$TransformedEntriesMultimap<K, V1, V2>
  implements Multimap<K, V2>
{
  private transient Map<K, Collection<V2>> asMap;
  private transient Collection<Map.Entry<K, V2>> entries;
  final Multimap<K, V1> fromMultimap;
  final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
  private transient Collection<V2> values;
  
  static
  {
    JniLib.a(TransformedEntriesMultimap.class, 662);
  }
  
  Multimaps$TransformedEntriesMultimap(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    this.fromMultimap = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
  }
  
  public native Map<K, Collection<V2>> asMap();
  
  public native void clear();
  
  public native boolean containsEntry(Object paramObject1, Object paramObject2);
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  public native Collection<Map.Entry<K, V2>> entries();
  
  public native boolean equals(Object paramObject);
  
  public native Collection<V2> get(K paramK);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Set<K> keySet();
  
  public native Multiset<K> keys();
  
  public native boolean put(K paramK, V2 paramV2);
  
  public native boolean putAll(Multimap<? extends K, ? extends V2> paramMultimap);
  
  public native boolean putAll(K paramK, Iterable<? extends V2> paramIterable);
  
  public native boolean remove(Object paramObject1, Object paramObject2);
  
  public native Collection<V2> removeAll(Object paramObject);
  
  public native Collection<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable);
  
  public native int size();
  
  public native String toString();
  
  native Collection<V2> transform(K paramK, Collection<V1> paramCollection);
  
  public native Collection<V2> values();
  
  private class TransformedEntries
    extends Collections2.TransformedCollection<Map.Entry<K, V1>, Map.Entry<K, V2>>
  {
    static
    {
      JniLib.a(TransformedEntries.class, 669);
    }
    
    TransformedEntries()
    {
      super(new Function()
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$TransformedEntriesMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */