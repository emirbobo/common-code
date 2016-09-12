package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

final class AbstractFuture$Sync<V>
  extends AbstractQueuedSynchronizer
{
  static final int CANCELLED = 4;
  static final int COMPLETED = 2;
  static final int COMPLETING = 1;
  static final int RUNNING = 0;
  private static final long serialVersionUID = 0L;
  private Throwable exception;
  private V value;
  
  static
  {
    JniLib.a(Sync.class, 880);
  }
  
  private native boolean complete(@Nullable V paramV, Throwable paramThrowable, int paramInt);
  
  private native V getValue()
    throws CancellationException, ExecutionException;
  
  native boolean cancel();
  
  native V get()
    throws CancellationException, ExecutionException, InterruptedException;
  
  native V get(long paramLong)
    throws TimeoutException, CancellationException, ExecutionException, InterruptedException;
  
  native boolean isCancelled();
  
  native boolean isDone();
  
  native boolean set(@Nullable V paramV);
  
  native boolean setException(Throwable paramThrowable);
  
  protected native int tryAcquireShared(int paramInt);
  
  protected native boolean tryReleaseShared(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractFuture$Sync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */