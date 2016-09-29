package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableListMultimap<K, V>
  extends ImmutableMultimap<K, V>
  implements ListMultimap<K, V>
{
  @GwtIncompatible("Not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(ImmutableListMultimap.class, 430);
  }
  
  ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> paramImmutableMap, int paramInt)
  {
    super(paramImmutableMap, paramInt);
  }
  
  public static native <K, V> Builder<K, V> builder();
  
  public static native <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> paramMultimap);
  
  public static native <K, V> ImmutableListMultimap<K, V> of();
  
  public static native <K, V> ImmutableListMultimap<K, V> of(K paramK, V paramV);
  
  public static native <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2);
  
  public static native <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3);
  
  public static native <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4);
  
  public static native <K, V> ImmutableListMultimap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native ImmutableList<V> get(@Nullable K paramK);
  
  public native ImmutableList<V> removeAll(Object paramObject);
  
  public native ImmutableList<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public static final class Builder<K, V>
    extends ImmutableMultimap.Builder<K, V>
  {
    static
    {
      JniLib.a(Builder.class, 476);
    }
    
    public native ImmutableListMultimap<K, V> build();
    
    @Beta
    public native Builder<K, V> orderKeysBy(Comparator<? super K> paramComparator);
    
    @Beta
    public native Builder<K, V> orderValuesBy(Comparator<? super V> paramComparator);
    
    public native Builder<K, V> put(K paramK, V paramV);
    
    public native Builder<K, V> putAll(Multimap<? extends K, ? extends V> paramMultimap);
    
    public native Builder<K, V> putAll(K paramK, Iterable<? extends V> paramIterable);
    
    public Builder<K, V> putAll(K paramK, V... paramVarArgs)
    {
      super.putAll(paramK, paramVarArgs);
      return this;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */