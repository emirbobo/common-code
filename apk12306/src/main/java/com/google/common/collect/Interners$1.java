package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ConcurrentMap;

final class Interners$1
  implements Interner<E>
{
  static
  {
    JniLib.a(1.class, 507);
  }
  
  Interners$1(ConcurrentMap paramConcurrentMap) {}
  
  public native E intern(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Interners$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */