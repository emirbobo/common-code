package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMap<K, V>
  extends Synchronized.SynchronizedObject
  implements Map<K, V>
{
  private static final long serialVersionUID = 0L;
  transient Set<Map.Entry<K, V>> entrySet;
  transient Set<K> keySet;
  transient Collection<V> values;
  
  static
  {
    JniLib.a(SynchronizedMap.class, 778);
  }
  
  Synchronized$SynchronizedMap(Map<K, V> paramMap, @Nullable Object paramObject)
  {
    super(paramMap, paramObject);
  }
  
  public native void clear();
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  native Map<K, V> delegate();
  
  public native Set<Map.Entry<K, V>> entrySet();
  
  public native boolean equals(Object paramObject);
  
  public native V get(Object paramObject);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Set<K> keySet();
  
  public native V put(K paramK, V paramV);
  
  public native void putAll(Map<? extends K, ? extends V> paramMap);
  
  public native V remove(Object paramObject);
  
  public native int size();
  
  public native Collection<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */