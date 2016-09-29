package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class WellBehavedMap$KeyToEntryConverter$1
  extends AbstractMapEntry<K, V>
{
  static
  {
    JniLib.a(1.class, 813);
  }
  
  WellBehavedMap$KeyToEntryConverter$1(WellBehavedMap.KeyToEntryConverter paramKeyToEntryConverter, Object paramObject) {}
  
  public native K getKey();
  
  public native V getValue();
  
  public native V setValue(V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\WellBehavedMap$KeyToEntryConverter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */