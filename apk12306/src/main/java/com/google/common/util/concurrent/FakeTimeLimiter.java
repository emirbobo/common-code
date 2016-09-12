package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public final class FakeTimeLimiter
  implements TimeLimiter
{
  static
  {
    JniLib.a(FakeTimeLimiter.class, 890);
  }
  
  public native <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
    throws Exception;
  
  public native <T> T newProxy(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\FakeTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */