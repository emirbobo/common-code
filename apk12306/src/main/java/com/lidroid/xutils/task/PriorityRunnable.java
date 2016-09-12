package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;

public class PriorityRunnable
  extends PriorityObject<Runnable>
  implements Runnable
{
  static
  {
    JniLib.a(PriorityRunnable.class, 1019);
  }
  
  public PriorityRunnable(Priority paramPriority, Runnable paramRunnable)
  {
    super(paramPriority, paramRunnable);
  }
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */