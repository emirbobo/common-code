package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class DispatchingPlugin$SerialExecutor
  implements Executor
{
  private Runnable currentRunnable;
  private LinkedBlockingQueue<Runnable> dispatcherRunnables = new LinkedBlockingQueue();
  private Executor executor = Executors.newCachedThreadPool();
  
  static
  {
    JniLib.a(SerialExecutor.class, 1222);
  }
  
  private native void scheduleNextRunnable();
  
  public native void execute(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DispatchingPlugin$SerialExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */