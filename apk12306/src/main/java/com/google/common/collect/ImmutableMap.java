package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableMap<K, V>
  implements Map<K, V>, Serializable
{
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if (((paramMap instanceof ImmutableMap)) && (!(paramMap instanceof ImmutableSortedMap)))
    {
      ImmutableMap localImmutableMap = (ImmutableMap)paramMap;
      if (!localImmutableMap.isPartialView()) {
        paramMap = localImmutableMap;
      }
    }
    for (;;)
    {
      return paramMap;
      paramMap = (Map.Entry[])paramMap.entrySet().toArray(new Map.Entry[0]);
      int i;
      switch (paramMap.length)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        if (i < paramMap.length)
        {
          paramMap[i] = entryOf(paramMap[i].getKey(), paramMap[i].getValue());
          i++;
          continue;
          paramMap = of();
          break;
          paramMap = new SingletonImmutableMap(entryOf(paramMap[0].getKey(), paramMap[0].getValue()));
          break;
        }
      }
      paramMap = new RegularImmutableMap(paramMap);
    }
  }
  
  static <K, V> Map.Entry<K, V> entryOf(K paramK, V paramV)
  {
    return Maps.immutableEntry(Preconditions.checkNotNull(paramK, "null key"), Preconditions.checkNotNull(paramV, "null value"));
  }
  
  public static <K, V> ImmutableMap<K, V> of()
  {
    return EmptyImmutableMap.INSTANCE;
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK, V paramV)
  {
    return new SingletonImmutableMap(Preconditions.checkNotNull(paramK), Preconditions.checkNotNull(paramV));
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4) });
  }
  
  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramK1, paramV1), entryOf(paramK2, paramV2), entryOf(paramK3, paramV3), entryOf(paramK4, paramV4), entryOf(paramK5, paramV5) });
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    if (get(paramObject) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public abstract boolean containsValue(@Nullable Object paramObject);
  
  public abstract ImmutableSet<Map.Entry<K, V>> entrySet();
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        bool = entrySet().equals(((Map)paramObject).entrySet());
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public abstract V get(@Nullable Object paramObject);
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    if (size() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  abstract boolean isPartialView();
  
  public abstract ImmutableSet<K> keySet();
  
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return Maps.toStringImpl(this);
  }
  
  public abstract ImmutableCollection<V> values();
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static class Builder<K, V>
  {
    final ArrayList<Map.Entry<K, V>> entries = Lists.newArrayList();
    
    static
    {
      JniLib.a(Builder.class, 458);
    }
    
    private static native <K, V> ImmutableMap<K, V> fromEntryList(List<Map.Entry<K, V>> paramList);
    
    public native ImmutableMap<K, V> build();
    
    public native Builder<K, V> put(K paramK, V paramV);
    
    public native Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap);
  }
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Object[] keys;
    private final Object[] values;
    
    static
    {
      JniLib.a(SerializedForm.class, 461);
    }
    
    SerializedForm(ImmutableMap<?, ?> paramImmutableMap)
    {
      this.keys = new Object[paramImmutableMap.size()];
      this.values = new Object[paramImmutableMap.size()];
      int i = 0;
      paramImmutableMap = paramImmutableMap.entrySet().iterator();
      while (paramImmutableMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramImmutableMap.next();
        this.keys[i] = localEntry.getKey();
        this.values[i] = localEntry.getValue();
        i++;
      }
    }
    
    native Object createMap(ImmutableMap.Builder<Object, Object> paramBuilder);
    
    native Object readResolve();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */