package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class CustomConcurrentHashMap$AbstractSerializationProxy<K, V>
  extends ForwardingConcurrentMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 2L;
  final int concurrencyLevel;
  transient ConcurrentMap<K, V> delegate;
  final MapEvictionListener<? super K, ? super V> evictionListener;
  final long expireAfterAccessNanos;
  final long expireAfterWriteNanos;
  final Equivalence<Object> keyEquivalence;
  final CustomConcurrentHashMap.Strength keyStrength;
  final int maximumSize;
  final Equivalence<Object> valueEquivalence;
  final CustomConcurrentHashMap.Strength valueStrength;
  
  CustomConcurrentHashMap$AbstractSerializationProxy(CustomConcurrentHashMap.Strength paramStrength1, CustomConcurrentHashMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapEvictionListener<? super K, ? super V> paramMapEvictionListener, ConcurrentMap<K, V> paramConcurrentMap)
  {
    this.keyStrength = paramStrength1;
    this.valueStrength = paramStrength2;
    this.keyEquivalence = paramEquivalence1;
    this.valueEquivalence = paramEquivalence2;
    this.expireAfterWriteNanos = paramLong1;
    this.expireAfterAccessNanos = paramLong2;
    this.maximumSize = paramInt1;
    this.concurrencyLevel = paramInt2;
    this.evictionListener = paramMapEvictionListener;
    this.delegate = paramConcurrentMap;
  }
  
  protected ConcurrentMap<K, V> delegate()
  {
    return this.delegate;
  }
  
  void readEntries(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    for (;;)
    {
      Object localObject2 = paramObjectInputStream.readObject();
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = paramObjectInputStream.readObject();
      this.delegate.put(localObject2, localObject1);
    }
  }
  
  MapMaker readMapMaker(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    int i = paramObjectInputStream.readInt();
    paramObjectInputStream = new MapMaker().initialCapacity(i).setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).privateKeyEquivalence(this.keyEquivalence).privateValueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel);
    paramObjectInputStream.evictionListener(this.evictionListener);
    if (this.expireAfterWriteNanos > 0L) {
      paramObjectInputStream.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
    }
    if (this.expireAfterAccessNanos > 0L) {
      paramObjectInputStream.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
    }
    if (this.maximumSize != -1) {
      paramObjectInputStream.maximumSize(this.maximumSize);
    }
    return paramObjectInputStream;
  }
  
  void writeMapTo(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.delegate.size());
    Iterator localIterator = this.delegate.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
    paramObjectOutputStream.writeObject(null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$AbstractSerializationProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */