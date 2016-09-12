package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;

 enum CustomConcurrentHashMap$Strength$1
{
  CustomConcurrentHashMap$Strength$1()
  {
    super(paramString, paramInt, null);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalences.equals();
  }
  
  <K, V> CustomConcurrentHashMap.ValueReference<K, V> referenceValue(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV)
  {
    return new CustomConcurrentHashMap.StrongValueReference(paramV);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Strength$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */