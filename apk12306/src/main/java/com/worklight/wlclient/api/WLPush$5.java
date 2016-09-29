package com.worklight.wlclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class WLPush$5
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(5.class, 1303);
  }
  
  WLPush$5(WLPush paramWLPush) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */