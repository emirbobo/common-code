package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class SimpleTimeLimiter$1$1
  implements Callable<Object>
{
  static
  {
    JniLib.a(1.class, 907);
  }
  
  SimpleTimeLimiter$1$1(SimpleTimeLimiter.1 param1, Method paramMethod, Object[] paramArrayOfObject) {}
  
  public native Object call()
    throws Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\SimpleTimeLimiter$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */