package com.arrownock.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

public class AnPushGCMReceiver
  extends BroadcastReceiver
{
  public static final String MSG_ARRIVAL = PushService.ACTION_MSG_ARRIVAL;
  
  static
  {
    JniLib.a(AnPushGCMReceiver.class, 172);
  }
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\AnPushGCMReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */