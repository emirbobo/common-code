package com.lidroid.xutils.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bangcle.andjni.JniLib;

class PriorityAsyncTask$InternalHandler
  extends Handler
{
  static
  {
    JniLib.a(InternalHandler.class, 1014);
  }
  
  private PriorityAsyncTask$InternalHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public native void handleMessage(Message paramMessage);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\task\PriorityAsyncTask$InternalHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */