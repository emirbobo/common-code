package org.codehaus.jackson.map.ser.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ser.SerializerCache.TypeKey;

public class JsonSerializerMap
{
  private final Bucket[] _buckets;
  private final int _size;
  
  public JsonSerializerMap(Map<SerializerCache.TypeKey, JsonSerializer<Object>> paramMap)
  {
    int j = findSize(paramMap.size());
    this._size = j;
    Bucket[] arrayOfBucket = new Bucket[j];
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = (SerializerCache.TypeKey)localEntry.getKey();
      int i = paramMap.hashCode() & j - 1;
      arrayOfBucket[i] = new Bucket(arrayOfBucket[i], paramMap, (JsonSerializer)localEntry.getValue());
    }
    this._buckets = arrayOfBucket;
  }
  
  private static final int findSize(int paramInt)
  {
    if (paramInt <= 64) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 8;
      while (i < paramInt) {
        i += i;
      }
      paramInt += (paramInt >> 2);
    }
    return i;
  }
  
  public JsonSerializer<Object> find(SerializerCache.TypeKey paramTypeKey)
  {
    Object localObject2 = null;
    int i = paramTypeKey.hashCode();
    int j = this._buckets.length;
    Bucket localBucket = this._buckets[(i & j - 1)];
    Object localObject1;
    if (localBucket == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (JsonSerializer<Object>)localObject1;
      localObject1 = localBucket;
      if (paramTypeKey.equals(localBucket.key))
      {
        localObject1 = localBucket.value;
      }
      else
      {
        do
        {
          localBucket = ((Bucket)localObject1).next;
          localObject1 = localObject2;
          if (localBucket == null) {
            break;
          }
          localObject1 = localBucket;
        } while (!paramTypeKey.equals(localBucket.key));
        localObject1 = localBucket.value;
      }
    }
  }
  
  public int size()
  {
    return this._size;
  }
  
  private static final class Bucket
  {
    public final SerializerCache.TypeKey key;
    public final Bucket next;
    public final JsonSerializer<Object> value;
    
    public Bucket(Bucket paramBucket, SerializerCache.TypeKey paramTypeKey, JsonSerializer<Object> paramJsonSerializer)
    {
      this.next = paramBucket;
      this.key = paramTypeKey;
      this.value = paramJsonSerializer;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\impl\JsonSerializerMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */