package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Beta
public final class SimpleTimeLimiter
  implements TimeLimiter
{
  private final ExecutorService executor;
  
  static
  {
    JniLib.a(SimpleTimeLimiter.class, 909);
  }
  
  public SimpleTimeLimiter()
  {
    this(Executors.newCachedThreadPool());
  }
  
  public SimpleTimeLimiter(ExecutorService paramExecutorService)
  {
    this.executor = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
  }
  
  private static native boolean declaresInterruptedEx(Method paramMethod);
  
  private static native Set<Method> findInterruptibleMethods(Class<?> paramClass);
  
  private static native <T> T newProxy(Class<T> paramClass, InvocationHandler paramInvocationHandler);
  
  public native <T> T callWithTimeout(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
    throws Exception;
  
  public native <T> T newProxy(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\SimpleTimeLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */