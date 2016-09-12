package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class RegularImmutableMap$KeySet<K, V>
  extends ImmutableSet.TransformedImmutableSet<Map.Entry<K, V>, K>
{
  final RegularImmutableMap<K, V> map;
  
  static
  {
    JniLib.a(KeySet.class, 705);
  }
  
  RegularImmutableMap$KeySet(RegularImmutableMap<K, V> paramRegularImmutableMap)
  {
    super(RegularImmutableMap.access$000(paramRegularImmutableMap), RegularImmutableMap.access$100(paramRegularImmutableMap));
    this.map = paramRegularImmutableMap;
  }
  
  public native boolean contains(Object paramObject);
  
  native boolean isPartialView();
  
  native K transform(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */