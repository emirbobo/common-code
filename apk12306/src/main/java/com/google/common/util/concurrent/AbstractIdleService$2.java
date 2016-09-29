package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;

class AbstractIdleService$2
  implements Executor
{
  static
  {
    JniLib.a(2.class, 884);
  }
  
  AbstractIdleService$2(AbstractIdleService paramAbstractIdleService, Service.State paramState) {}
  
  public native void execute(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractIdleService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */