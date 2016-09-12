package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;

 enum CustomConcurrentHashMap$Strength$2
{
  CustomConcurrentHashMap$Strength$2()
  {
    super(paramString, paramInt, null);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalences.identity();
  }
  
  <K, V> CustomConcurrentHashMap.ValueReference<K, V> referenceValue(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV)
  {
    return new CustomConcurrentHashMap.SoftValueReference(paramV, paramReferenceEntry);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Strength$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */