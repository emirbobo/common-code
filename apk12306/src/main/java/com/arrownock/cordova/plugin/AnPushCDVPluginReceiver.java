package com.arrownock.cordova.plugin;

import android.content.Context;
import com.arrownock.push.PushBroadcastReceiver;
import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class AnPushCDVPluginReceiver
  extends PushBroadcastReceiver
{
  static
  {
    JniLib.a(AnPushCDVPluginReceiver.class, 148);
  }
  
  public native void showNotification(Context paramContext, JSONObject paramJSONObject, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\cordova\plugin\AnPushCDVPluginReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */