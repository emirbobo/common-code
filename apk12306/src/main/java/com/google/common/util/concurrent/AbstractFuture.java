package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractFuture<V>
  implements Future<V>
{
  private final Sync<V> sync = new Sync();
  
  protected final boolean cancel()
  {
    boolean bool = this.sync.cancel();
    if (bool) {
      done();
    }
    return bool;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  protected void done() {}
  
  public V get()
    throws InterruptedException, ExecutionException
  {
    return (V)this.sync.get();
  }
  
  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, ExecutionException
  {
    return (V)this.sync.get(paramTimeUnit.toNanos(paramLong));
  }
  
  public boolean isCancelled()
  {
    return this.sync.isCancelled();
  }
  
  public boolean isDone()
  {
    return this.sync.isDone();
  }
  
  protected boolean set(@Nullable V paramV)
  {
    boolean bool = this.sync.set(paramV);
    if (bool) {
      done();
    }
    return bool;
  }
  
  protected boolean setException(Throwable paramThrowable)
  {
    boolean bool = this.sync.setException((Throwable)Preconditions.checkNotNull(paramThrowable));
    if (bool) {
      done();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    return bool;
  }
  
  static final class Sync<V>
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */