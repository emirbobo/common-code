package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class Futures$5
  implements Future<O>
{
  private ExecutionException exception = null;
  private final Object lock = new Object();
  private boolean set = false;
  private O value = null;
  
  static
  {
    JniLib.a(5.class, 895);
  }
  
  Futures$5(Future paramFuture, Function paramFunction) {}
  
  private native O apply(I paramI)
    throws ExecutionException;
  
  public native boolean cancel(boolean paramBoolean);
  
  public native O get()
    throws InterruptedException, ExecutionException;
  
  public native O get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException;
  
  public native boolean isCancelled();
  
  public native boolean isDone();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */