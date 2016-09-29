package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Multimaps
{
  static
  {
    JniLib.a(Multimaps.class, 679);
  }
  
  public static native <K, V> SetMultimap<K, V> forMap(Map<K, V> paramMap);
  
  public static native <K, V> ImmutableListMultimap<K, V> index(Iterable<V> paramIterable, Function<? super V, K> paramFunction);
  
  public static native <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> paramMultimap, M paramM);
  
  public static native <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends List<V>> paramSupplier);
  
  public static native <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier);
  
  public static native <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier);
  
  public static native <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier);
  
  public static native <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> paramListMultimap);
  
  public static native <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> paramMultimap);
  
  public static native <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> paramSetMultimap);
  
  public static native <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap);
  
  @Beta
  @GwtIncompatible("untested")
  public static native <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer);
  
  @Beta
  @GwtIncompatible("untested")
  public static native <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer);
  
  @Beta
  @GwtIncompatible("untested")
  public static native <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> paramListMultimap, Function<? super V1, V2> paramFunction);
  
  @Beta
  @GwtIncompatible("untested")
  public static native <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> paramMultimap, Function<? super V1, V2> paramFunction);
  
  private static native <K, V> Set<Map.Entry<K, Collection<V>>> unmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet);
  
  private static native <K, V> Map.Entry<K, Collection<V>> unmodifiableAsMapEntry(Map.Entry<K, Collection<V>> paramEntry);
  
  private static native <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> paramCollection);
  
  public static native <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> paramListMultimap);
  
  public static native <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> paramMultimap);
  
  public static native <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap);
  
  public static native <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap);
  
  private static native <V> Collection<V> unmodifiableValueCollection(Collection<V> paramCollection);
  
  private static class CustomListMultimap<K, V>
    extends AbstractListMultimap<K, V>
  {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends List<V>> factory;
    
    static
    {
      JniLib.a(CustomListMultimap.class, 650);
    }
    
    CustomListMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends List<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    protected native List<V> createCollection();
  }
  
  private static class CustomMultimap<K, V>
    extends AbstractMultimap<K, V>
  {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends Collection<V>> factory;
    
    static
    {
      JniLib.a(CustomMultimap.class, 651);
    }
    
    CustomMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Collection<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    protected native Collection<V> createCollection();
  }
  
  private static class CustomSetMultimap<K, V>
    extends AbstractSetMultimap<K, V>
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends Set<V>> factory;
    
    static
    {
      JniLib.a(CustomSetMultimap.class, 652);
    }
    
    CustomSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends Set<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    protected native Set<V> createCollection();
  }
  
  private static class CustomSortedSetMultimap<K, V>
    extends AbstractSortedSetMultimap<K, V>
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    transient Supplier<? extends SortedSet<V>> factory;
    transient Comparator<? super V> valueComparator;
    
    static
    {
      JniLib.a(CustomSortedSetMultimap.class, 653);
    }
    
    CustomSortedSetMultimap(Map<K, Collection<V>> paramMap, Supplier<? extends SortedSet<V>> paramSupplier)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(paramSupplier));
      this.valueComparator = ((SortedSet)paramSupplier.get()).comparator();
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private native void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException;
    
    protected native SortedSet<V> createCollection();
    
    public native Comparator<? super V> valueComparator();
  }
  
  private static class MapMultimap<K, V>
    implements SetMultimap<K, V>, Serializable
  {
    private static final Joiner.MapJoiner JOINER = Joiner.on("], ").withKeyValueSeparator("=[").useForNull("null");
    private static final long serialVersionUID = 7845222491160860175L;
    transient Map<K, Collection<V>> asMap;
    final Map<K, V> map;
    
    static
    {
      JniLib.a(MapMultimap.class, 660);
    }
    
    MapMultimap(Map<K, V> paramMap)
    {
      this.map = ((Map)Preconditions.checkNotNull(paramMap));
    }
    
    public native Map<K, Collection<V>> asMap();
    
    public native void clear();
    
    public native boolean containsEntry(Object paramObject1, Object paramObject2);
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    public native Set<Map.Entry<K, V>> entries();
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native Set<V> get(K paramK);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Set<K> keySet();
    
    public native Multiset<K> keys();
    
    public native boolean put(K paramK, V paramV);
    
    public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public native boolean remove(Object paramObject1, Object paramObject2);
    
    public native Set<V> removeAll(Object paramObject);
    
    public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native int size();
    
    public native String toString();
    
    public native Collection<V> values();
    
    class AsMap
      extends Maps.ImprovedAbstractMap<K, Collection<V>>
    {
      static
      {
        JniLib.a(AsMap.class, 656);
      }
      
      AsMap() {}
      
      public native boolean containsKey(Object paramObject);
      
      protected native Set<Map.Entry<K, Collection<V>>> createEntrySet();
      
      public native Collection<V> get(Object paramObject);
      
      public native Collection<V> remove(Object paramObject);
    }
    
    class AsMapEntries
      extends AbstractSet<Map.Entry<K, Collection<V>>>
    {
      static
      {
        JniLib.a(AsMapEntries.class, 659);
      }
      
      AsMapEntries() {}
      
      public native boolean contains(Object paramObject);
      
      public native Iterator<Map.Entry<K, Collection<V>>> iterator();
      
      public native boolean remove(Object paramObject);
      
      public native int size();
    }
  }
  
  @GwtIncompatible("untested")
  private static final class TransformedEntriesListMultimap<K, V1, V2>
    extends Multimaps.TransformedEntriesMultimap<K, V1, V2>
    implements ListMultimap<K, V2>
  {
    static
    {
      JniLib.a(TransformedEntriesListMultimap.class, 663);
    }
    
    TransformedEntriesListMultimap(ListMultimap<K, V1> paramListMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      super(paramEntryTransformer);
    }
    
    public native List<V2> get(K paramK);
    
    public native List<V2> removeAll(Object paramObject);
    
    public native List<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable);
    
    native List<V2> transform(K paramK, Collection<V1> paramCollection);
  }
  
  @GwtIncompatible("untested")
  private static class TransformedEntriesMultimap<K, V1, V2>
    implements Multimap<K, V2>
  {
    private transient Map<K, Collection<V2>> asMap;
    private transient Collection<Map.Entry<K, V2>> entries;
    final Multimap<K, V1> fromMultimap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    private transient Collection<V2> values;
    
    static
    {
      JniLib.a(TransformedEntriesMultimap.class, 662);
    }
    
    TransformedEntriesMultimap(Multimap<K, V1> paramMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      this.fromMultimap = ((Multimap)Preconditions.checkNotNull(paramMultimap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(paramEntryTransformer));
    }
    
    public native Map<K, Collection<V2>> asMap();
    
    public native void clear();
    
    public native boolean containsEntry(Object paramObject1, Object paramObject2);
    
    public native boolean containsKey(Object paramObject);
    
    public native boolean containsValue(Object paramObject);
    
    public native Collection<Map.Entry<K, V2>> entries();
    
    public native boolean equals(Object paramObject);
    
    public native Collection<V2> get(K paramK);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Set<K> keySet();
    
    public native Multiset<K> keys();
    
    public native boolean put(K paramK, V2 paramV2);
    
    public native boolean putAll(Multimap<? extends K, ? extends V2> paramMultimap);
    
    public native boolean putAll(K paramK, Iterable<? extends V2> paramIterable);
    
    public native boolean remove(Object paramObject1, Object paramObject2);
    
    public native Collection<V2> removeAll(Object paramObject);
    
    public native Collection<V2> replaceValues(K paramK, Iterable<? extends V2> paramIterable);
    
    public native int size();
    
    public native String toString();
    
    native Collection<V2> transform(K paramK, Collection<V1> paramCollection);
    
    public native Collection<V2> values();
    
    private class TransformedEntries
      extends Collections2.TransformedCollection<Map.Entry<K, V1>, Map.Entry<K, V2>>
    {
      static
      {
        JniLib.a(TransformedEntries.class, 669);
      }
      
      TransformedEntries()
      {
        super(new Function()
        {
          static
          {
            JniLib.a(1.class, 668);
          }
          
          public native Map.Entry<K, V2> apply(Map.Entry<K, V1> paramAnonymousEntry);
        });
      }
      
      public native boolean contains(Object paramObject);
      
      public native boolean remove(Object paramObject);
    }
  }
  
  static class UnmodifiableAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>>
  {
    private final Set<Map.Entry<K, Collection<V>>> delegate;
    
    static
    {
      JniLib.a(UnmodifiableAsMapEntries.class, 671);
    }
    
    UnmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet)
    {
      this.delegate = paramSet;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Set<Map.Entry<K, Collection<V>>> delegate();
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class UnmodifiableAsMapValues<V>
    extends ForwardingCollection<Collection<V>>
  {
    final Collection<Collection<V>> delegate;
    
    static
    {
      JniLib.a(UnmodifiableAsMapValues.class, 673);
    }
    
    UnmodifiableAsMapValues(Collection<Collection<V>> paramCollection)
    {
      this.delegate = Collections.unmodifiableCollection(paramCollection);
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Collection<Collection<V>> delegate();
    
    public native Iterator<Collection<V>> iterator();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class UnmodifiableListMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements ListMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(UnmodifiableListMultimap.class, 675);
    }
    
    UnmodifiableListMultimap(ListMultimap<K, V> paramListMultimap)
    {
      super();
    }
    
    public native ListMultimap<K, V> delegate();
    
    public native List<V> get(K paramK);
    
    public native List<V> removeAll(Object paramObject);
    
    public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  private static class UnmodifiableMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    transient Set<K> keySet;
    transient Multiset<K> keys;
    transient Map<K, Collection<V>> map;
    transient Collection<V> values;
    
    static
    {
      JniLib.a(UnmodifiableMultimap.class, 674);
    }
    
    UnmodifiableMultimap(Multimap<K, V> paramMultimap)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    }
    
    public native Map<K, Collection<V>> asMap();
    
    public native void clear();
    
    protected native Multimap<K, V> delegate();
    
    public native Collection<Map.Entry<K, V>> entries();
    
    public native Collection<V> get(K paramK);
    
    public native Set<K> keySet();
    
    public native Multiset<K> keys();
    
    public native boolean put(K paramK, V paramV);
    
    public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public native boolean remove(Object paramObject1, Object paramObject2);
    
    public native Collection<V> removeAll(Object paramObject);
    
    public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native Collection<V> values();
  }
  
  private static class UnmodifiableSetMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements SetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(UnmodifiableSetMultimap.class, 677);
    }
    
    UnmodifiableSetMultimap(SetMultimap<K, V> paramSetMultimap)
    {
      super();
    }
    
    public native SetMultimap<K, V> delegate();
    
    public native Set<Map.Entry<K, V>> entries();
    
    public native Set<V> get(K paramK);
    
    public native Set<V> removeAll(Object paramObject);
    
    public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  private static class UnmodifiableSortedSetMultimap<K, V>
    extends Multimaps.UnmodifiableSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(UnmodifiableSortedSetMultimap.class, 678);
    }
    
    UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap)
    {
      super();
    }
    
    public native SortedSetMultimap<K, V> delegate();
    
    public native SortedSet<V> get(K paramK);
    
    public native SortedSet<V> removeAll(Object paramObject);
    
    public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native Comparator<? super V> valueComparator();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */