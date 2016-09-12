package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract interface RegularImmutableMap$LinkedEntry<K, V>
  extends Map.Entry<K, V>
{
  @Nullable
  public abstract LinkedEntry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$LinkedEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */