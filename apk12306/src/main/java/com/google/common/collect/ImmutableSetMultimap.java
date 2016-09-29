package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableSetMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements SetMultimap<K, V>
{
  @GwtIncompatible("not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  private final transient ImmutableSortedSet<V> emptySet;
  private transient ImmutableSet<Map.Entry<K, V>> entries;
  
  static
  {
    JniLib.a(ImmutableSetMultimap.class, 436);
  }
  
  ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> paramImmutableMap, int paramInt, @Nullable Comparator<? super V> paramComparator)
  {
    super(paramImmutableMap, paramInt);
    if (paramComparator == null) {}
    for (paramImmutableMap = null;; paramImmutableMap = ImmutableSortedSet.emptySet(paramComparator))
    {
      this.emptySet = paramImmutableMap;
      return;
    }
  }
  
  public static native <K, V> Builder<K, V> builder();
  
  public static native <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap);
  
  private static native <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap, Comparator<? super V> paramComparator);
  
  public static native <K, V> ImmutableSetMultimap<K, V> of();
  
  public static native <K, V> ImmutableSetMultimap<K, V> of(K paramK, V paramV);
  
  public static native <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2);
  
  public static native <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3);
  
  public static native <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4);
  
  public static native <K, V> ImmutableSetMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native ImmutableSet<Map.Entry<K, V>> entries();
  
  public native ImmutableSet<V> get(@Nullable K paramK);
  
  public native ImmutableSet<V> removeAll(Object paramObject);
  
  public native ImmutableSet<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V>
  {
    static
    {
      JniLib.a(Builder.class, 490);
    }
    
    public Builder()
    {
      this.builderMultimap = new ImmutableSetMultimap.BuilderMultimap();
    }
    
    public native ImmutableSetMultimap<K, V> build();
    
    @Beta
    public native Builder<K, V> orderKeysBy(Comparator<? super K> paramComparator);
    
    @Beta
    public native Builder<K, V> orderValuesBy(Comparator<? super V> paramComparator);
    
    public native Builder<K, V> put(K paramK, V paramV);
    
    public native Builder<K, V> putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native Builder<K, V> putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public Builder<K, V> putAll(K paramK, V... paramVarArgs)
    {
      return putAll(paramK, Arrays.asList(paramVarArgs));
    }
  }
  
  private static class BuilderMultimap<K, V>
    extends AbstractMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(BuilderMultimap.class, 491);
    }
    
    BuilderMultimap()
    {
      super();
    }
    
    native Collection<V> createCollection();
  }
  
  private static class SortedKeyBuilderMultimap<K, V>
    extends AbstractMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SortedKeyBuilderMultimap.class, 492);
    }
    
    SortedKeyBuilderMultimap(Comparator<? super K> paramComparator, Multimap<K, V> paramMultimap)
    {
      super();
      putAll(paramMultimap);
    }
    
    native Collection<V> createCollection();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSetMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */