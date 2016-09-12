package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

class Futures$ChainingListenableFuture<I, O>
  extends AbstractListenableFuture<O>
  implements Runnable
{
  private Function<? super I, ? extends ListenableFuture<? extends O>> function;
  private ListenableFuture<? extends I> inputFuture;
  private final BlockingQueue<Boolean> mayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
  private final CountDownLatch outputCreated = new CountDownLatch(1);
  private volatile ListenableFuture<? extends O> outputFuture;
  
  static
  {
    JniLib.a(ChainingListenableFuture.class, 897);
  }
  
  private Futures$ChainingListenableFuture(Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction, ListenableFuture<? extends I> paramListenableFuture)
  {
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
  }
  
  private native void cancel(@Nullable Future<?> paramFuture, boolean paramBoolean);
  
  public native boolean cancel(boolean paramBoolean);
  
  public native O get()
    throws InterruptedException, ExecutionException;
  
  public native O get(long paramLong, TimeUnit paramTimeUnit)
    throws TimeoutException, ExecutionException, InterruptedException;
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$ChainingListenableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */