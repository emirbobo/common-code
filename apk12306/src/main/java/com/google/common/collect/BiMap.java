package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface BiMap<K, V>
  extends Map<K, V>
{
  public abstract V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  public abstract BiMap<V, K> inverse();
  
  public abstract V put(@Nullable K paramK, @Nullable V paramV);
  
  public abstract void putAll(Map<? extends K, ? extends V> paramMap);
  
  public abstract Set<V> values();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\BiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */