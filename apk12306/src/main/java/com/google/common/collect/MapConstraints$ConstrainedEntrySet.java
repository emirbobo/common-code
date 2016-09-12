package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedEntrySet<K, V>
  extends MapConstraints.ConstrainedEntries<K, V>
  implements Set<Map.Entry<K, V>>
{
  static
  {
    JniLib.a(ConstrainedEntrySet.class, 600);
  }
  
  MapConstraints$ConstrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    super(paramSet, paramMapConstraint);
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapConstraints$ConstrainedEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */