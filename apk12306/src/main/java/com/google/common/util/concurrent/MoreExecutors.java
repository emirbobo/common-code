package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public final class MoreExecutors
{
  static
  {
    JniLib.a(MoreExecutors.class, 905);
  }
  
  public static native void addDelayedShutdownHook(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit);
  
  public static native ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor);
  
  public static native ExecutorService getExitingExecutorService(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit);
  
  public static native ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor);
  
  public static native ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit);
  
  public static native ExecutorService sameThreadExecutor();
  
  private static class SameThreadExecutorService
    extends AbstractExecutorService
  {
    private final Lock lock = new ReentrantLock();
    private int runningTasks = 0;
    private boolean shutdown = false;
    private final Condition termination = this.lock.newCondition();
    
    static
    {
      JniLib.a(SameThreadExecutorService.class, 904);
    }
    
    private native void endTask();
    
    private native void startTask();
    
    public native boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException;
    
    public native void execute(Runnable paramRunnable);
    
    public native boolean isShutdown();
    
    public native boolean isTerminated();
    
    public native void shutdown();
    
    public native List<Runnable> shutdownNow();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\MoreExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */