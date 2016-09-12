package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class CustomConcurrentHashMap$SoftExpirableEvictableEntry<K, V>
  extends CustomConcurrentHashMap.SoftEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> nextEvictable = CustomConcurrentHashMap.nullEntry();
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> nextExpirable = CustomConcurrentHashMap.nullEntry();
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> previousEvictable = CustomConcurrentHashMap.nullEntry();
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> previousExpirable = CustomConcurrentHashMap.nullEntry();
  volatile long time = Long.MAX_VALUE;
  
  static
  {
    JniLib.a(SoftExpirableEvictableEntry.class, 413);
  }
  
  CustomConcurrentHashMap$SoftExpirableEvictableEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, K paramK, int paramInt, @Nullable CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramCustomConcurrentHashMap, paramK, paramInt, paramReferenceEntry);
  }
  
  public native long getExpirationTime();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable();
  
  public native void setExpirationTime(long paramLong);
  
  public native void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$SoftExpirableEvictableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */