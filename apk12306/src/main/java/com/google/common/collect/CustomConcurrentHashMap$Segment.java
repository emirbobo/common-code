package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

class CustomConcurrentHashMap$Segment
  extends ReentrantLock
{
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> cleanupQueue = new ConcurrentLinkedQueue();
  final Runnable cleanupRunnable = new Runnable()
  {
    static
    {
      JniLib.a(1.class, 402);
    }
    
    public native void run();
  };
  volatile int count;
  @GuardedBy("Segment.this")
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> evictionQueue;
  @GuardedBy("Segment.this")
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> expirationQueue;
  final int maxSegmentSize;
  int modCount;
  final AtomicInteger readCount = new AtomicInteger();
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> recencyQueue;
  volatile AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> table;
  int threshold;
  
  static
  {
    JniLib.a(Segment.class, 378);
  }
  
  CustomConcurrentHashMap$Segment(CustomConcurrentHashMap paramCustomConcurrentHashMap, int paramInt1, int paramInt2)
  {
    this.maxSegmentSize = paramInt2;
    initTable(newEntryArray(paramInt1));
    Object localObject;
    if ((paramCustomConcurrentHashMap.evictsBySize()) || (paramCustomConcurrentHashMap.expiresAfterAccess()))
    {
      localObject = new ConcurrentLinkedQueue();
      this.recencyQueue = ((Queue)localObject);
      if (!paramCustomConcurrentHashMap.evictsBySize()) {
        break label139;
      }
      localObject = new EvictionQueue();
      label103:
      this.evictionQueue = ((Queue)localObject);
      if (!paramCustomConcurrentHashMap.expires()) {
        break label147;
      }
    }
    label139:
    label147:
    for (paramCustomConcurrentHashMap = new ExpirationQueue();; paramCustomConcurrentHashMap = CustomConcurrentHashMap.discardingQueue())
    {
      this.expirationQueue = paramCustomConcurrentHashMap;
      return;
      localObject = CustomConcurrentHashMap.discardingQueue();
      break;
      localObject = CustomConcurrentHashMap.discardingQueue();
      break label103;
    }
  }
  
  native void clear();
  
  native boolean clearValue(K paramK, int paramInt, CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
  
  native boolean containsKey(Object paramObject, int paramInt);
  
  native boolean containsValue(Object paramObject);
  
  @GuardedBy("Segment.this")
  native void drainRecencyQueue();
  
  @GuardedBy("Segment.this")
  native void enqueueCleanup(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  @GuardedBy("Segment.this")
  native boolean evictEntries();
  
  @GuardedBy("Segment.this")
  native void expand();
  
  @GuardedBy("Segment.this")
  native void expireEntries();
  
  native V get(Object paramObject, int paramInt);
  
  @VisibleForTesting
  native CustomConcurrentHashMap.ReferenceEntry<K, V> getEntry(Object paramObject, int paramInt);
  
  native CustomConcurrentHashMap.ReferenceEntry<K, V> getFirst(int paramInt);
  
  native V getLiveValue(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  native void initTable(AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> paramAtomicReferenceArray);
  
  native AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> newEntryArray(int paramInt);
  
  native void postReadCleanup();
  
  native void postWriteCleanup();
  
  @GuardedBy("Segment.this")
  native void preWriteCleanup();
  
  @GuardedBy("Segment.this")
  native void processPendingCleanup();
  
  native V put(K paramK, int paramInt, V paramV, boolean paramBoolean);
  
  native void recordExpirationTime(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, long paramLong);
  
  @GuardedBy("Segment.this")
  native void recordLockedRead(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  native void recordRead(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  @GuardedBy("Segment.this")
  native void recordWrite(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
  
  native V remove(Object paramObject, int paramInt);
  
  native boolean remove(Object paramObject1, int paramInt, Object paramObject2);
  
  @GuardedBy("Segment.this")
  native CustomConcurrentHashMap.ReferenceEntry<K, V> removeFromChain(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2);
  
  native V replace(K paramK, int paramInt, V paramV);
  
  native boolean replace(K paramK, int paramInt, V paramV1, V paramV2);
  
  native void runCleanup();
  
  native void runLockedCleanup();
  
  native void runUnlockedCleanup();
  
  @GuardedBy("Segment.this")
  native void setValue(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
  
  native void tryExpireEntries();
  
  @GuardedBy("Segment.this")
  native boolean unsetEntry(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, int paramInt);
  
  native boolean unsetKey(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, int paramInt);
  
  @GuardedBy("Segment.this")
  native boolean unsetLiveEntry(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, int paramInt);
  
  native boolean unsetValue(K paramK, int paramInt, CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
  
  @VisibleForTesting
  class EvictionQueue
    extends AbstractQueue<CustomConcurrentHashMap.ReferenceEntry<K, V>>
  {
    @VisibleForTesting
    final CustomConcurrentHashMap.ReferenceEntry<K, V> head = new CustomConcurrentHashMap.ReferenceEntry()
    {
      CustomConcurrentHashMap.ReferenceEntry<K, V> nextEvictable = this;
      CustomConcurrentHashMap.ReferenceEntry<K, V> previousEvictable = this;
      
      static
      {
        JniLib.a(1.class, 403);
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
      JniLib.a(EvictionQueue.class, 405);
    }
    
    EvictionQueue() {}
    
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
  
  @VisibleForTesting
  class ExpirationQueue
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
    
    ExpirationQueue() {}
    
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */