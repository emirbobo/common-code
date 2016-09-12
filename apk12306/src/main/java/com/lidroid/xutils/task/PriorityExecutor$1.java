package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class PriorityExecutor$1
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  static
  {
    JniLib.a(1.class, 1015);
  }
  
  public native Thread newThread(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityExecutor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */