package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class CustomConcurrentHashMap$StrongEvictableEntry<K, V>
  extends CustomConcurrentHashMap.StrongEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> nextEvictable = CustomConcurrentHashMap.nullEntry();
  @GuardedBy("Segment.this")
  CustomConcurrentHashMap.ReferenceEntry<K, V> previousEvictable = CustomConcurrentHashMap.nullEntry();
  
  static
  {
    JniLib.a(StrongEvictableEntry.class, 416);
  }
  
  CustomConcurrentHashMap$StrongEvictableEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, K paramK, int paramInt, @Nullable CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramCustomConcurrentHashMap, paramK, paramInt, paramReferenceEntry);
  }
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable();
  
  public native void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$StrongEvictableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */