package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public abstract class AbstractService
  implements Service
{
  private final ReentrantLock lock = new ReentrantLock();
  private final Transition shutdown = new Transition(null);
  private boolean shutdownWhenStartupFinishes = false;
  private final Transition startup = new Transition(null);
  private Service.State state = Service.State.NEW;
  
  protected abstract void doStart();
  
  protected abstract void doStop();
  
  public final boolean isRunning()
  {
    if (state() == Service.State.RUNNING) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  protected final void notifyFailed(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	com/google/common/base/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: invokevirtual 67	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   12: aload_0
    //   13: getfield 44	com/google/common/util/concurrent/AbstractService:state	Lcom/google/common/util/concurrent/Service$State;
    //   16: getstatic 70	com/google/common/util/concurrent/Service$State:STARTING	Lcom/google/common/util/concurrent/Service$State;
    //   19: if_acmpne +49 -> 68
    //   22: aload_0
    //   23: getfield 35	com/google/common/util/concurrent/AbstractService:startup	Lcom/google/common/util/concurrent/AbstractService$Transition;
    //   26: aload_1
    //   27: invokevirtual 74	com/google/common/util/concurrent/AbstractService$Transition:setException	(Ljava/lang/Throwable;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 37	com/google/common/util/concurrent/AbstractService:shutdown	Lcom/google/common/util/concurrent/AbstractService$Transition;
    //   35: astore_2
    //   36: new 76	java/lang/Exception
    //   39: astore_3
    //   40: aload_3
    //   41: ldc 78
    //   43: aload_1
    //   44: invokespecial 81	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: aload_2
    //   48: aload_3
    //   49: invokevirtual 74	com/google/common/util/concurrent/AbstractService$Transition:setException	(Ljava/lang/Throwable;)Z
    //   52: pop
    //   53: aload_0
    //   54: getstatic 84	com/google/common/util/concurrent/Service$State:FAILED	Lcom/google/common/util/concurrent/Service$State;
    //   57: putfield 44	com/google/common/util/concurrent/AbstractService:state	Lcom/google/common/util/concurrent/Service$State;
    //   60: aload_0
    //   61: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   64: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   67: return
    //   68: aload_0
    //   69: getfield 44	com/google/common/util/concurrent/AbstractService:state	Lcom/google/common/util/concurrent/Service$State;
    //   72: getstatic 90	com/google/common/util/concurrent/Service$State:STOPPING	Lcom/google/common/util/concurrent/Service$State;
    //   75: if_acmpne -22 -> 53
    //   78: aload_0
    //   79: getfield 37	com/google/common/util/concurrent/AbstractService:shutdown	Lcom/google/common/util/concurrent/AbstractService$Transition;
    //   82: aload_1
    //   83: invokevirtual 74	com/google/common/util/concurrent/AbstractService$Transition:setException	(Ljava/lang/Throwable;)Z
    //   86: pop
    //   87: goto -34 -> 53
    //   90: astore_1
    //   91: aload_0
    //   92: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   95: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	AbstractService
    //   0	100	1	paramThrowable	Throwable
    //   35	13	2	localTransition	Transition
    //   39	10	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   12	53	90	finally
    //   53	60	90	finally
    //   68	87	90	finally
  }
  
  protected final void notifyStarted()
  {
    this.lock.lock();
    try
    {
      if (this.state != Service.State.STARTING)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localIllegalStateException.<init>("Cannot notifyStarted() when the service is " + this.state);
        notifyFailed(localIllegalStateException);
        throw localIllegalStateException;
      }
    }
    finally
    {
      this.lock.unlock();
    }
    this.state = Service.State.RUNNING;
    if (this.shutdownWhenStartupFinishes) {
      stop();
    }
    for (;;)
    {
      this.lock.unlock();
      return;
      this.startup.set(Service.State.RUNNING);
    }
  }
  
  protected final void notifyStopped()
  {
    this.lock.lock();
    try
    {
      if ((this.state != Service.State.STOPPING) && (this.state != Service.State.RUNNING))
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localIllegalStateException.<init>("Cannot notifyStopped() when the service is " + this.state);
        notifyFailed(localIllegalStateException);
        throw localIllegalStateException;
      }
    }
    finally
    {
      this.lock.unlock();
    }
    this.state = Service.State.TERMINATED;
    this.shutdown.set(Service.State.TERMINATED);
    this.lock.unlock();
  }
  
  public final ListenableFuture<Service.State> start()
  {
    this.lock.lock();
    try
    {
      if (this.state == Service.State.NEW)
      {
        this.state = Service.State.STARTING;
        doStart();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        notifyFailed(localThrowable);
        this.lock.unlock();
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return this.startup;
  }
  
  public Service.State startAndWait()
  {
    try
    {
      Service.State localState = (Service.State)Futures.makeUninterruptible(start()).get();
      return localState;
    }
    catch (ExecutionException localExecutionException)
    {
      throw Throwables.propagate(localExecutionException.getCause());
    }
  }
  
  /* Error */
  public final Service.State state()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 67	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 46	com/google/common/util/concurrent/AbstractService:shutdownWhenStartupFinishes	Z
    //   11: ifeq +26 -> 37
    //   14: aload_0
    //   15: getfield 44	com/google/common/util/concurrent/AbstractService:state	Lcom/google/common/util/concurrent/Service$State;
    //   18: getstatic 70	com/google/common/util/concurrent/Service$State:STARTING	Lcom/google/common/util/concurrent/Service$State;
    //   21: if_acmpne +16 -> 37
    //   24: getstatic 90	com/google/common/util/concurrent/Service$State:STOPPING	Lcom/google/common/util/concurrent/Service$State;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: getfield 44	com/google/common/util/concurrent/AbstractService:state	Lcom/google/common/util/concurrent/Service$State;
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   46: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   49: goto -14 -> 35
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 30	com/google/common/util/concurrent/AbstractService:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   57: invokevirtual 87	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	AbstractService
    //   27	15	1	localState	Service.State
    //   52	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	28	52	finally
    //   37	42	52	finally
  }
  
  public final ListenableFuture<Service.State> stop()
  {
    this.lock.lock();
    try
    {
      if (this.state == Service.State.NEW)
      {
        this.state = Service.State.TERMINATED;
        this.startup.set(Service.State.TERMINATED);
        this.shutdown.set(Service.State.TERMINATED);
      }
      for (;;)
      {
        return this.shutdown;
        if (this.state != Service.State.STARTING) {
          break;
        }
        this.shutdownWhenStartupFinishes = true;
        this.startup.set(Service.State.STOPPING);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        notifyFailed(localThrowable);
        this.lock.unlock();
        continue;
        if (this.state == Service.State.RUNNING)
        {
          this.state = Service.State.STOPPING;
          doStop();
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public Service.State stopAndWait()
  {
    try
    {
      Service.State localState = (Service.State)Futures.makeUninterruptible(stop()).get();
      return localState;
    }
    catch (ExecutionException localExecutionException)
    {
      throw Throwables.propagate(localExecutionException.getCause());
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " [" + state() + "]";
  }
  
  private class Transition
    extends AbstractListenableFuture<Service.State>
  {
    static
    {
      JniLib.a(Transition.class, 885);
    }
    
    private Transition() {}
    
    public native Service.State get(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException, TimeoutException, ExecutionException;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */