package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMap$Builder<K, V>
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */