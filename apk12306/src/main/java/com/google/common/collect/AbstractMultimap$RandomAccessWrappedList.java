package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class AbstractMultimap$RandomAccessWrappedList
  extends AbstractMultimap.WrappedList
  implements RandomAccess
{
  AbstractMultimap$RandomAccessWrappedList(@Nullable K paramK, List<V> paramList, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    super(paramK, paramList, paramAbstractMultimap, localWrappedCollection);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$RandomAccessWrappedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */