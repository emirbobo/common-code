package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class ExplicitOrderedImmutableSortedSet$SerializedForm<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Object[] elements;
  
  static
  {
    JniLib.a(SerializedForm.class, 445);
  }
  
  public ExplicitOrderedImmutableSortedSet$SerializedForm(Object[] paramArrayOfObject)
  {
    this.elements = paramArrayOfObject;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ExplicitOrderedImmutableSortedSet$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */