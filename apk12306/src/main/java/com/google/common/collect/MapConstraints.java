package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class MapConstraints
{
  static
  {
    JniLib.a(MapConstraints.class, 608);
  }
  
  private static native <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Collection<V> checkValues(K paramK, Iterable<? extends V> paramIterable, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(Map.Entry<K, Collection<V>> paramEntry, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> BiMap<K, V> constrainedBiMap(BiMap<K, V> paramBiMap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Map.Entry<K, V> constrainedEntry(Map.Entry<K, V> paramEntry, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  private static native <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> Map<K, V> constrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> Multimap<K, V> constrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> SetMultimap<K, V> constrainedSetMultimap(SetMultimap<K, V> paramSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native <K, V> SortedSetMultimap<K, V> constrainedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint);
  
  public static native MapConstraint<Object, Object> notNull();
  
  static class ConstrainedAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>>
  {
    private final MapConstraint<? super K, ? super V> constraint;
    private final Set<Map.Entry<K, Collection<V>>> entries;
    
    static
    {
      JniLib.a(ConstrainedAsMapEntries.class, 593);
    }
    
    ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramSet;
      this.constraint = paramMapConstraint;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Set<Map.Entry<K, Collection<V>>> delegate();
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native Iterator<Map.Entry<K, Collection<V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class ConstrainedAsMapValues<K, V>
    extends ForwardingCollection<Collection<V>>
  {
    final Collection<Collection<V>> delegate;
    final Set<Map.Entry<K, Collection<V>>> entrySet;
    
    static
    {
      JniLib.a(ConstrainedAsMapValues.class, 595);
    }
    
    ConstrainedAsMapValues(Collection<Collection<V>> paramCollection, Set<Map.Entry<K, Collection<V>>> paramSet)
    {
      this.delegate = paramCollection;
      this.entrySet = paramSet;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Collection<Collection<V>> delegate();
    
    public native Iterator<Collection<V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  private static class ConstrainedBiMap<K, V>
    extends MapConstraints.ConstrainedMap<K, V>
    implements BiMap<K, V>
  {
    volatile BiMap<V, K> inverse;
    
    static
    {
      JniLib.a(ConstrainedBiMap.class, 597);
    }
    
    ConstrainedBiMap(BiMap<K, V> paramBiMap, @Nullable BiMap<V, K> paramBiMap1, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
      this.inverse = paramBiMap1;
    }
    
    protected native BiMap<K, V> delegate();
    
    public native V forcePut(K paramK, V paramV);
    
    public native BiMap<V, K> inverse();
    
    public native Set<V> values();
  }
  
  private static class ConstrainedEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    final MapConstraint<? super K, ? super V> constraint;
    final Collection<Map.Entry<K, V>> entries;
    
    static
    {
      JniLib.a(ConstrainedEntries.class, 599);
    }
    
    ConstrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramCollection;
      this.constraint = paramMapConstraint;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    protected native Collection<Map.Entry<K, V>> delegate();
    
    public native Iterator<Map.Entry<K, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
  }
  
  static class ConstrainedEntrySet<K, V>
    extends MapConstraints.ConstrainedEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    static
    {
      JniLib.a(ConstrainedEntrySet.class, 600);
    }
    
    ConstrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
  }
  
  private static class ConstrainedListMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    static
    {
      JniLib.a(ConstrainedListMultimap.class, 602);
    }
    
    ConstrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public native List<V> get(K paramK);
    
    public native List<V> removeAll(Object paramObject);
    
    public native List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  static class ConstrainedMap<K, V>
    extends ForwardingMap<K, V>
  {
    final MapConstraint<? super K, ? super V> constraint;
    private final Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    
    static
    {
      JniLib.a(ConstrainedMap.class, 596);
    }
    
    ConstrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Map)Preconditions.checkNotNull(paramMap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    protected native Map<K, V> delegate();
    
    public native Set<Map.Entry<K, V>> entrySet();
    
    public native V put(K paramK, V paramV);
    
    public native void putAll(Map<? extends K, ? extends V> paramMap);
  }
  
  private static class ConstrainedMultimap<K, V>
    extends ForwardingMultimap<K, V>
  {
    transient Map<K, Collection<V>> asMap;
    final MapConstraint<? super K, ? super V> constraint;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    
    static
    {
      JniLib.a(ConstrainedMultimap.class, 601);
    }
    
    public ConstrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    public native Map<K, Collection<V>> asMap();
    
    protected native Multimap<K, V> delegate();
    
    public native Collection<Map.Entry<K, V>> entries();
    
    public native Collection<V> get(K paramK);
    
    public native boolean put(K paramK, V paramV);
    
    public native boolean putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native boolean putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public native Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  private static class ConstrainedSetMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements SetMultimap<K, V>
  {
    static
    {
      JniLib.a(ConstrainedSetMultimap.class, 605);
    }
    
    ConstrainedSetMultimap(SetMultimap<K, V> paramSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public native Set<Map.Entry<K, V>> entries();
    
    public native Set<V> get(K paramK);
    
    public native Set<V> removeAll(Object paramObject);
    
    public native Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  }
  
  private static class ConstrainedSortedSetMultimap<K, V>
    extends MapConstraints.ConstrainedSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    static
    {
      JniLib.a(ConstrainedSortedSetMultimap.class, 606);
    }
    
    ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> paramSortedSetMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public native SortedSet<V> get(K paramK);
    
    public native SortedSet<V> removeAll(Object paramObject);
    
    public native SortedSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
    
    public native Comparator<? super V> valueComparator();
  }
  
  private static class InverseConstraint<K, V>
    implements MapConstraint<K, V>
  {
    final MapConstraint<? super V, ? super K> constraint;
    
    static
    {
      JniLib.a(InverseConstraint.class, 607);
    }
    
    public InverseConstraint(MapConstraint<? super V, ? super K> paramMapConstraint)
    {
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    public native void checkKeyValue(K paramK, V paramV);
  }
  
  private static enum NotNullMapConstraint
    implements MapConstraint<Object, Object>
  {
    INSTANCE;
    
    private NotNullMapConstraint() {}
    
    public void checkKeyValue(Object paramObject1, Object paramObject2)
    {
      Preconditions.checkNotNull(paramObject1);
      Preconditions.checkNotNull(paramObject2);
    }
    
    public String toString()
    {
      return "Not null";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */