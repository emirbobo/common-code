package com.lidroid.xutils.task;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class PriorityAsyncTask$2
  extends FutureTask<Result>
{
  static
  {
    JniLib.a(2.class, 1013);
  }
  
  PriorityAsyncTask$2(PriorityAsyncTask paramPriorityAsyncTask, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected native void done();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityAsyncTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */