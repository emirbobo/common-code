package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class Synchronized
{
  static
  {
    JniLib.a(Synchronized.class, 796);
  }
  
  static native <K, V> BiMap<K, V> biMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject);
  
  private static native <E> Collection<E> collection(Collection<E> paramCollection, @Nullable Object paramObject);
  
  private static native <E> List<E> list(List<E> paramList, @Nullable Object paramObject);
  
  static native <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject);
  
  @VisibleForTesting
  static native <K, V> Map<K, V> map(Map<K, V> paramMap, @Nullable Object paramObject);
  
  static native <K, V> Multimap<K, V> multimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject);
  
  static native <E> Multiset<E> multiset(Multiset<E> paramMultiset, @Nullable Object paramObject);
  
  @VisibleForTesting
  static native <E> Set<E> set(Set<E> paramSet, @Nullable Object paramObject);
  
  static native <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject);
  
  static native <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject);
  
  private static native <E> SortedSet<E> sortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject);
  
  static native <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject);
  
  private static native <E> Collection<E> typePreservingCollection(Collection<E> paramCollection, @Nullable Object paramObject);
  
  private static native <E> Set<E> typePreservingSet(Set<E> paramSet, @Nullable Object paramObject);
  
  private static class SynchronizedAsMap<K, V>
    extends Synchronized.SynchronizedMap<K, Collection<V>>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
    transient Collection<Collection<V>> asMapValues;
    
    static
    {
      JniLib.a(SynchronizedAsMap.class, 779);
    }
    
    SynchronizedAsMap(Map<K, Collection<V>> paramMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native boolean containsValue(Object paramObject);
    
    public native Set<Map.Entry<K, Collection<V>>> entrySet();
    
    public native Collection<V> get(Object paramObject);
    
    public native Collection<Collection<V>> values();
  }
  
  private static class SynchronizedAsMapEntries<K, V>
    extends Synchronized.SynchronizedSet<Map.Entry<K, Collection<V>>>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedAsMapEntries.class, 784);
    }
    
    SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native boolean equals(Object paramObject);
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class SynchronizedAsMapValues<V>
    extends Synchronized.SynchronizedCollection<Collection<V>>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedAsMapValues.class, 786);
    }
    
    SynchronizedAsMapValues(Collection<Collection<V>> paramCollection, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public native Iterator<Collection<V>> iterator();
  }
  
  @VisibleForTesting
  static class SynchronizedBiMap<K, V>
    extends Synchronized.SynchronizedMap<K, V>
    implements BiMap<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private transient BiMap<V, K> inverse;
    private transient Set<V> valueSet;
    
    static
    {
      JniLib.a(SynchronizedBiMap.class, 787);
    }
    
    private SynchronizedBiMap(BiMap<K, V> paramBiMap, @Nullable Object paramObject, @Nullable BiMap<V, K> paramBiMap1)
    {
      super(paramObject);
      this.inverse = paramBiMap1;
    }
    
    native BiMap<K, V> delegate();
    
    public native V forcePut(K paramK, V paramV);
    
    public native BiMap<V, K> inverse();
    
    public native Set<V> values();
  }
  
  @VisibleForTesting
  static class SynchronizedCollection<E>
    extends Synchronized.SynchronizedObject
    implements Collection<E>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedCollection.class, 782);
    }
    
    private SynchronizedCollection(Collection<E> paramCollection, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    native Collection<E> delegate();
    
    public native boolean isEmpty();
    
    public native Iterator<E> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class SynchronizedList<E>
    extends Synchronized.SynchronizedCollection<E>
    implements List<E>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedList.class, 788);
    }
    
    SynchronizedList(List<E> paramList, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public native void add(int paramInt, E paramE);
    
    public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
    
    native List<E> delegate();
    
    public native boolean equals(Object paramObject);
    
    public native E get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(Object paramObject);
    
    public native int lastIndexOf(Object paramObject);
    
    public native ListIterator<E> listIterator();
    
    public native ListIterator<E> listIterator(int paramInt);
    
    public native E remove(int paramInt);
    
    public native E set(int paramInt, E paramE);
    
    public native List<E> subList(int paramInt1, int paramInt2);
  }
  
  private static class SynchronizedListMultimap<K, V>
    extends Synchronized.SynchronizedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedListMultimap.class, 790);
    }
    
    SynchronizedListMultimap(ListMultimap<K, V> paramListMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    native ListMultimap<K, V> delegate();
    
    public native List<V> get(K paramK);
    
    public native List<V> removeAll(Object paramObject);
    
    public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  private static class SynchronizedMap<K, V>
    extends Synchronized.SynchronizedObject
    implements Map<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, V>> entrySet;
    transient Set<K> keySet;
    transient Collection<V> values;
    
    static
    {
      JniLib.a(SynchronizedMap.class, 778);
    }
    
    SynchronizedMap(Map<K, V> paramMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native void clear();
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    native Map<K, V> delegate();
    
    public native Set<Map.Entry<K, V>> entrySet();
    
    public native boolean equals(Object paramObject);
    
    public native V get(Object paramObject);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Set<K> keySet();
    
    public native V put(K paramK, V paramV);
    
    public native void putAll(Map<? extends K, ? extends V> paramMap);
    
    public native V remove(Object paramObject);
    
    public native int size();
    
    public native Collection<V> values();
  }
  
  private static class SynchronizedMultimap<K, V>
    extends Synchronized.SynchronizedObject
    implements Multimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Map<K, Collection<V>> asMap;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient Multiset<K> keys;
    transient Collection<V> valuesCollection;
    
    static
    {
      JniLib.a(SynchronizedMultimap.class, 789);
    }
    
    SynchronizedMultimap(Multimap<K, V> paramMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native Map<K, Collection<V>> asMap();
    
    public native void clear();
    
    public native boolean containsEntry(Object paramObject1, Object paramObject2);
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    native Multimap<K, V> delegate();
    
    public native Collection<Map.Entry<K, V>> entries();
    
    public native boolean equals(Object paramObject);
    
    public native Collection<V> get(K paramK);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Set<K> keySet();
    
    public native Multiset<K> keys();
    
    public native boolean put(K paramK, V paramV);
    
    public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public native boolean remove(Object paramObject1, Object paramObject2);
    
    public native Collection<V> removeAll(Object paramObject);
    
    public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native int size();
    
    public native Collection<V> values();
  }
  
  private static class SynchronizedMultiset<E>
    extends Synchronized.SynchronizedCollection<E>
    implements Multiset<E>
  {
    private static final long serialVersionUID = 0L;
    transient Set<E> elementSet;
    transient Set<Multiset.Entry<E>> entrySet;
    
    static
    {
      JniLib.a(SynchronizedMultiset.class, 791);
    }
    
    SynchronizedMultiset(Multiset<E> paramMultiset, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    public native int add(E paramE, int paramInt);
    
    public native int count(Object paramObject);
    
    native Multiset<E> delegate();
    
    public native Set<E> elementSet();
    
    public native Set<Multiset.Entry<E>> entrySet();
    
    public native boolean equals(Object paramObject);
    
    public native int hashCode();
    
    public native int remove(Object paramObject, int paramInt);
    
    public native int setCount(E paramE, int paramInt);
    
    public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  }
  
  static class SynchronizedObject
    implements Serializable
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    final Object delegate;
    final Object mutex;
    
    static
    {
      JniLib.a(SynchronizedObject.class, 777);
    }
    
    SynchronizedObject(Object paramObject1, @Nullable Object paramObject2)
    {
      this.delegate = Preconditions.checkNotNull(paramObject1);
      paramObject1 = paramObject2;
      if (paramObject2 == null) {
        paramObject1 = this;
      }
      this.mutex = paramObject1;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    native Object delegate();
    
    public native String toString();
  }
  
  private static class SynchronizedRandomAccessList<E>
    extends Synchronized.SynchronizedList<E>
    implements RandomAccess
  {
    private static final long serialVersionUID = 0L;
    
    SynchronizedRandomAccessList(List<E> paramList, @Nullable Object paramObject)
    {
      super(paramObject);
    }
  }
  
  static class SynchronizedSet<E>
    extends Synchronized.SynchronizedCollection<E>
    implements Set<E>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedSet.class, 783);
    }
    
    SynchronizedSet(Set<E> paramSet, @Nullable Object paramObject)
    {
      super(paramObject, null);
    }
    
    native Set<E> delegate();
    
    public native boolean equals(Object paramObject);
    
    public native int hashCode();
  }
  
  private static class SynchronizedSetMultimap<K, V>
    extends Synchronized.SynchronizedMultimap<K, V>
    implements SetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    transient Set<Map.Entry<K, V>> entrySet;
    
    static
    {
      JniLib.a(SynchronizedSetMultimap.class, 792);
    }
    
    SynchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    native SetMultimap<K, V> delegate();
    
    public native Set<Map.Entry<K, V>> entries();
    
    public native Set<V> get(K paramK);
    
    public native Set<V> removeAll(Object paramObject);
    
    public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  static class SynchronizedSortedMap<K, V>
    extends Synchronized.SynchronizedMap<K, V>
    implements SortedMap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedSortedMap.class, 793);
    }
    
    SynchronizedSortedMap(SortedMap<K, V> paramSortedMap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native Comparator<? super K> comparator();
    
    native SortedMap<K, V> delegate();
    
    public native K firstKey();
    
    public native SortedMap<K, V> headMap(K paramK);
    
    public native K lastKey();
    
    public native SortedMap<K, V> subMap(K paramK1, K paramK2);
    
    public native SortedMap<K, V> tailMap(K paramK);
  }
  
  static class SynchronizedSortedSet<E>
    extends Synchronized.SynchronizedSet<E>
    implements SortedSet<E>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedSortedSet.class, 794);
    }
    
    SynchronizedSortedSet(SortedSet<E> paramSortedSet, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    public native Comparator<? super E> comparator();
    
    native SortedSet<E> delegate();
    
    public native E first();
    
    public native SortedSet<E> headSet(E paramE);
    
    public native E last();
    
    public native SortedSet<E> subSet(E paramE1, E paramE2);
    
    public native SortedSet<E> tailSet(E paramE);
  }
  
  private static class SynchronizedSortedSetMultimap<K, V>
    extends Synchronized.SynchronizedSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SynchronizedSortedSetMultimap.class, 795);
    }
    
    SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, @Nullable Object paramObject)
    {
      super(paramObject);
    }
    
    native SortedSetMultimap<K, V> delegate();
    
    public native SortedSet<V> get(K paramK);
    
    public native SortedSet<V> removeAll(Object paramObject);
    
    public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native Comparator<? super V> valueComparator();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */