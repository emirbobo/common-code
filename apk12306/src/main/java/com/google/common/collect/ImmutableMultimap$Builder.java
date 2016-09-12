package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.Arrays;
import java.util.Comparator;

public class ImmutableMultimap$Builder<K, V>
{
  Multimap<K, V> builderMultimap = new ImmutableMultimap.BuilderMultimap();
  Comparator<? super V> valueComparator;
  
  static
  {
    JniLib.a(Builder.class, 475);
  }
  
  public native ImmutableMultimap<K, V> build();
  
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultimap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */