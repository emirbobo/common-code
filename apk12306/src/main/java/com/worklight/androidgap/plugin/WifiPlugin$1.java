package com.worklight.androidgap.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;

class WifiPlugin$1
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(1.class, 1208);
  }
  
  WifiPlugin$1(WifiPlugin paramWifiPlugin, CallbackContext paramCallbackContext) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WifiPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */