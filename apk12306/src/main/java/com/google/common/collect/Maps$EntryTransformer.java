package com.google.common.collect;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public abstract interface Maps$EntryTransformer<K, V1, V2>
{
  public abstract V2 transformEntry(@Nullable K paramK, @Nullable V1 paramV1);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$EntryTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */