package com.worklight.wlclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class WLPush$3
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(3.class, 1301);
  }
  
  WLPush$3(WLPush paramWLPush) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */