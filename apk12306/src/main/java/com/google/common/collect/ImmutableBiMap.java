package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableBiMap<K, V>
  extends ImmutableMap<K, V>
  implements BiMap<K, V>
{
  private static final ImmutableBiMap<Object, Object> EMPTY_IMMUTABLE_BIMAP = new EmptyBiMap();
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> paramMap)
  {
    if ((paramMap instanceof ImmutableBiMap))
    {
      ImmutableBiMap localImmutableBiMap = (ImmutableBiMap)paramMap;
      if (!localImmutableBiMap.isPartialView()) {
        paramMap = localImmutableBiMap;
      }
    }
    for (;;)
    {
      return paramMap;
      if (paramMap.isEmpty()) {
        paramMap = of();
      } else {
        paramMap = new RegularImmutableBiMap(ImmutableMap.copyOf(paramMap));
      }
    }
  }
  
  public static <K, V> ImmutableBiMap<K, V> of()
  {
    return EMPTY_IMMUTABLE_BIMAP;
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK, V paramV)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramK, paramV));
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramK1, paramV1, paramK2, paramV2));
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3));
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4));
  }
  
  public static <K, V> ImmutableBiMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5));
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return inverse().containsKey(paramObject);
  }
  
  abstract ImmutableMap<K, V> delegate();
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject == this) || (delegate().equals(paramObject))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public V forcePut(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public V get(@Nullable Object paramObject)
  {
    return (V)delegate().get(paramObject);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public abstract ImmutableBiMap<V, K> inverse();
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public ImmutableSet<K> keySet()
  {
    return delegate().keySet();
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public String toString()
  {
    return delegate().toString();
  }
  
  public ImmutableSet<V> values()
  {
    return inverse().keySet();
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this);
  }
  
  public static final class Builder<K, V>
    extends ImmutableMap.Builder<K, V>
  {
    static
    {
      JniLib.a(Builder.class, 459);
    }
    
    public native ImmutableBiMap<K, V> build();
    
    public native Builder<K, V> put(K paramK, V paramV);
    
    public native Builder<K, V> putAll(Map<? extends K, ? extends V> paramMap);
  }
  
  static class EmptyBiMap
    extends ImmutableBiMap<Object, Object>
  {
    static
    {
      JniLib.a(EmptyBiMap.class, 460);
    }
    
    native ImmutableMap<Object, Object> delegate();
    
    public native ImmutableBiMap<Object, Object> inverse();
    
    native boolean isPartialView();
    
    native Object readResolve();
  }
  
  private static class SerializedForm
    extends ImmutableMap.SerializedForm
  {
    private static final long serialVersionUID = 0L;
    
    static
    {
      JniLib.a(SerializedForm.class, 462);
    }
    
    SerializedForm(ImmutableBiMap<?, ?> paramImmutableBiMap)
    {
      super();
    }
    
    native Object readResolve();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */