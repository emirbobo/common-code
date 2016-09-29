package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class ImmutableSortedMap$EntrySet<K, V>
  extends ImmutableSet<Map.Entry<K, V>>
{
  final transient ImmutableSortedMap<K, V> map;
  
  static
  {
    JniLib.a(EntrySet.class, 499);
  }
  
  ImmutableSortedMap$EntrySet(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }
  
  public native boolean contains(Object paramObject);
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Map.Entry<K, V>> iterator();
  
  public native int size();
  
  native Object writeReplace();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */