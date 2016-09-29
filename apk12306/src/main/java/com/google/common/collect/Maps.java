package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Maps
{
  static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
  
  static
  {
    JniLib.a(Maps.class, 642);
  }
  
  static native int capacity(int paramInt);
  
  static native <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject);
  
  static native boolean containsKeyImpl(Map<?, ?> paramMap, @Nullable Object paramObject);
  
  static native boolean containsValueImpl(Map<?, ?> paramMap, @Nullable Object paramObject);
  
  public static native <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2);
  
  static native <K, V> Set<Map.Entry<K, V>> entrySetImpl(Map<K, V> paramMap, Supplier<Iterator<Map.Entry<K, V>>> paramSupplier);
  
  static native boolean equalsImpl(Map<?, ?> paramMap, Object paramObject);
  
  public static native <K, V> Map<K, V> filterEntries(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate);
  
  private static native <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> paramAbstractFilteredMap, Predicate<? super Map.Entry<K, V>> paramPredicate);
  
  public static native <K, V> Map<K, V> filterKeys(Map<K, V> paramMap, Predicate<? super K> paramPredicate);
  
  public static native <K, V> Map<K, V> filterValues(Map<K, V> paramMap, Predicate<? super V> paramPredicate);
  
  @GwtIncompatible("java.util.Properties")
  public static native ImmutableMap<String, String> fromProperties(Properties paramProperties);
  
  static native int hashCodeImpl(Map<?, ?> paramMap);
  
  @GwtCompatible(serializable=true)
  public static native <K, V> Map.Entry<K, V> immutableEntry(@Nullable K paramK, @Nullable V paramV);
  
  static native <K, V> Set<K> keySetImpl(Map<K, V> paramMap);
  
  private static native <K, V> MapDifference<K, V> mapDifference(boolean paramBoolean, Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap);
  
  public static native <K, V> ConcurrentMap<K, V> newConcurrentMap();
  
  public static native <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> paramClass);
  
  public static native <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> paramMap);
  
  public static native <K, V> HashMap<K, V> newHashMap();
  
  public static native <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> paramMap);
  
  public static native <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt);
  
  public static native <K, V> IdentityHashMap<K, V> newIdentityHashMap();
  
  public static native <K, V> LinkedHashMap<K, V> newLinkedHashMap();
  
  public static native <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> paramMap);
  
  public static native <K extends Comparable, V> TreeMap<K, V> newTreeMap();
  
  public static native <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> paramComparator);
  
  public static native <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> paramSortedMap);
  
  static native <K, V> void putAllImpl(Map<K, V> paramMap, Map<? extends K, ? extends V> paramMap1);
  
  static native <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> paramCollection, Object paramObject);
  
  static native boolean safeContainsKey(Map<?, ?> paramMap, Object paramObject);
  
  static native <V> V safeGet(Map<?, V> paramMap, Object paramObject);
  
  public static native <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> paramBiMap);
  
  static native String toStringImpl(Map<?, ?> paramMap);
  
  @Beta
  public static native <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> paramMap, EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer);
  
  public static native <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> paramMap, Function<? super V1, V2> paramFunction);
  
  public static native <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> paramIterable, Function<? super V, K> paramFunction);
  
  public static native <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap);
  
  static native <K, V> Map.Entry<K, V> unmodifiableEntry(Map.Entry<K, V> paramEntry);
  
  static native <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet);
  
  static native <K, V> Collection<V> valuesImpl(Map<K, V> paramMap);
  
  private static abstract class AbstractFilteredMap<K, V>
    extends AbstractMap<K, V>
  {
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Map<K, V> unfiltered;
    Collection<V> values;
    
    AbstractFilteredMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      this.unfiltered = paramMap;
      this.predicate = paramPredicate;
    }
    
    boolean apply(Object paramObject, V paramV)
    {
      return this.predicate.apply(Maps.immutableEntry(paramObject, paramV));
    }
    
    public boolean containsKey(Object paramObject)
    {
      if ((this.unfiltered.containsKey(paramObject)) && (apply(paramObject, this.unfiltered.get(paramObject)))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public V get(Object paramObject)
    {
      Object localObject = this.unfiltered.get(paramObject);
      if ((localObject != null) && (apply(paramObject, localObject))) {}
      for (paramObject = localObject;; paramObject = null) {
        return (V)paramObject;
      }
    }
    
    public boolean isEmpty()
    {
      return entrySet().isEmpty();
    }
    
    public V put(K paramK, V paramV)
    {
      Preconditions.checkArgument(apply(paramK, paramV));
      return (V)this.unfiltered.put(paramK, paramV);
    }
    
    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Preconditions.checkArgument(apply(localEntry.getKey(), localEntry.getValue()));
      }
      this.unfiltered.putAll(paramMap);
    }
    
    public V remove(Object paramObject)
    {
      if (containsKey(paramObject)) {}
      for (paramObject = this.unfiltered.remove(paramObject);; paramObject = null) {
        return (V)paramObject;
      }
    }
    
    public Collection<V> values()
    {
      Collection localCollection = this.values;
      Object localObject = localCollection;
      if (localCollection == null)
      {
        localObject = new Values();
        this.values = ((Collection)localObject);
      }
      return (Collection<V>)localObject;
    }
    
    class Values
      extends AbstractCollection<V>
    {
      static
      {
        JniLib.a(Values.class, 620);
      }
      
      Values() {}
      
      public native void clear();
      
      public native boolean isEmpty();
      
      public native Iterator<V> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
      
      public native Object[] toArray();
      
      public native <T> T[] toArray(T[] paramArrayOfT);
    }
  }
  
  private static final class AbstractMapWrapper<K, V>
    extends Maps.ImprovedAbstractMap<K, V>
  {
    private final Map<K, V> map;
    
    static
    {
      JniLib.a(AbstractMapWrapper.class, 621);
    }
    
    AbstractMapWrapper(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }
    
    public native void clear();
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    protected native Set<Map.Entry<K, V>> createEntrySet();
    
    public native boolean isEmpty();
    
    public native V remove(Object paramObject);
    
    public native int size();
  }
  
  private static class EntrySetImpl<K, V>
    extends AbstractSet<Map.Entry<K, V>>
  {
    private final Supplier<Iterator<Map.Entry<K, V>>> entryIteratorSupplier;
    private final Map<K, V> map;
    
    static
    {
      JniLib.a(EntrySetImpl.class, 622);
    }
    
    EntrySetImpl(Map<K, V> paramMap, Supplier<Iterator<Map.Entry<K, V>>> paramSupplier)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
      this.entryIteratorSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Iterator<Map.Entry<K, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  @Beta
  public static abstract interface EntryTransformer<K, V1, V2>
  {
    public abstract V2 transformEntry(@Nullable K paramK, @Nullable V1 paramV1);
  }
  
  static class FilteredEntryMap<K, V>
    extends Maps.AbstractFilteredMap<K, V>
  {
    Set<Map.Entry<K, V>> entrySet;
    final Set<Map.Entry<K, V>> filteredEntrySet = Sets.filter(paramMap.entrySet(), this.predicate);
    Set<K> keySet;
    
    static
    {
      JniLib.a(FilteredEntryMap.class, 628);
    }
    
    FilteredEntryMap(Map<K, V> paramMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public native Set<Map.Entry<K, V>> entrySet();
    
    public native Set<K> keySet();
    
    private class EntrySet
      extends ForwardingSet<Map.Entry<K, V>>
    {
      static
      {
        JniLib.a(EntrySet.class, 625);
      }
      
      private EntrySet() {}
      
      protected native Set<Map.Entry<K, V>> delegate();
      
      public native Iterator<Map.Entry<K, V>> iterator();
    }
    
    private class KeySet
      extends AbstractSet<K>
    {
      static
      {
        JniLib.a(KeySet.class, 627);
      }
      
      private KeySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<K> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native boolean removeAll(Collection<?> paramCollection);
      
      public native boolean retainAll(Collection<?> paramCollection);
      
      public native int size();
      
      public native Object[] toArray();
      
      public native <T> T[] toArray(T[] paramArrayOfT);
    }
  }
  
  private static class FilteredKeyMap<K, V>
    extends Maps.AbstractFilteredMap<K, V>
  {
    Set<Map.Entry<K, V>> entrySet;
    Predicate<? super K> keyPredicate;
    Set<K> keySet;
    
    static
    {
      JniLib.a(FilteredKeyMap.class, 629);
    }
    
    FilteredKeyMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<Map.Entry<K, V>> paramPredicate1)
    {
      super(paramPredicate1);
      this.keyPredicate = paramPredicate;
    }
    
    public native boolean containsKey(Object paramObject);
    
    public native Set<Map.Entry<K, V>> entrySet();
    
    public native Set<K> keySet();
  }
  
  @GwtCompatible
  static abstract class ImprovedAbstractMap<K, V>
    extends AbstractMap<K, V>
  {
    private Set<Map.Entry<K, V>> entrySet;
    private Set<K> keySet;
    private Collection<V> values;
    
    protected abstract Set<Map.Entry<K, V>> createEntrySet();
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet2 = this.entrySet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = createEntrySet();
        this.entrySet = localSet1;
      }
      return localSet1;
    }
    
    public boolean isEmpty()
    {
      return entrySet().isEmpty();
    }
    
    public Set<K> keySet()
    {
      Set localSet = this.keySet;
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new ForwardingSet()
        {
          static
          {
            JniLib.a(1.class, 630);
          }
          
          protected native Set<K> delegate();
          
          public native boolean isEmpty();
          
          public native boolean remove(Object paramAnonymousObject);
        };
        this.keySet = ((Set)localObject);
      }
      return (Set<K>)localObject;
    }
    
    public Collection<V> values()
    {
      Collection localCollection = this.values;
      Object localObject = localCollection;
      if (localCollection == null)
      {
        localObject = new ForwardingCollection()
        {
          static
          {
            JniLib.a(2.class, 631);
          }
          
          protected native Collection<V> delegate();
          
          public native boolean isEmpty();
        };
        this.values = ((Collection)localObject);
      }
      return (Collection<V>)localObject;
    }
  }
  
  static class MapDifferenceImpl<K, V>
    implements MapDifference<K, V>
  {
    final boolean areEqual;
    final Map<K, MapDifference.ValueDifference<V>> differences;
    final Map<K, V> onBoth;
    final Map<K, V> onlyOnLeft;
    final Map<K, V> onlyOnRight;
    
    static
    {
      JniLib.a(MapDifferenceImpl.class, 632);
    }
    
    MapDifferenceImpl(boolean paramBoolean, Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap)
    {
      this.areEqual = paramBoolean;
      this.onlyOnLeft = paramMap1;
      this.onlyOnRight = paramMap2;
      this.onBoth = paramMap3;
      this.differences = paramMap;
    }
    
    public native boolean areEqual();
    
    public native Map<K, MapDifference.ValueDifference<V>> entriesDiffering();
    
    public native Map<K, V> entriesInCommon();
    
    public native Map<K, V> entriesOnlyOnLeft();
    
    public native Map<K, V> entriesOnlyOnRight();
    
    public native boolean equals(Object paramObject);
    
    public native int hashCode();
    
    public native String toString();
  }
  
  static class TransformedEntriesMap<K, V1, V2>
    extends AbstractMap<K, V2>
  {
    TransformedEntriesMap<K, V1, V2>.EntrySet entrySet;
    final Map<K, V1> fromMap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    static
    {
      JniLib.a(TransformedEntriesMap.class, 636);
    }
    
    TransformedEntriesMap(Map<K, V1> paramMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      this.fromMap = ((Map)Preconditions.checkNotNull(paramMap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
    }
    
    public native void clear();
    
    public native boolean containsKey(Object paramObject);
    
    public native Set<Map.Entry<K, V2>> entrySet();
    
    public native V2 get(Object paramObject);
    
    public native V2 remove(Object paramObject);
    
    public native int size();
    
    class EntrySet
      extends AbstractSet<Map.Entry<K, V2>>
    {
      static
      {
        JniLib.a(EntrySet.class, 635);
      }
      
      EntrySet() {}
      
      public native void clear();
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<K, V2>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
  }
  
  private static class UnmodifiableBiMap<K, V>
    extends ForwardingMap<K, V>
    implements BiMap<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    final BiMap<? extends K, ? extends V> delegate;
    transient BiMap<V, K> inverse;
    final Map<K, V> unmodifiableMap;
    transient Set<V> values;
    
    static
    {
      JniLib.a(UnmodifiableBiMap.class, 637);
    }
    
    UnmodifiableBiMap(BiMap<? extends K, ? extends V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1)
    {
      this.unmodifiableMap = Collections.unmodifiableMap(paramBiMap);
      this.delegate = paramBiMap;
      this.inverse = paramBiMap1;
    }
    
    protected native Map<K, V> delegate();
    
    public native V forcePut(K paramK, V paramV);
    
    public native BiMap<V, K> inverse();
    
    public native Set<V> values();
  }
  
  static class UnmodifiableEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    private final Collection<Map.Entry<K, V>> entries;
    
    static
    {
      JniLib.a(UnmodifiableEntries.class, 639);
    }
    
    UnmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection)
    {
      this.entries = paramCollection;
    }
    
    public native boolean add(Map.Entry<K, V> paramEntry);
    
    public native boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection);
    
    public native void clear();
    
    protected native Collection<Map.Entry<K, V>> delegate();
    
    public native Iterator<Map.Entry<K, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  static class UnmodifiableEntrySet<K, V>
    extends Maps.UnmodifiableEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    static
    {
      JniLib.a(UnmodifiableEntrySet.class, 640);
    }
    
    UnmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet)
    {
      super();
    }
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
  }
  
  static class ValueDifferenceImpl<V>
    implements MapDifference.ValueDifference<V>
  {
    private final V left;
    private final V right;
    
    static
    {
      JniLib.a(ValueDifferenceImpl.class, 641);
    }
    
    ValueDifferenceImpl(@Nullable V paramV1, @Nullable V paramV2)
    {
      this.left = paramV1;
      this.right = paramV2;
    }
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native V leftValue();
    
    public native V rightValue();
    
    public native String toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */