package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class Futures$1
  implements UninterruptibleFuture<V>
{
  static
  {
    JniLib.a(1.class, 891);
  }
  
  Futures$1(Future paramFuture) {}
  
  public native boolean cancel(boolean paramBoolean);
  
  public native V get()
    throws ExecutionException;
  
  public native V get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, ExecutionException;
  
  public native boolean isCancelled();
  
  public native boolean isDone();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */