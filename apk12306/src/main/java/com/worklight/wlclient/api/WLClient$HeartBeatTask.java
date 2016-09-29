package com.worklight.wlclient.api;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.TimerTask;

class WLClient$HeartBeatTask
  extends TimerTask
{
  private Context context = null;
  
  static
  {
    JniLib.a(HeartBeatTask.class, 1287);
  }
  
  WLClient$HeartBeatTask(WLClient paramWLClient, Context paramContext)
  {
    this.context = paramContext;
  }
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLClient$HeartBeatTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */