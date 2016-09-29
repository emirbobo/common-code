package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V>
  extends ForwardingMap<K, V>
  implements SortedMap<K, V>
{
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null) {}
    for (int i = ((Comparable)paramObject1).compareTo(paramObject2);; i = localComparator.compare(paramObject1, paramObject2)) {
      return i;
    }
  }
  
  public Comparator<? super K> comparator()
  {
    return delegate().comparator();
  }
  
  protected abstract SortedMap<K, V> delegate();
  
  public K firstKey()
  {
    return (K)delegate().firstKey();
  }
  
  public SortedMap<K, V> headMap(K paramK)
  {
    return delegate().headMap(paramK);
  }
  
  public K lastKey()
  {
    return (K)delegate().lastKey();
  }
  
  @Beta
  protected boolean standardContainsKey(@Nullable Object paramObject)
  {
    boolean bool = false;
    try
    {
      int i = unsafeCompare(tailMap(paramObject).firstKey(), paramObject);
      if (i == 0) {
        bool = true;
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;) {}
    }
    catch (NoSuchElementException paramObject)
    {
      for (;;) {}
    }
    catch (NullPointerException paramObject)
    {
      for (;;) {}
    }
    return bool;
  }
  
  @Beta
  protected V standardRemove(@Nullable Object paramObject)
  {
    try
    {
      Iterator localIterator = tailMap(paramObject).entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (unsafeCompare(localEntry.getKey(), paramObject) == 0)
        {
          paramObject = localEntry.getValue();
          localIterator.remove();
          return (V)paramObject;
        }
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        paramObject = null;
      }
    }
    catch (NullPointerException paramObject)
    {
      for (;;)
      {
        paramObject = null;
        continue;
        paramObject = null;
      }
    }
  }
  
  @Beta
  protected SortedMap<K, V> standardSubMap(K paramK1, K paramK2)
  {
    return tailMap(paramK1).headMap(paramK2);
  }
  
  public SortedMap<K, V> subMap(K paramK1, K paramK2)
  {
    return delegate().subMap(paramK1, paramK2);
  }
  
  public SortedMap<K, V> tailMap(K paramK)
  {
    return delegate().tailMap(paramK);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ForwardingSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */