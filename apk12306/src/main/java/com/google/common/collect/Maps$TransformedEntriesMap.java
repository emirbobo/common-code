package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$TransformedEntriesMap<K, V1, V2>
  extends AbstractMap<K, V2>
{
  TransformedEntriesMap<K, V1, V2>.EntrySet entrySet;
  final Map<K, V1> fromMap;
  final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
  
  static
  {
    JniLib.a(TransformedEntriesMap.class, 636);
  }
  
  Maps$TransformedEntriesMap(Map<K, V1> paramMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
  {
    this.fromMap = ((Map)Preconditions.checkNotNull(paramMap));
    this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
  }
  
  public native void clear();
  
  public native boolean containsKey(Object paramObject);
  
  public native Set<Map.Entry<K, V2>> entrySet();
  
  public native V2 get(Object paramObject);
  
  public native V2 remove(Object paramObject);
  
  public native int size();
  
  class EntrySet
    extends AbstractSet<Map.Entry<K, V2>>
  {
    static
    {
      JniLib.a(EntrySet.class, 635);
    }
    
    EntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<K, V2>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$TransformedEntriesMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */