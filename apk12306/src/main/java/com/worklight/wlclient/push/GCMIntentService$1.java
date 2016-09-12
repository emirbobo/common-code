package com.worklight.wlclient.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class GCMIntentService$1
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(1.class, 1316);
  }
  
  GCMIntentService$1(GCMIntentService paramGCMIntentService) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\push\GCMIntentService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */