package com.google.common.collect;

 enum CustomConcurrentHashMap$NullEntry
  implements CustomConcurrentHashMap.ReferenceEntry<Object, Object>
{
  INSTANCE;
  
  private CustomConcurrentHashMap$NullEntry() {}
  
  public long getExpirationTime()
  {
    return 0L;
  }
  
  public int getHash()
  {
    return 0;
  }
  
  public Object getKey()
  {
    return null;
  }
  
  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNext()
  {
    return null;
  }
  
  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNextEvictable()
  {
    return this;
  }
  
  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNextExpirable()
  {
    return this;
  }
  
  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getPreviousEvictable()
  {
    return this;
  }
  
  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getPreviousExpirable()
  {
    return this;
  }
  
  public CustomConcurrentHashMap.ValueReference<Object, Object> getValueReference()
  {
    return null;
  }
  
  public void notifyKeyReclaimed() {}
  
  public void notifyValueReclaimed(CustomConcurrentHashMap.ValueReference<Object, Object> paramValueReference) {}
  
  public void setExpirationTime(long paramLong) {}
  
  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry) {}
  
  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry) {}
  
  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry) {}
  
  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry) {}
  
  public void setValueReference(CustomConcurrentHashMap.ValueReference<Object, Object> paramValueReference) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$NullEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */