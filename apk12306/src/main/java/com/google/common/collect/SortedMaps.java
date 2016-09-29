package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class SortedMaps
{
  static
  {
    JniLib.a(SortedMaps.class, 744);
  }
  
  public static native <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> paramSortedMap, Map<? extends K, ? extends V> paramMap);
  
  @GwtIncompatible("untested")
  public static native <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate);
  
  private static native <K, V> SortedMap<K, V> filterFiltered(FilteredSortedMap<K, V> paramFilteredSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate);
  
  @GwtIncompatible("untested")
  public static native <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> paramSortedMap, Predicate<? super K> paramPredicate);
  
  @GwtIncompatible("untested")
  public static native <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> paramSortedMap, Predicate<? super V> paramPredicate);
  
  static native <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> paramComparator);
  
  private static native <K, V> SortedMapDifference<K, V> sortedMapDifference(boolean paramBoolean, SortedMap<K, V> paramSortedMap1, SortedMap<K, V> paramSortedMap2, SortedMap<K, V> paramSortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> paramSortedMap);
  
  public static native <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> paramSortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer);
  
  public static native <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> paramSortedMap, Function<? super V1, V2> paramFunction);
  
  private static class FilteredSortedMap<K, V>
    extends Maps.FilteredEntryMap<K, V>
    implements SortedMap<K, V>
  {
    static
    {
      JniLib.a(FilteredSortedMap.class, 741);
    }
    
    FilteredSortedMap(SortedMap<K, V> paramSortedMap, Predicate<? super Map.Entry<K, V>> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public native Comparator<? super K> comparator();
    
    public native K firstKey();
    
    public native SortedMap<K, V> headMap(K paramK);
    
    public native K lastKey();
    
    native SortedMap<K, V> sortedMap();
    
    public native SortedMap<K, V> subMap(K paramK1, K paramK2);
    
    public native SortedMap<K, V> tailMap(K paramK);
  }
  
  static class SortedMapDifferenceImpl<K, V>
    extends Maps.MapDifferenceImpl<K, V>
    implements SortedMapDifference<K, V>
  {
    static
    {
      JniLib.a(SortedMapDifferenceImpl.class, 742);
    }
    
    SortedMapDifferenceImpl(boolean paramBoolean, SortedMap<K, V> paramSortedMap1, SortedMap<K, V> paramSortedMap2, SortedMap<K, V> paramSortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> paramSortedMap)
    {
      super(paramSortedMap1, paramSortedMap2, paramSortedMap3, paramSortedMap);
    }
    
    public native SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();
    
    public native SortedMap<K, V> entriesInCommon();
    
    public native SortedMap<K, V> entriesOnlyOnLeft();
    
    public native SortedMap<K, V> entriesOnlyOnRight();
  }
  
  static class TransformedEntriesSortedMap<K, V1, V2>
    extends Maps.TransformedEntriesMap<K, V1, V2>
    implements SortedMap<K, V2>
  {
    static
    {
      JniLib.a(TransformedEntriesSortedMap.class, 743);
    }
    
    TransformedEntriesSortedMap(SortedMap<K, V1> paramSortedMap, Maps.EntryTransformer<? super K, ? super V1, V2> paramEntryTransformer)
    {
      super(paramEntryTransformer);
    }
    
    public native Comparator<? super K> comparator();
    
    public native K firstKey();
    
    protected native SortedMap<K, V1> fromMap();
    
    public native SortedMap<K, V2> headMap(K paramK);
    
    public native K lastKey();
    
    public native SortedMap<K, V2> subMap(K paramK1, K paramK2);
    
    public native SortedMap<K, V2> tailMap(K paramK);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedMaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */