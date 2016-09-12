package com.worklight.wlclient.push;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.google.android.gcm.GCMBroadcastReceiver;

public class WLBroadcastReceiver
  extends GCMBroadcastReceiver
{
  private static final String INTENT_SERVICE = "com.worklight.wlclient.push.GCMIntentService";
  
  static
  {
    JniLib.a(WLBroadcastReceiver.class, 1318);
  }
  
  protected native String getGCMIntentServiceClassName(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\push\WLBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */