package com.worklight.androidgap.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

class WLGeolocationPlugin$1
  extends BroadcastReceiver
{
  WLLocationListener newListener;
  
  static
  {
    JniLib.a(1.class, 1200);
  }
  
  WLGeolocationPlugin$1(WLGeolocationPlugin paramWLGeolocationPlugin, JSONArray paramJSONArray, CallbackContext paramCallbackContext, String paramString, int paramInt1, int paramInt2, WLLocationListener paramWLLocationListener) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLGeolocationPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */