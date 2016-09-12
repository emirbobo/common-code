package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public abstract class AbstractListenableFuture<V>
  extends AbstractFuture<V>
  implements ListenableFuture<V>
{
  private final ExecutionList executionList = new ExecutionList();
  
  public void addListener(Runnable paramRunnable, Executor paramExecutor)
  {
    this.executionList.add(paramRunnable, paramExecutor);
  }
  
  protected void done()
  {
    this.executionList.run();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractListenableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */