package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection
  implements Collection<V>
{
  MapCollections$ValuesCollection(MapCollections paramMapCollections) {}
  
  public boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    this.this$0.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (this.this$0.colIndexOfValue(paramObject) >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    do
    {
      if (!paramCollection.hasNext()) {
        break;
      }
    } while (contains(paramCollection.next()));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public boolean isEmpty()
  {
    if (this.this$0.colGetSize() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<V> iterator()
  {
    return new MapCollections.ArrayIterator(this.this$0, 1);
  }
  
  public boolean remove(Object paramObject)
  {
    int i = this.this$0.colIndexOfValue(paramObject);
    if (i >= 0) {
      this.this$0.colRemoveAt(i);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    int j = this.this$0.colGetSize();
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      int m = j;
      int k = i;
      if (paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        k = i - 1;
        m = j - 1;
        bool = true;
      }
      i = k + 1;
      j = m;
    }
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int j = this.this$0.colGetSize();
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      int k = j;
      int m = i;
      if (!paramCollection.contains(this.this$0.colGetEntry(i, 1)))
      {
        this.this$0.colRemoveAt(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public int size()
  {
    return this.this$0.colGetSize();
  }
  
  public Object[] toArray()
  {
    return this.this$0.toArrayHelper(1);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.this$0.toArrayHelper(paramArrayOfT, 1);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\util\MapCollections$ValuesCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */