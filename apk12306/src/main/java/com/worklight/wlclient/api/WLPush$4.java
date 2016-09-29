package com.worklight.wlclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class WLPush$4
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(4.class, 1302);
  }
  
  WLPush$4(WLPush paramWLPush) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */