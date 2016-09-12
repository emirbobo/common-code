package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;

class ExecutionList$RunnableExecutorPair
{
  final Executor executor;
  final Runnable runnable;
  
  static
  {
    JniLib.a(RunnableExecutorPair.class, 888);
  }
  
  ExecutionList$RunnableExecutorPair(Runnable paramRunnable, Executor paramExecutor)
  {
    this.runnable = paramRunnable;
    this.executor = paramExecutor;
  }
  
  native void execute();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\ExecutionList$RunnableExecutorPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */