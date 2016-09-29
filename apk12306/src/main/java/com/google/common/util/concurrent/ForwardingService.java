package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import com.google.common.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;

@Beta
public abstract class ForwardingService
  extends ForwardingObject
  implements Service
{
  protected abstract Service delegate();
  
  public boolean isRunning()
  {
    return delegate().isRunning();
  }
  
  protected Service.State standardStartAndWait()
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
  
  protected Service.State standardStopAndWait()
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
  
  public ListenableFuture<Service.State> start()
  {
    return delegate().start();
  }
  
  public Service.State startAndWait()
  {
    return delegate().startAndWait();
  }
  
  public Service.State state()
  {
    return delegate().state();
  }
  
  public ListenableFuture<Service.State> stop()
  {
    return delegate().stop();
  }
  
  public Service.State stopAndWait()
  {
    return delegate().stopAndWait();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\ForwardingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */