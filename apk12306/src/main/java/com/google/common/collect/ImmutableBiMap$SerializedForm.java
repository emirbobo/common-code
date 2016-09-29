package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ImmutableBiMap$SerializedForm
  extends ImmutableMap.SerializedForm
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SerializedForm.class, 462);
  }
  
  ImmutableBiMap$SerializedForm(ImmutableBiMap<?, ?> paramImmutableBiMap)
  {
    super(paramImmutableBiMap);
  }
  
  native Object readResolve();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableBiMap$SerializedForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */