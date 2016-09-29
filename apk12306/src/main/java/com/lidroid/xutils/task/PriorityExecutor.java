package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityExecutor
  implements Executor
{
  private static final int CORE_POOL_SIZE = 5;
  private static final int KEEP_ALIVE = 1;
  private static final int MAXIMUM_POOL_SIZE = 256;
  private static final ThreadFactory sThreadFactory = new ThreadFactory()
  {
    private final AtomicInteger mCount = new AtomicInteger(1);
    
    static
    {
      JniLib.a(1.class, 1015);
    }
    
    public native Thread newThread(Runnable paramAnonymousRunnable);
  };
  private final BlockingQueue<Runnable> mPoolWorkQueue = new PriorityObjectBlockingQueue();
  private final ThreadPoolExecutor mThreadPoolExecutor;
  
  static
  {
    JniLib.a(PriorityExecutor.class, 1016);
  }
  
  public PriorityExecutor()
  {
    this(5);
  }
  
  public PriorityExecutor(int paramInt)
  {
    this.mThreadPoolExecutor = new ThreadPoolExecutor(paramInt, 256, 1L, TimeUnit.SECONDS, this.mPoolWorkQueue, sThreadFactory);
  }
  
  public native void execute(Runnable paramRunnable);
  
  public native int getPoolSize();
  
  public native boolean isBusy();
  
  public native void setPoolSize(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */