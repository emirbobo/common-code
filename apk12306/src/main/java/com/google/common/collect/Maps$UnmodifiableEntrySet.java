package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$UnmodifiableEntrySet<K, V>
  extends Maps.UnmodifiableEntries<K, V>
  implements Set<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(UnmodifiableEntrySet.class, 640);
  }
  
  Maps$UnmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet)
  {
    super(paramSet);
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$UnmodifiableEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */