package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableBiMap$EmptyBiMap
  extends ImmutableBiMap<Object, Object>
{
  static
  {
    JniLib.a(EmptyBiMap.class, 460);
  }
  
  native ImmutableMap<Object, Object> delegate();
  
  public native ImmutableBiMap<Object, Object> inverse();
  
  native boolean isPartialView();
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableBiMap$EmptyBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */