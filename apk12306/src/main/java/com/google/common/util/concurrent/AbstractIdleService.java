package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public abstract class AbstractIdleService
  implements Service
{
  private final Service delegate = new AbstractService()
  {
    static
    {
      JniLib.a(1.class, 883);
    }
    
    protected final native void doStart();
    
    protected final native void doStop();
  };
  
  private String getServiceName()
  {
    return getClass().getSimpleName();
  }
  
  protected Executor executor(final Service.State paramState)
  {
    new Executor()
    {
      static
      {
        JniLib.a(2.class, 884);
      }
      
      public native void execute(Runnable paramAnonymousRunnable);
    };
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void shutDown()
    throws Exception;
  
  public final ListenableFuture<Service.State> start()
  {
    return this.delegate.start();
  }
  
  public final Service.State startAndWait()
  {
    return this.delegate.startAndWait();
  }
  
  protected abstract void startUp()
    throws Exception;
  
  public final Service.State state()
  {
    return this.delegate.state();
  }
  
  public final ListenableFuture<Service.State> stop()
  {
    return this.delegate.stop();
  }
  
  public final Service.State stopAndWait()
  {
    return this.delegate.stopAndWait();
  }
  
  public String toString()
  {
    return getServiceName() + " [" + state() + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractIdleService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */