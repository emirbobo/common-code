package com.google.common.collect;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public abstract interface MapEvictionListener<K, V>
{
  public abstract void onEviction(@Nullable K paramK, @Nullable V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapEvictionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */