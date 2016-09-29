package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class ImmutableSortedMap$EntrySetSerializedForm<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableSortedMap<K, V> map;
  
  static
  {
    JniLib.a(EntrySetSerializedForm.class, 500);
  }
  
  ImmutableSortedMap$EntrySetSerializedForm(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.map = paramImmutableSortedMap;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$EntrySetSerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */