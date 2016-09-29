package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Callable;

final class Callables$1
  implements Callable<T>
{
  static
  {
    JniLib.a(1.class, 886);
  }
  
  Callables$1(Object paramObject) {}
  
  public native T call();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Callables$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */