package com.worklight.androidgap.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class WLGCMIntentService$1
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(1.class, 1242);
  }
  
  WLGCMIntentService$1(WLGCMIntentService paramWLGCMIntentService) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\push\WLGCMIntentService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */