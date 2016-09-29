package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class MoreExecutors$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 903);
  }
  
  MoreExecutors$1(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\MoreExecutors$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */