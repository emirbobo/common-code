package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public abstract class AbstractExecutionThreadService
  implements Service
{
  private final Service delegate = new AbstractService()
  {
    static
    {
      JniLib.a(1.class, 878);
    }
    
    protected final native void doStart();
    
    protected native void doStop();
  };
  
  private String getServiceName()
  {
    return getClass().getSimpleName();
  }
  
  protected Executor executor()
  {
    new Executor()
    {
      static
      {
        JniLib.a(2.class, 879);
      }
      
      public native void execute(Runnable paramAnonymousRunnable);
    };
  }
  
  public final boolean isRunning()
  {
    return this.delegate.isRunning();
  }
  
  protected abstract void run()
    throws Exception;
  
  protected void shutDown()
    throws Exception
  {}
  
  public final ListenableFuture<Service.State> start()
  {
    return this.delegate.start();
  }
  
  public final Service.State startAndWait()
  {
    return this.delegate.startAndWait();
  }
  
  protected void startUp()
    throws Exception
  {}
  
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
  
  protected void triggerShutdown() {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractExecutionThreadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */