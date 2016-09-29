package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;

class PriorityAsyncTask$1
  extends PriorityAsyncTask.WorkerRunnable<Params, Result>
{
  static
  {
    JniLib.a(1.class, 1012);
  }
  
  PriorityAsyncTask$1(PriorityAsyncTask paramPriorityAsyncTask)
  {
    super(null);
  }
  
  public native Result call()
    throws Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityAsyncTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */