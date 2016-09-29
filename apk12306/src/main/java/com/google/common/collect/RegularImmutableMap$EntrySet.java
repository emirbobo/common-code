package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class RegularImmutableMap$EntrySet<K, V>
  extends ImmutableSet.ArrayImmutableSet<Map.Entry<K, V>>
{
  final transient RegularImmutableMap<K, V> map;
  
  static
  {
    JniLib.a(EntrySet.class, 704);
  }
  
  RegularImmutableMap$EntrySet(RegularImmutableMap<K, V> paramRegularImmutableMap)
  {
    super(RegularImmutableMap.access$000(paramRegularImmutableMap));
    this.map = paramRegularImmutableMap;
  }
  
  public native boolean contains(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */