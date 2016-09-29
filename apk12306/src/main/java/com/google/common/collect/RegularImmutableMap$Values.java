package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class RegularImmutableMap$Values<V>
  extends ImmutableCollection<V>
{
  final RegularImmutableMap<?, V> map;
  
  static
  {
    JniLib.a(Values.class, 709);
  }
  
  RegularImmutableMap$Values(RegularImmutableMap<?, V> paramRegularImmutableMap)
  {
    this.map = paramRegularImmutableMap;
  }
  
  public native boolean contains(Object paramObject);
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */