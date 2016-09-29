package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;

class ImmutableSortedMap$SerializedForm
  extends ImmutableMap.SerializedForm
{
  private static final long serialVersionUID = 0L;
  private final Comparator<Object> comparator;
  
  static
  {
    JniLib.a(SerializedForm.class, 501);
  }
  
  ImmutableSortedMap$SerializedForm(ImmutableSortedMap<?, ?> paramImmutableSortedMap)
  {
    super(paramImmutableSortedMap);
    this.comparator = paramImmutableSortedMap.comparator();
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSortedMap$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */