package org.codehaus.jackson.map.deser.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

public final class BeanPropertyMap
{
  private final Bucket[] _buckets;
  private final int _hashMask;
  private final int _size;
  
  public BeanPropertyMap(Collection<SettableBeanProperty> paramCollection)
  {
    this._size = paramCollection.size();
    int i = findSize(this._size);
    this._hashMask = (i - 1);
    Bucket[] arrayOfBucket = new Bucket[i];
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      paramCollection = (SettableBeanProperty)localIterator.next();
      String str = paramCollection.getName();
      i = str.hashCode() & this._hashMask;
      arrayOfBucket[i] = new Bucket(arrayOfBucket[i], str, paramCollection);
    }
    this._buckets = arrayOfBucket;
  }
  
  private SettableBeanProperty _findWithEquals(String paramString, int paramInt)
  {
    Bucket localBucket = this._buckets[paramInt];
    if (localBucket != null) {
      if (!paramString.equals(localBucket.key)) {}
    }
    for (paramString = localBucket.value;; paramString = null)
    {
      return paramString;
      localBucket = localBucket.next;
      break;
    }
  }
  
  private static final int findSize(int paramInt)
  {
    if (paramInt <= 32) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 2;
      while (i < paramInt) {
        i += i;
      }
      paramInt += (paramInt >> 2);
    }
    return i;
  }
  
  public Iterator<SettableBeanProperty> allProperties()
  {
    return new IteratorImpl(this._buckets);
  }
  
  public void assignIndexes()
  {
    int i = 0;
    for (Bucket localBucket : this._buckets) {
      while (localBucket != null)
      {
        localBucket.value.assignIndex(i);
        localBucket = localBucket.next;
        i++;
      }
    }
  }
  
  public SettableBeanProperty find(String paramString)
  {
    int i = paramString.hashCode() & this._hashMask;
    Bucket localBucket2 = this._buckets[i];
    if (localBucket2 == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Bucket localBucket1 = localBucket2;
      if (localBucket2.key == paramString)
      {
        paramString = localBucket2.value;
      }
      else
      {
        do
        {
          localBucket2 = localBucket1.next;
          if (localBucket2 == null) {
            break;
          }
          localBucket1 = localBucket2;
        } while (localBucket2.key != paramString);
        paramString = localBucket2.value;
        continue;
        paramString = _findWithEquals(paramString, i);
      }
    }
  }
  
  public void replace(SettableBeanProperty paramSettableBeanProperty)
  {
    String str = paramSettableBeanProperty.getName();
    int j = str.hashCode() & this._buckets.length - 1;
    int i = 0;
    Bucket localBucket2 = this._buckets[j];
    Bucket localBucket1 = null;
    if (localBucket2 != null)
    {
      if ((i == 0) && (localBucket2.key.equals(str))) {
        i = 1;
      }
      for (;;)
      {
        localBucket2 = localBucket2.next;
        break;
        localBucket1 = new Bucket(localBucket1, localBucket2.key, localBucket2.value);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty + "' found, can't replace");
    }
    this._buckets[j] = new Bucket(localBucket1, str, paramSettableBeanProperty);
  }
  
  public int size()
  {
    return this._size;
  }
  
  private static final class Bucket
  {
    public final String key;
    public final Bucket next;
    public final SettableBeanProperty value;
    
    public Bucket(Bucket paramBucket, String paramString, SettableBeanProperty paramSettableBeanProperty)
    {
      this.next = paramBucket;
      this.key = paramString;
      this.value = paramSettableBeanProperty;
    }
  }
  
  private static final class IteratorImpl
    implements Iterator<SettableBeanProperty>
  {
    private final BeanPropertyMap.Bucket[] _buckets;
    private BeanPropertyMap.Bucket _currentBucket;
    private int _nextBucketIndex;
    
    public IteratorImpl(BeanPropertyMap.Bucket[] paramArrayOfBucket)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\impl\BeanPropertyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */