package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class SingletonImmutableMap$Values<V>
  extends ImmutableCollection<V>
{
  final V singleValue;
  
  static
  {
    JniLib.a(Values.class, 734);
  }
  
  SingletonImmutableMap$Values(V paramV)
  {
    this.singleValue = paramV;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SingletonImmutableMap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */