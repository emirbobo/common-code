package com.arrownock.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import ee;

public class PushCommandFetcher
  extends BroadcastReceiver
{
  public static final String ACTION_DISCONNECT = "AN.COMMAND_DISCONNECT";
  public static final String ACTION_REPORT_LOCATION = "AN.COMMAND_REPORT_LOCATION";
  public static final int REPORT_LOCATION_ID = 30000;
  
  static
  {
    JniLib.a(PushCommandFetcher.class, 174);
  }
  
  private static native void a(Context paramContext);
  
  private static native void b(String paramString, Context paramContext, int paramInt, ee paramee);
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\PushCommandFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */