package com.google.common.collect;

abstract interface CustomConcurrentHashMap$ValueReference<K, V>
{
  public abstract void clear();
  
  public abstract ValueReference<K, V> copyFor(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract V get();
  
  public abstract boolean isComputingReference();
  
  public abstract void notifyValueReclaimed();
  
  public abstract V waitForValue()
    throws InterruptedException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$ValueReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */