package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.EnumSet;

class ImmutableEnumSet$EnumSerializedForm<E extends Enum<E>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final EnumSet<E> delegate;
  
  static
  {
    JniLib.a(EnumSerializedForm.class, 469);
  }
  
  ImmutableEnumSet$EnumSerializedForm(EnumSet<E> paramEnumSet)
  {
    this.delegate = paramEnumSet;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableEnumSet$EnumSerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */