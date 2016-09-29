package org.codehaus.jackson.map.deser.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

final class BeanPropertyMap$IteratorImpl
  implements Iterator<SettableBeanProperty>
{
  private final BeanPropertyMap.Bucket[] _buckets;
  private BeanPropertyMap.Bucket _currentBucket;
  private int _nextBucketIndex;
  
  public BeanPropertyMap$IteratorImpl(BeanPropertyMap.Bucket[] paramArrayOfBucket)
  {
    this._buckets = paramArrayOfBucket;
    int k = this._buckets.length;
    int i = 0;
    int j;
    if (i < k)
    {
      paramArrayOfBucket = this._buckets;
      j = i + 1;
      paramArrayOfBucket = paramArrayOfBucket[i];
      if (paramArrayOfBucket != null) {
        this._currentBucket = paramArrayOfBucket;
      }
    }
    for (;;)
    {
      this._nextBucketIndex = j;
      return;
      i = j;
      break;
      j = i;
    }
  }
  
  public boolean hasNext()
  {
    if (this._currentBucket != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public SettableBeanProperty next()
  {
    BeanPropertyMap.Bucket localBucket = this._currentBucket;
    if (localBucket == null) {
      throw new NoSuchElementException();
    }
    int i;
    for (Object localObject = localBucket.next; (localObject == null) && (this._nextBucketIndex < this._buckets.length); localObject = localObject[i])
    {
      localObject = this._buckets;
      i = this._nextBucketIndex;
      this._nextBucketIndex = (i + 1);
    }
    this._currentBucket = ((BeanPropertyMap.Bucket)localObject);
    return localBucket.value;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\impl\BeanPropertyMap$IteratorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */