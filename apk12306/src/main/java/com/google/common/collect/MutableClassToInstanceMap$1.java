package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class MutableClassToInstanceMap$1
  implements MapConstraint<Class<?>, Object>
{
  static
  {
    JniLib.a(1.class, 693);
  }
  
  public native void checkKeyValue(Class<?> paramClass, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MutableClassToInstanceMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */