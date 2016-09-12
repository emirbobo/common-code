package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class ImmutableAsList$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final ImmutableCollection<?> collection;
  
  static
  {
    JniLib.a(SerializedForm.class, 455);
  }
  
  ImmutableAsList$SerializedForm(ImmutableCollection<?> paramImmutableCollection)
  {
    this.collection = paramImmutableCollection;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableAsList$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */