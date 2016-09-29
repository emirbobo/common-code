package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.util.AbstractQueue;
import java.util.Iterator;

@VisibleForTesting
class CustomConcurrentHashMap$Segment$ExpirationQueue
  extends AbstractQueue<CustomConcurrentHashMap.ReferenceEntry<K, V>>
{
  @VisibleForTesting
  final CustomConcurrentHashMap.ReferenceEntry<K, V> head = new CustomConcurrentHashMap.ReferenceEntry()
  {
    CustomConcurrentHashMap.ReferenceEntry<K, V> nextExpirable = this;
    CustomConcurrentHashMap.ReferenceEntry<K, V> previousExpirable = this;
    
    static
    {
      JniLib.a(1.class, 406);
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
    
    public native void notifyValueReclaimed(CustomConcurrentHashMap.ValueReference<K, V> paramAnonymousValueReference);
    
    public native void setExpirationTime(long paramAnonymousLong);
    
    public native void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramAnonymousReferenceEntry);
    
    public native void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramAnonymousReferenceEntry);
    
    public native void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramAnonymousReferenceEntry);
    
    public native void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramAnonymousReferenceEntry);
    
    public native void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramAnonymousValueReference);
  };
  
  static
  {
    JniLib.a(ExpirationQueue.class, 408);
  }
  
  CustomConcurrentHashMap$Segment$ExpirationQueue(CustomConcurrentHashMap.Segment paramSegment) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  public native Iterator<CustomConcurrentHashMap.ReferenceEntry<K, V>> iterator();
  
  public native boolean offer(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> peek();
  
  public native CustomConcurrentHashMap.ReferenceEntry<K, V> poll();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Segment$ExpirationQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */