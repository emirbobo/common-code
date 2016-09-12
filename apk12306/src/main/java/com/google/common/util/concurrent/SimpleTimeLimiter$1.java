package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class SimpleTimeLimiter$1
  implements InvocationHandler
{
  static
  {
    JniLib.a(1.class, 908);
  }
  
  SimpleTimeLimiter$1(SimpleTimeLimiter paramSimpleTimeLimiter, Object paramObject, long paramLong, TimeUnit paramTimeUnit, Set paramSet) {}
  
  public native Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\SimpleTimeLimiter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */