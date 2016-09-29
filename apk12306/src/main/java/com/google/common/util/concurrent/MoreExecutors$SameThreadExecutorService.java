package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MoreExecutors$SameThreadExecutorService
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\MoreExecutors$SameThreadExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */