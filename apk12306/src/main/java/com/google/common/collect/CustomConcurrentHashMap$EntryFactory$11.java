package com.google.common.collect;

import javax.annotation.Nullable;

 enum CustomConcurrentHashMap$EntryFactory$11
{
  CustomConcurrentHashMap$EntryFactory$11()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> copyEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    paramCustomConcurrentHashMap = super.copyEntry(paramCustomConcurrentHashMap, paramReferenceEntry1, paramReferenceEntry2);
    copyEvictableEntry(paramReferenceEntry1, paramCustomConcurrentHashMap);
    return paramCustomConcurrentHashMap;
  }
  
  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, K paramK, int paramInt, @Nullable CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new CustomConcurrentHashMap.WeakEvictableEntry(paramCustomConcurrentHashMap, paramK, paramInt, paramReferenceEntry);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$EntryFactory$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */