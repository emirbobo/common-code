package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMultimap$EntrySet
  extends AbstractMultimap<K, V>.Entries
  implements Set<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(EntrySet.class, 347);
  }
  
  private AbstractMultimap$EntrySet(AbstractMultimap paramAbstractMultimap)
  {
    super(paramAbstractMultimap, null);
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */