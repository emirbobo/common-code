package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;

class AbstractExecutionThreadService$2
  implements Executor
{
  static
  {
    JniLib.a(2.class, 879);
  }
  
  AbstractExecutionThreadService$2(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  public native void execute(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractExecutionThreadService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */