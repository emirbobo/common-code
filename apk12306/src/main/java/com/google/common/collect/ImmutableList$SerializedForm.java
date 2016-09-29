package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class ImmutableList$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Object[] elements;
  
  static
  {
    JniLib.a(SerializedForm.class, 474);
  }
  
  ImmutableList$SerializedForm(Object[] paramArrayOfObject)
  {
    this.elements = paramArrayOfObject;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableList$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */