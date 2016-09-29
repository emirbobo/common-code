package com.worklight.androidgap.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;

class Push$3
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(3.class, 1185);
  }
  
  Push$3(Push paramPush, CallbackContext paramCallbackContext) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\Push$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */