package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

class CustomConcurrentHashMap$StrongEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  final int hash;
  final K key;
  final CustomConcurrentHashMap<K, V> map;
  final CustomConcurrentHashMap.ReferenceEntry<K, V> next;
  volatile CustomConcurrentHashMap.ValueReference<K, V> valueReference = CustomConcurrentHashMap.unset();
  
  static
  {
    JniLib.a(StrongEntry.class, 415);
  }
  
  CustomConcurrentHashMap$StrongEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, K paramK, int paramInt, @Nullable CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.map = paramCustomConcurrentHashMap;
    this.key = paramK;
    this.hash = paramInt;
    this.next = paramReferenceEntry;
  }
  
  public native long getExpirationTime();
  
  public native int getHash();
  
  public native K getKey();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNext();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable();
  
  public native CustomConcurrentHashMap.ValueReference<K, V> getValueReference();
  
  public native void notifyKeyReclaimed();
  
  public native void notifyValueReclaimed(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
  
  public native void setExpirationTime(long paramLong);
  
  public native void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$StrongEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */