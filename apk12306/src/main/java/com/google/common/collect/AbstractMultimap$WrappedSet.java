package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$WrappedSet
  extends AbstractMultimap<K, V>.WrappedCollection
  implements Set<V>
{
  AbstractMultimap$WrappedSet(@Nullable K paramK, Set<V> paramSet)
  {
    super(paramK, paramSet, localCollection, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */