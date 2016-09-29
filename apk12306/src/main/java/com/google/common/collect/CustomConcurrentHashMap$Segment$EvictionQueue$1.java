package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class CustomConcurrentHashMap$Segment$EvictionQueue$1
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  CustomConcurrentHashMap.ReferenceEntry<K, V> nextEvictable = this;
  CustomConcurrentHashMap.ReferenceEntry<K, V> previousEvictable = this;
  
  static
  {
    JniLib.a(1.class, 403);
  }
  
  CustomConcurrentHashMap$Segment$EvictionQueue$1(CustomConcurrentHashMap.Segment.EvictionQueue paramEvictionQueue) {}
  
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Segment$EvictionQueue$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */