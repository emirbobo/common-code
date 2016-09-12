package android.support.v4.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class MapCollections$MapIterator
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int mEnd;
  boolean mEntryValid = false;
  int mIndex;
  
  MapCollections$MapIterator(MapCollections paramMapCollections)
  {
    this.mEnd = (paramMapCollections.colGetSize() - 1);
    this.mIndex = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {
      bool1 = bool2;
    }
    do
    {
      return bool1;
      paramObject = (Map.Entry)paramObject;
    } while ((ContainerHelpers.equal(((Map.Entry)paramObject).getKey(), this.this$0.colGetEntry(this.mIndex, 0))) && (ContainerHelpers.equal(((Map.Entry)paramObject).getValue(), this.this$0.colGetEntry(this.mIndex, 1))));
    for (;;)
    {
      bool1 = false;
    }
  }
  
  public K getKey()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (K)this.this$0.colGetEntry(this.mIndex, 0);
  }
  
  public V getValue()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (V)this.this$0.colGetEntry(this.mIndex, 1);
  }
  
  public boolean hasNext()
  {
    if (this.mIndex < this.mEnd) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject2 = this.this$0.colGetEntry(this.mIndex, 0);
    Object localObject1 = this.this$0.colGetEntry(this.mIndex, 1);
    int i;
    if (localObject2 == null)
    {
      i = 0;
      if (localObject1 != null) {
        break label70;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject2.hashCode();
      break;
      label70:
      j = localObject1.hashCode();
    }
  }
  
  public Map.Entry<K, V> next()
  {
    this.mIndex += 1;
    this.mEntryValid = true;
    return this;
  }
  
  public void remove()
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException();
    }
    this.mIndex -= 1;
    this.mEnd -= 1;
    this.mEntryValid = false;
    this.this$0.colRemoveAt(this.mIndex);
  }
  
  public V setValue(V paramV)
  {
    if (!this.mEntryValid) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return (V)this.this$0.colSetValue(this.mIndex, paramV);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\util\MapCollections$MapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */