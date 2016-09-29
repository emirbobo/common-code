package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Multisets$1
  extends Multisets.AbstractEntry<E>
{
  static
  {
    JniLib.a(1.class, 680);
  }
  
  Multisets$1(Object paramObject, int paramInt) {}
  
  public native int getCount();
  
  public native E getElement();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */