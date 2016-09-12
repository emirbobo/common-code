package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super E> comparator;
  final Object[] elements;
  
  static
  {
    JniLib.a(SerializedForm.class, 506);
  }
  
  public ImmutableSortedSet$SerializedForm(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
  {
    this.comparator = paramComparator;
    this.elements = paramArrayOfObject;
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedSet$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */