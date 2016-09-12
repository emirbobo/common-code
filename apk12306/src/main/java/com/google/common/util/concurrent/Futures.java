package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

@Beta
public final class Futures
{
  static
  {
    JniLib.a(Futures.class, 901);
  }
  
  public static native <I, O> ListenableFuture<O> chain(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction);
  
  public static native <I, O> ListenableFuture<O> chain(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction, Executor paramExecutor);
  
  public static native <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V paramV);
  
  public static native <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X paramX);
  
  public static native <V> ListenableFuture<V> immediateFailedFuture(Throwable paramThrowable);
  
  public static native <V> ListenableFuture<V> immediateFuture(@Nullable V paramV);
  
  public static native <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> paramListenableFuture, Function<Exception, X> paramFunction);
  
  public static native <V, X extends Exception> CheckedFuture<V, X> makeChecked(Future<V> paramFuture, Function<Exception, X> paramFunction);
  
  public static native <V> ListenableFuture<V> makeListenable(Future<V> paramFuture);
  
  static native <V> ListenableFuture<V> makeListenable(Future<V> paramFuture, Executor paramExecutor);
  
  public static native <V> UninterruptibleFuture<V> makeUninterruptible(Future<V> paramFuture);
  
  public static native <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction);
  
  public static native <I, O> ListenableFuture<O> transform(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor);
  
  public static native <I, O> Future<O> transform(Future<I> paramFuture, Function<? super I, ? extends O> paramFunction);
  
  private static class ChainingListenableFuture<I, O>
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
    
    private ChainingListenableFuture(Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction, ListenableFuture<? extends I> paramListenableFuture)
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
  
  private static class ListenableFutureAdapter<V>
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
    
    ListenableFutureAdapter(Future<V> paramFuture)
    {
      this(paramFuture, defaultAdapterExecutor);
    }
    
    ListenableFutureAdapter(Future<V> paramFuture, Executor paramExecutor)
    {
      this.delegate = ((Future)Preconditions.checkNotNull(paramFuture));
      this.adapterExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    }
    
    public native void addListener(Runnable paramRunnable, Executor paramExecutor);
    
    protected native Future<V> delegate();
  }
  
  private static class MappingCheckedFuture<V, X extends Exception>
    extends AbstractCheckedFuture<V, X>
  {
    final Function<Exception, X> mapper;
    
    static
    {
      JniLib.a(MappingCheckedFuture.class, 900);
    }
    
    MappingCheckedFuture(ListenableFuture<V> paramListenableFuture, Function<Exception, X> paramFunction)
    {
      super();
      this.mapper = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    protected native X mapException(Exception paramException);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */