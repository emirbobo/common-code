package com.google.common.collect;

import javax.annotation.Nullable;

 enum CustomConcurrentHashMap$EntryFactory$1
{
  CustomConcurrentHashMap$EntryFactory$1()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, K paramK, int paramInt, @Nullable CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new CustomConcurrentHashMap.StrongEntry(paramCustomConcurrentHashMap, paramK, paramInt, paramReferenceEntry);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$EntryFactory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */