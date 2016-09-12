package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.Arrays;
import java.util.Comparator;

public final class ImmutableSetMultimap$Builder<K, V>
  extends ImmutableMultimap.Builder<K, V>
{
  static
  {
    JniLib.a(Builder.class, 490);
  }
  
  public ImmutableSetMultimap$Builder()
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSetMultimap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */