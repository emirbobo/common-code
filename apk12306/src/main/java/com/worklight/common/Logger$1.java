package com.worklight.common;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class Logger$1
  implements RejectedExecutionHandler
{
  static
  {
    JniLib.a(1.class, 1245);
  }
  
  public native void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */