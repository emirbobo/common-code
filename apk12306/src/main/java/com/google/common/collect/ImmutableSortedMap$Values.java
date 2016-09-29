package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableSortedMap$Values<V>
  extends ImmutableCollection<V>
{
  private final ImmutableSortedMap<?, V> map;
  
  static
  {
    JniLib.a(Values.class, 502);
  }
  
  ImmutableSortedMap$Values(ImmutableSortedMap<?, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }
  
  public native boolean contains(Object paramObject);
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<V> iterator();
  
  public native int size();
  
  native Object writeReplace();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */