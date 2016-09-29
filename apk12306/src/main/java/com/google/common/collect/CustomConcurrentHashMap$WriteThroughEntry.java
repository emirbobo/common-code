package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

final class CustomConcurrentHashMap$WriteThroughEntry
  extends AbstractMapEntry<K, V>
{
  final K key;
  V value;
  
  static
  {
    JniLib.a(WriteThroughEntry.class, 427);
  }
  
  CustomConcurrentHashMap$WriteThroughEntry(K paramK, V paramV)
  {
    this.key = paramV;
    Object localObject;
    this.value = localObject;
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native K getKey();
  
  public native V getValue();
  
  public native int hashCode();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$WriteThroughEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */