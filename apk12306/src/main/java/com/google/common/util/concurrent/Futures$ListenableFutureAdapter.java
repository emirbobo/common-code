package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class Futures$ListenableFutureAdapter<V>
  extends ForwardingFuture<V>
  implements ListenableFuture<V>
{
  private static final Executor defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
  private static final ThreadFactory threadFactory;
  private final Executor adapterExecutor;
  private final Future<V> delegate;
  private final ExecutionList executionList = new ExecutionList();
  private final AtomicBoolean hasListeners = new AtomicBoolean(false);
  
  static
  {
    JniLib.a(ListenableFutureAdapter.class, 899);
    threadFactory = new ThreadFactoryBuilder().setNameFormat("ListenableFutureAdapter-thread-%d").build();
  }
  
  Futures$ListenableFutureAdapter(Future<V> paramFuture)
  {
    this(paramFuture, defaultAdapterExecutor);
  }
  
  Futures$ListenableFutureAdapter(Future<V> paramFuture, Executor paramExecutor)
  {
    this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
    this.adapterExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  public native void addListener(Runnable paramRunnable, Executor paramExecutor);
  
  protected native Future<V> delegate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$ListenableFutureAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */