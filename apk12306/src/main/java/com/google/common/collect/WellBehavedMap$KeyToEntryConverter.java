package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;
import java.util.Map.Entry;

class WellBehavedMap$KeyToEntryConverter<K, V>
  extends Sets.InvertibleFunction<K, Map.Entry<K, V>>
{
  final Map<K, V> map;
  
  static
  {
    JniLib.a(KeyToEntryConverter.class, 814);
  }
  
  WellBehavedMap$KeyToEntryConverter(Map<K, V> paramMap)
  {
    this.map = paramMap;
  }
  
  public native Map.Entry<K, V> apply(K paramK);
  
  public native K invert(Map.Entry<K, V> paramEntry);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\WellBehavedMap$KeyToEntryConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */