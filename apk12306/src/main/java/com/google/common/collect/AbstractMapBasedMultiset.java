package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractMapBasedMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  @GwtIncompatible("not needed in emulated source.")
  private static final long serialVersionUID = -2250766705698539974L;
  private transient Map<E, AtomicInteger> backingMap;
  private transient AbstractMapBasedMultiset<E>.EntrySet entrySet;
  private transient long size;
  
  protected AbstractMapBasedMultiset(Map<E, AtomicInteger> paramMap)
  {
    this.backingMap = ((Map)Preconditions.checkNotNull(paramMap));
    this.size = super.size();
  }
  
  private static int getAndSet(AtomicInteger paramAtomicInteger, int paramInt)
  {
    if (paramAtomicInteger == null) {}
    for (paramInt = 0;; paramInt = paramAtomicInteger.getAndSet(paramInt)) {
      return paramInt;
    }
  }
  
  @GwtIncompatible("java.io.ObjectStreamException")
  private void readObjectNoData()
    throws ObjectStreamException
  {
    throw new InvalidObjectException("Stream data required");
  }
  
  private int removeAllOccurrences(@Nullable Object paramObject, Map<E, AtomicInteger> paramMap)
  {
    int i = 0;
    paramObject = (AtomicInteger)paramMap.remove(paramObject);
    if (paramObject == null) {}
    for (;;)
    {
      return i;
      i = ((AtomicInteger)paramObject).getAndSet(0);
      this.size -= i;
    }
  }
  
  public int add(@Nullable E paramE, int paramInt)
  {
    if (paramInt == 0)
    {
      i = count(paramE);
      return i;
    }
    if (paramInt > 0) {}
    AtomicInteger localAtomicInteger;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
      localAtomicInteger = (AtomicInteger)this.backingMap.get(paramE);
      if (localAtomicInteger != null) {
        break label98;
      }
      i = 0;
      this.backingMap.put(paramE, new AtomicInteger(paramInt));
      this.size += paramInt;
      break;
    }
    label98:
    int i = localAtomicInteger.get();
    long l = i + paramInt;
    if (l <= 2147483647L) {}
    for (bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "too many occurrences: %s", new Object[] { Long.valueOf(l) });
      localAtomicInteger.getAndAdd(paramInt);
      break;
    }
  }
  
  Map<E, AtomicInteger> backingMap()
  {
    return this.backingMap;
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    paramObject = (AtomicInteger)this.backingMap.get(paramObject);
    if ((paramObject != null) && (((AtomicInteger)paramObject).get() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int count(@Nullable Object paramObject)
  {
    paramObject = (AtomicInteger)this.backingMap.get(paramObject);
    if (paramObject == null) {}
    for (int i = 0;; i = ((AtomicInteger)paramObject).get()) {
      return i;
    }
  }
  
  Set<E> createElementSet()
  {
    return new MapBasedElementSet(this.backingMap);
  }
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    EntrySet localEntrySet2 = this.entrySet;
    EntrySet localEntrySet1 = localEntrySet2;
    if (localEntrySet2 == null)
    {
      localEntrySet1 = new EntrySet(null);
      this.entrySet = localEntrySet1;
    }
    return localEntrySet1;
  }
  
  public Iterator<E> iterator()
  {
    return new MapBasedMultisetIterator();
  }
  
  public int remove(@Nullable Object paramObject, int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      i = count(paramObject);
    }
    boolean bool;
    label21:
    AtomicInteger localAtomicInteger;
    do
    {
      return i;
      if (paramInt <= 0) {
        break;
      }
      bool = true;
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
      localAtomicInteger = (AtomicInteger)this.backingMap.get(paramObject);
    } while (localAtomicInteger == null);
    i = localAtomicInteger.get();
    if (i > paramInt) {}
    for (;;)
    {
      localAtomicInteger.addAndGet(-paramInt);
      this.size -= paramInt;
      break;
      bool = false;
      break label21;
      paramInt = i;
      this.backingMap.remove(paramObject);
    }
  }
  
  void setBackingMap(Map<E, AtomicInteger> paramMap)
  {
    this.backingMap = paramMap;
  }
  
  public int setCount(E paramE, int paramInt)
  {
    Multisets.checkNonnegative(paramInt, "count");
    int i;
    if (paramInt == 0) {
      i = getAndSet((AtomicInteger)this.backingMap.remove(paramE), paramInt);
    }
    for (;;)
    {
      this.size += paramInt - i;
      return i;
      AtomicInteger localAtomicInteger = (AtomicInteger)this.backingMap.get(paramE);
      int j = getAndSet(localAtomicInteger, paramInt);
      i = j;
      if (localAtomicInteger == null)
      {
        this.backingMap.put(paramE, new AtomicInteger(paramInt));
        i = j;
      }
    }
  }
  
  public int size()
  {
    return Ints.saturatedCast(this.size);
  }
  
  private class EntrySet
    extends AbstractSet<Multiset.Entry<E>>
  {
    static
    {
      JniLib.a(EntrySet.class, 338);
    }
    
    private EntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Multiset.Entry<E>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  class MapBasedElementSet
    extends ForwardingSet<E>
  {
    private final Set<E> delegate;
    private final Map<E, AtomicInteger> map;
    
    static
    {
      JniLib.a(MapBasedElementSet.class, 340);
    }
    
    MapBasedElementSet()
    {
      Map localMap;
      this.map = localMap;
      this.delegate = localMap.keySet();
    }
    
    public native void clear();
    
    protected native Set<E> delegate();
    
    public native Map<E, AtomicInteger> getMap();
    
    public native Iterator<E> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
  }
  
  private class MapBasedMultisetIterator
    implements Iterator<E>
  {
    boolean canRemove;
    Map.Entry<E, AtomicInteger> currentEntry;
    final Iterator<Map.Entry<E, AtomicInteger>> entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
    int occurrencesLeft;
    
    static
    {
      JniLib.a(MapBasedMultisetIterator.class, 341);
    }
    
    MapBasedMultisetIterator() {}
    
    public native boolean hasNext();
    
    public native E next();
    
    public native void remove();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */