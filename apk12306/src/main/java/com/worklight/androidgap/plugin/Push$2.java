package com.worklight.androidgap.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;

class Push$2
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(2.class, 1184);
  }
  
  Push$2(Push paramPush, CallbackContext paramCallbackContext) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\Push$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */