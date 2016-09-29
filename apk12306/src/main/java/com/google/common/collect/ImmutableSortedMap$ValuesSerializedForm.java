package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class ImmutableSortedMap$ValuesSerializedForm<V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableSortedMap<?, V> map;
  
  static
  {
    JniLib.a(ValuesSerializedForm.class, 503);
  }
  
  ImmutableSortedMap$ValuesSerializedForm(ImmutableSortedMap<?, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$ValuesSerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */