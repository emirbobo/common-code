package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
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

@GwtCompatible
abstract class AbstractMultimap<K, V>
  implements Multimap<K, V>, Serializable
{
  private static final long serialVersionUID = 2447537837011683357L;
  private transient Map<K, Collection<V>> asMap;
  private transient Collection<Map.Entry<K, V>> entries;
  private transient Set<K> keySet;
  private transient Map<K, Collection<V>> map;
  private transient Multiset<K> multiset;
  private transient int totalSize;
  private transient Collection<V> valuesCollection;
  
  protected AbstractMultimap(Map<K, Collection<V>> paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty());
    this.map = paramMap;
  }
  
  private Map<K, Collection<V>> createAsMap()
  {
    if ((this.map instanceof SortedMap)) {}
    for (Object localObject = new SortedAsMap((SortedMap)this.map);; localObject = new AsMap(this.map)) {
      return (Map<K, Collection<V>>)localObject;
    }
  }
  
  private Collection<Map.Entry<K, V>> createEntries()
  {
    if ((this instanceof SetMultimap)) {}
    for (Object localObject = new EntrySet(null);; localObject = new Entries(null)) {
      return (Collection<Map.Entry<K, V>>)localObject;
    }
  }
  
  private Set<K> createKeySet()
  {
    if ((this.map instanceof SortedMap)) {}
    for (Object localObject = new SortedKeySet((SortedMap)this.map);; localObject = new KeySet(this.map)) {
      return (Set<K>)localObject;
    }
  }
  
  private Collection<V> getOrCreateCollection(@Nullable K paramK)
  {
    Collection localCollection2 = (Collection)this.map.get(paramK);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createCollection(paramK);
      this.map.put(paramK, localCollection1);
    }
    return localCollection1;
  }
  
  private Iterator<V> iteratorOrListIterator(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof List)) {}
    for (paramCollection = ((List)paramCollection).listIterator();; paramCollection = paramCollection.iterator()) {
      return paramCollection;
    }
  }
  
  private int removeValuesForKey(Object paramObject)
  {
    int i = 0;
    try
    {
      paramObject = (Collection)this.map.remove(paramObject);
      i = 0;
      if (paramObject != null)
      {
        i = ((Collection)paramObject).size();
        ((Collection)paramObject).clear();
        this.totalSize -= i;
      }
    }
    catch (NullPointerException paramObject)
    {
      for (;;) {}
    }
    catch (ClassCastException paramObject)
    {
      for (;;) {}
    }
    return i;
  }
  
  private Collection<V> unmodifiableCollectionSubclass(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      paramCollection = Collections.unmodifiableSortedSet((SortedSet)paramCollection);
    }
    for (;;)
    {
      return paramCollection;
      if ((paramCollection instanceof Set)) {
        paramCollection = Collections.unmodifiableSet((Set)paramCollection);
      } else if ((paramCollection instanceof List)) {
        paramCollection = Collections.unmodifiableList((List)paramCollection);
      } else {
        paramCollection = Collections.unmodifiableCollection(paramCollection);
      }
    }
  }
  
  private Collection<V> wrapCollection(@Nullable K paramK, Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      paramK = new WrappedSortedSet(paramK, (SortedSet)paramCollection, null);
    }
    for (;;)
    {
      return paramK;
      if ((paramCollection instanceof Set)) {
        paramK = new WrappedSet(paramK, (Set)paramCollection);
      } else if ((paramCollection instanceof List)) {
        paramK = wrapList(paramK, (List)paramCollection, null);
      } else {
        paramK = new WrappedCollection(paramK, paramCollection, null);
      }
    }
  }
  
  private List<V> wrapList(@Nullable K paramK, List<V> paramList, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    if ((paramList instanceof RandomAccess)) {}
    for (paramK = new RandomAccessWrappedList(paramK, paramList, paramAbstractMultimap);; paramK = new WrappedList(paramK, paramList, paramAbstractMultimap)) {
      return paramK;
    }
  }
  
  public Map<K, Collection<V>> asMap()
  {
    Map localMap2 = this.asMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createAsMap();
      this.asMap = localMap1;
    }
    return localMap1;
  }
  
  Map<K, Collection<V>> backingMap()
  {
    return this.map;
  }
  
  public void clear()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    this.map.clear();
    this.totalSize = 0;
  }
  
  public boolean containsEntry(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    paramObject1 = (Collection)this.map.get(paramObject1);
    if ((paramObject1 != null) && (((Collection)paramObject1).contains(paramObject2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    Iterator localIterator = this.map.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Collection)localIterator.next()).contains(paramObject));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  abstract Collection<V> createCollection();
  
  Collection<V> createCollection(@Nullable K paramK)
  {
    return createCollection();
  }
  
  Iterator<Map.Entry<K, V>> createEntryIterator()
  {
    return new EntryIterator();
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    Collection localCollection2 = this.entries;
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createEntries();
      this.entries = localCollection1;
    }
    return localCollection1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramObject instanceof Multimap))
      {
        paramObject = (Multimap)paramObject;
        bool = this.map.equals(((Multimap)paramObject).asMap());
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public Collection<V> get(@Nullable K paramK)
  {
    Collection localCollection2 = (Collection)this.map.get(paramK);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null) {
      localCollection1 = createCollection(paramK);
    }
    return wrapCollection(paramK, localCollection1);
  }
  
  public int hashCode()
  {
    return this.map.hashCode();
  }
  
  public boolean isEmpty()
  {
    if (this.totalSize == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Set<K> keySet()
  {
    Set localSet2 = this.keySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createKeySet();
      this.keySet = localSet1;
    }
    return localSet1;
  }
  
  public Multiset<K> keys()
  {
    Multiset localMultiset = this.multiset;
    Object localObject = localMultiset;
    if (localMultiset == null)
    {
      localObject = new MultisetView(null);
      this.multiset = ((Multiset)localObject);
    }
    return (Multiset<K>)localObject;
  }
  
  public boolean put(@Nullable K paramK, @Nullable V paramV)
  {
    if (getOrCreateCollection(paramK).add(paramV)) {
      this.totalSize += 1;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
  {
    boolean bool = false;
    Iterator localIterator = paramMultimap.entries().iterator();
    while (localIterator.hasNext())
    {
      paramMultimap = (Map.Entry)localIterator.next();
      bool |= put(paramMultimap.getKey(), paramMultimap.getValue());
    }
    return bool;
  }
  
  public boolean putAll(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    boolean bool1;
    if (!paramIterable.iterator().hasNext()) {
      bool1 = false;
    }
    boolean bool2;
    for (;;)
    {
      return bool1;
      paramK = getOrCreateCollection(paramK);
      int i = paramK.size();
      bool2 = false;
      if (!(paramIterable instanceof Collection)) {
        break;
      }
      bool1 = paramK.addAll(Collections2.cast(paramIterable));
      this.totalSize += paramK.size() - i;
    }
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      bool1 = bool2;
      if (!paramIterable.hasNext()) {
        break;
      }
      bool2 |= paramK.add(paramIterable.next());
    }
  }
  
  public boolean remove(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    Collection localCollection = (Collection)this.map.get(paramObject1);
    boolean bool1;
    if (localCollection == null) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = localCollection.remove(paramObject2);
      bool1 = bool2;
      if (bool2)
      {
        this.totalSize -= 1;
        bool1 = bool2;
        if (localCollection.isEmpty())
        {
          this.map.remove(paramObject1);
          bool1 = bool2;
        }
      }
    }
  }
  
  public Collection<V> removeAll(@Nullable Object paramObject)
  {
    Collection localCollection = (Collection)this.map.remove(paramObject);
    paramObject = createCollection();
    if (localCollection != null)
    {
      ((Collection)paramObject).addAll(localCollection);
      this.totalSize -= localCollection.size();
      localCollection.clear();
    }
    return unmodifiableCollectionSubclass((Collection)paramObject);
  }
  
  public Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {}
    Collection localCollection;
    for (paramK = removeAll(paramK);; paramK = unmodifiableCollectionSubclass(localCollection))
    {
      return paramK;
      paramK = getOrCreateCollection(paramK);
      localCollection = createCollection();
      localCollection.addAll(paramK);
      this.totalSize -= paramK.size();
      paramK.clear();
      while (paramIterable.hasNext()) {
        if (paramK.add(paramIterable.next())) {
          this.totalSize += 1;
        }
      }
    }
  }
  
  final void setMap(Map<K, Collection<V>> paramMap)
  {
    this.map = paramMap;
    this.totalSize = 0;
    Iterator localIterator = paramMap.values().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Collection)localIterator.next();
      if (!paramMap.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.totalSize += paramMap.size();
        break;
      }
    }
  }
  
  public int size()
  {
    return this.totalSize;
  }
  
  public String toString()
  {
    return this.map.toString();
  }
  
  public Collection<V> values()
  {
    Collection localCollection = this.valuesCollection;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new Values(null);
      this.valuesCollection = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  private class AsMap
    extends AbstractMap<K, Collection<V>>
  {
    transient Set<Map.Entry<K, Collection<V>>> entrySet;
    final transient Map<K, Collection<V>> submap;
    
    static
    {
      JniLib.a(AsMap.class, 344);
    }
    
    AsMap()
    {
      Map localMap;
      this.submap = localMap;
    }
    
    public native boolean containsKey(Object paramObject);
    
    public native Set<Map.Entry<K, Collection<V>>> entrySet();
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native Collection<V> get(Object paramObject);
    
    public native int hashCode();
    
    public native Set<K> keySet();
    
    public native Collection<V> remove(Object paramObject);
    
    public native String toString();
    
    class AsMapEntries
      extends AbstractSet<Map.Entry<K, Collection<V>>>
    {
      static
      {
        JniLib.a(AsMapEntries.class, 342);
      }
      
      AsMapEntries() {}
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<K, Collection<V>>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
    
    class AsMapIterator
      implements Iterator<Map.Entry<K, Collection<V>>>
    {
      Collection<V> collection;
      final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = AbstractMultimap.AsMap.this.submap.entrySet().iterator();
      
      static
      {
        JniLib.a(AsMapIterator.class, 343);
      }
      
      AsMapIterator() {}
      
      public native boolean hasNext();
      
      public native Map.Entry<K, Collection<V>> next();
      
      public native void remove();
    }
  }
  
  private class Entries
    extends AbstractCollection<Map.Entry<K, V>>
  {
    static
    {
      JniLib.a(Entries.class, 345);
    }
    
    private Entries() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<K, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  private class EntryIterator
    implements Iterator<Map.Entry<K, V>>
  {
    Collection<V> collection;
    K key;
    final Iterator<Map.Entry<K, Collection<V>>> keyIterator = AbstractMultimap.this.map.entrySet().iterator();
    Iterator<V> valueIterator;
    
    static
    {
      JniLib.a(EntryIterator.class, 346);
    }
    
    EntryIterator()
    {
      if (this.keyIterator.hasNext()) {
        findValueIteratorAndKey();
      }
      for (;;)
      {
        return;
        this.valueIterator = Iterators.emptyModifiableIterator();
      }
    }
    
    native void findValueIteratorAndKey();
    
    public native boolean hasNext();
    
    public native Map.Entry<K, V> next();
    
    public native void remove();
  }
  
  private class EntrySet
    extends AbstractMultimap<K, V>.Entries
    implements Set<Map.Entry<K, V>>
  {
    static
    {
      JniLib.a(EntrySet.class, 347);
    }
    
    private EntrySet()
    {
      super(null);
    }
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
  }
  
  private class KeySet
    extends AbstractSet<K>
  {
    final Map<K, Collection<V>> subMap;
    
    static
    {
      JniLib.a(KeySet.class, 349);
    }
    
    KeySet()
    {
      Map localMap;
      this.subMap = localMap;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native Iterator<K> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native int size();
  }
  
  private class MultisetEntry
    extends Multisets.AbstractEntry<K>
  {
    final Map.Entry<K, Collection<V>> entry;
    
    static
    {
      JniLib.a(MultisetEntry.class, 350);
    }
    
    public MultisetEntry()
    {
      Map.Entry localEntry;
      this.entry = localEntry;
    }
    
    public native int getCount();
    
    public native K getElement();
  }
  
  private class MultisetEntryIterator
    implements Iterator<Multiset.Entry<K>>
  {
    final Iterator<Map.Entry<K, Collection<V>>> asMapIterator = AbstractMultimap.this.asMap().entrySet().iterator();
    
    static
    {
      JniLib.a(MultisetEntryIterator.class, 351);
    }
    
    private MultisetEntryIterator() {}
    
    public native boolean hasNext();
    
    public native Multiset.Entry<K> next();
    
    public native void remove();
  }
  
  private class MultisetKeyIterator
    implements Iterator<K>
  {
    final Iterator<Map.Entry<K, V>> entryIterator = AbstractMultimap.this.entries().iterator();
    
    static
    {
      JniLib.a(MultisetKeyIterator.class, 352);
    }
    
    private MultisetKeyIterator() {}
    
    public native boolean hasNext();
    
    public native K next();
    
    public native void remove();
  }
  
  private class MultisetView
    extends AbstractMultiset<K>
  {
    transient Set<Multiset.Entry<K>> entrySet;
    
    static
    {
      JniLib.a(MultisetView.class, 354);
    }
    
    private MultisetView() {}
    
    public native void clear();
    
    public native int count(Object paramObject);
    
    public native Set<K> elementSet();
    
    public native Set<Multiset.Entry<K>> entrySet();
    
    public native Iterator<K> iterator();
    
    public native int remove(Object paramObject, int paramInt);
    
    public native int size();
    
    private class EntrySet
      extends AbstractSet<Multiset.Entry<K>>
    {
      static
      {
        JniLib.a(EntrySet.class, 353);
      }
      
      private EntrySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Multiset.Entry<K>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
  }
  
  private class RandomAccessWrappedList
    extends AbstractMultimap.WrappedList
    implements RandomAccess
  {
    RandomAccessWrappedList(List<V> paramList, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
    {
      super(paramList, paramAbstractMultimap, localWrappedCollection);
    }
  }
  
  private class SortedAsMap
    extends AbstractMultimap<K, V>.AsMap
    implements SortedMap<K, Collection<V>>
  {
    SortedSet<K> sortedKeySet;
    
    static
    {
      JniLib.a(SortedAsMap.class, 357);
    }
    
    SortedAsMap()
    {
      super(localMap);
    }
    
    public native Comparator<? super K> comparator();
    
    public native K firstKey();
    
    public native SortedMap<K, Collection<V>> headMap(K paramK);
    
    public native SortedSet<K> keySet();
    
    public native K lastKey();
    
    native SortedMap<K, Collection<V>> sortedMap();
    
    public native SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2);
    
    public native SortedMap<K, Collection<V>> tailMap(K paramK);
  }
  
  private class SortedKeySet
    extends AbstractMultimap<K, V>.KeySet
    implements SortedSet<K>
  {
    static
    {
      JniLib.a(SortedKeySet.class, 358);
    }
    
    SortedKeySet()
    {
      super(localMap);
    }
    
    public native Comparator<? super K> comparator();
    
    public native K first();
    
    public native SortedSet<K> headSet(K paramK);
    
    public native K last();
    
    native SortedMap<K, Collection<V>> sortedMap();
    
    public native SortedSet<K> subSet(K paramK1, K paramK2);
    
    public native SortedSet<K> tailSet(K paramK);
  }
  
  private class ValueIterator
    implements Iterator<V>
  {
    final Iterator<Map.Entry<K, V>> entryIterator = AbstractMultimap.this.createEntryIterator();
    
    static
    {
      JniLib.a(ValueIterator.class, 359);
    }
    
    private ValueIterator() {}
    
    public native boolean hasNext();
    
    public native V next();
    
    public native void remove();
  }
  
  private class Values
    extends AbstractCollection<V>
  {
    static
    {
      JniLib.a(Values.class, 360);
    }
    
    private Values() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<V> iterator();
    
    public native int size();
  }
  
  private class WrappedCollection
    extends AbstractCollection<V>
  {
    final AbstractMultimap<K, V>.WrappedCollection ancestor;
    final Collection<V> ancestorDelegate;
    Collection<V> delegate;
    final K key;
    
    static
    {
      JniLib.a(WrappedCollection.class, 355);
    }
    
    WrappedCollection(Collection<V> paramCollection, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
    {
      this.key = paramCollection;
      this.delegate = paramAbstractMultimap;
      WrappedCollection localWrappedCollection;
      this.ancestor = localWrappedCollection;
      if (localWrappedCollection == null) {}
      for (this$1 = null;; this$1 = localWrappedCollection.getDelegate())
      {
        this.ancestorDelegate = AbstractMultimap.this;
        return;
      }
    }
    
    public native boolean add(V paramV);
    
    public native boolean addAll(Collection<? extends V> paramCollection);
    
    native void addToMap();
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native boolean equals(@Nullable Object paramObject);
    
    native AbstractMultimap<K, V>.WrappedCollection getAncestor();
    
    native Collection<V> getDelegate();
    
    native K getKey();
    
    public native int hashCode();
    
    public native Iterator<V> iterator();
    
    native void refreshIfEmpty();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    native void removeIfEmpty();
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
    
    public native String toString();
    
    class WrappedIterator
      implements Iterator<V>
    {
      final Iterator<V> delegateIterator;
      final Collection<V> originalDelegate = AbstractMultimap.WrappedCollection.this.delegate;
      
      static
      {
        JniLib.a(WrappedIterator.class, 361);
      }
      
      WrappedIterator()
      {
        this.delegateIterator = AbstractMultimap.this.iteratorOrListIterator(AbstractMultimap.WrappedCollection.this.delegate);
      }
      
      WrappedIterator()
      {
        Iterator localIterator;
        this.delegateIterator = localIterator;
      }
      
      native Iterator<V> getDelegateIterator();
      
      public native boolean hasNext();
      
      public native V next();
      
      public native void remove();
      
      native void validateIterator();
    }
  }
  
  private class WrappedList
    extends AbstractMultimap<K, V>.WrappedCollection
    implements List<V>
  {
    static
    {
      JniLib.a(WrappedList.class, 356);
    }
    
    WrappedList(List<V> paramList, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
    {
      super(paramList, paramAbstractMultimap, localWrappedCollection);
    }
    
    public native void add(int paramInt, V paramV);
    
    public native boolean addAll(int paramInt, Collection<? extends V> paramCollection);
    
    public native V get(int paramInt);
    
    native List<V> getListDelegate();
    
    public native int indexOf(Object paramObject);
    
    public native int lastIndexOf(Object paramObject);
    
    public native ListIterator<V> listIterator();
    
    public native ListIterator<V> listIterator(int paramInt);
    
    public native V remove(int paramInt);
    
    public native V set(int paramInt, V paramV);
    
    public native List<V> subList(int paramInt1, int paramInt2);
    
    private class WrappedListIterator
      extends AbstractMultimap<K, V>.WrappedCollection.WrappedIterator
      implements ListIterator<V>
    {
      static
      {
        JniLib.a(WrappedListIterator.class, 362);
      }
      
      WrappedListIterator()
      {
        super();
      }
      
      public WrappedListIterator(int paramInt)
      {
        super(AbstractMultimap.WrappedList.this.getListDelegate().listIterator(paramInt));
      }
      
      private native ListIterator<V> getDelegateListIterator();
      
      public native void add(V paramV);
      
      public native boolean hasPrevious();
      
      public native int nextIndex();
      
      public native V previous();
      
      public native int previousIndex();
      
      public native void set(V paramV);
    }
  }
  
  private class WrappedSet
    extends AbstractMultimap<K, V>.WrappedCollection
    implements Set<V>
  {
    WrappedSet(Set<V> paramSet)
    {
      super(paramSet, localCollection, null);
    }
  }
  
  private class WrappedSortedSet
    extends AbstractMultimap<K, V>.WrappedCollection
    implements SortedSet<V>
  {
    static
    {
      JniLib.a(WrappedSortedSet.class, 363);
    }
    
    WrappedSortedSet(SortedSet<V> paramSortedSet, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
    {
      super(paramSortedSet, paramAbstractMultimap, localWrappedCollection);
    }
    
    public native Comparator<? super V> comparator();
    
    public native V first();
    
    native SortedSet<V> getSortedSetDelegate();
    
    public native SortedSet<V> headSet(V paramV);
    
    public native V last();
    
    public native SortedSet<V> subSet(V paramV1, V paramV2);
    
    public native SortedSet<V> tailSet(V paramV);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */