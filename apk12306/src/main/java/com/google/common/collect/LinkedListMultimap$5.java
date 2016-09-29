package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class LinkedListMultimap$5
  extends AbstractMap<K, Collection<V>>
{
  Set<Map.Entry<K, Collection<V>>> entrySet;
  
  static
  {
    JniLib.a(5.class, 560);
  }
  
  LinkedListMultimap$5(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native boolean containsKey(@Nullable Object paramObject);
  
  public native Set<Map.Entry<K, Collection<V>>> entrySet();
  
  public native Collection<V> get(@Nullable Object paramObject);
  
  public native Collection<V> remove(@Nullable Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */