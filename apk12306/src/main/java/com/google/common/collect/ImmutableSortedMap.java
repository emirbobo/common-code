package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableSortedMap<K, V>
  extends ImmutableSortedMapFauxverideShim<K, V>
  implements SortedMap<K, V>
{
  private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableList.of(), NATURAL_ORDER);
  private static final Comparator<Comparable> NATURAL_ORDER;
  private static final long serialVersionUID = 0L;
  private final transient Comparator<? super K> comparator;
  final transient ImmutableList<Map.Entry<K, V>> entries;
  private transient ImmutableSet<Map.Entry<K, V>> entrySet;
  final transient Function<Map.Entry<K, V>, K> keyFunction = new Function()
  {
    static
    {
      JniLib.a(2.class, 495);
    }
    
    public native K apply(Map.Entry<K, V> paramAnonymousEntry);
  };
  private transient ImmutableSortedSet<K> keySet;
  private transient ImmutableCollection<V> values;
  
  static
  {
    JniLib.a(ImmutableSortedMap.class, 504);
    NATURAL_ORDER = Ordering.natural();
  }
  
  ImmutableSortedMap(ImmutableList<Map.Entry<K, V>> paramImmutableList, Comparator<? super K> paramComparator)
  {
    this.entries = paramImmutableList;
    this.comparator = paramComparator;
  }
  
  public static native <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap);
  
  public static native <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator);
  
  private static native <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator);
  
  public static native <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> paramSortedMap);
  
  private native ImmutableSet<Map.Entry<K, V>> createEntrySet();
  
  private native ImmutableSortedSet<K> createKeySet();
  
  private native ImmutableSortedMap<K, V> createSubmap(int paramInt1, int paramInt2);
  
  private static native <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> paramComparator);
  
  private native int findSubmapIndex(K paramK);
  
  public static native <K extends Comparable<K>, V> Builder<K, V> naturalOrder();
  
  public static native <K, V> ImmutableSortedMap<K, V> of();
  
  public static native <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK, V paramV);
  
  public static native <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2);
  
  public static native <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3);
  
  public static native <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4);
  
  public static native <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5);
  
  public static native <K, V> Builder<K, V> orderedBy(Comparator<K> paramComparator);
  
  public static native <K extends Comparable<K>, V> Builder<K, V> reverseOrder();
  
  private static native <K, V> void sortEntries(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator);
  
  private static native <K, V> void validateEntries(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator);
  
  public native Comparator<? super K> comparator();
  
  public native boolean containsValue(@Nullable Object paramObject);
  
  public native ImmutableSet<Map.Entry<K, V>> entrySet();
  
  public native K firstKey();
  
  public native V get(@Nullable Object paramObject);
  
  public native ImmutableSortedMap<K, V> headMap(K paramK);
  
  native boolean isPartialView();
  
  public native ImmutableSortedSet<K> keySet();
  
  public native K lastKey();
  
  public native int size();
  
  public native ImmutableSortedMap<K, V> subMap(K paramK1, K paramK2);
  
  public native ImmutableSortedMap<K, V> tailMap(K paramK);
  
  native Comparator<Object> unsafeComparator();
  
  native UnmodifiableIterator<V> valueIterator();
  
  public native ImmutableCollection<V> values();
  
  native Object writeReplace();
  
  public static class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    private final Comparator<? super K> comparator;
    
    static
    {
      JniLib.a(Builder.class, 498);
    }
    
    public Builder(Comparator<? super K> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    public native ImmutableSortedMap<K, V> build();
    
    public native Builder<K, V> put(K paramK, V paramV);
    
    public native Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap);
  }
  
  private static class EntrySet<K, V>
    extends ImmutableSet<Map.Entry<K, V>>
  {
    final transient ImmutableSortedMap<K, V> map;
    
    static
    {
      JniLib.a(EntrySet.class, 499);
    }
    
    EntrySet(ImmutableSortedMap<K, V> paramImmutableSortedMap)
    {
      this.map = paramImmutableSortedMap;
    }
    
    public native boolean contains(Object paramObject);
    
    native boolean isPartialView();
    
    public native UnmodifiableIterator<Map.Entry<K, V>> iterator();
    
    public native int size();
    
    native Object writeReplace();
  }
  
  private static class EntrySetSerializedForm<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableSortedMap<K, V> map;
    
    static
    {
      JniLib.a(EntrySetSerializedForm.class, 500);
    }
    
    EntrySetSerializedForm(ImmutableSortedMap<K, V> paramImmutableSortedMap)
    {
      this.map = paramImmutableSortedMap;
    }
    
    native Object readResolve();
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    private final Comparator<Object> comparator;
    
    static
    {
      JniLib.a(SerializedForm.class, 501);
    }
    
    SerializedForm(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
    {
      super();
      this.comparator = paramImmutableSortedMap.comparator();
    }
    
    native Object readResolve();
  }
  
  private static class Values<V>
    extends ImmutableCollection<V>
  {
    private final ImmutableSortedMap<?, V> map;
    
    static
    {
      JniLib.a(Values.class, 502);
    }
    
    Values(ImmutableSortedMap<?, V> paramImmutableSortedMap)
    {
      this.map = paramImmutableSortedMap;
    }
    
    public native boolean contains(Object paramObject);
    
    native boolean isPartialView();
    
    public native UnmodifiableIterator<V> iterator();
    
    public native int size();
    
    native Object writeReplace();
  }
  
  private static class ValuesSerializedForm<V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableSortedMap<?, V> map;
    
    static
    {
      JniLib.a(ValuesSerializedForm.class, 503);
    }
    
    ValuesSerializedForm(ImmutableSortedMap<?, V> paramImmutableSortedMap)
    {
      this.map = paramImmutableSortedMap;
    }
    
    native Object readResolve();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */