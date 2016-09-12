package com.arrownock.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import eg;

public class PushNotificationFetcher
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(PushNotificationFetcher.class, 175);
  }
  
  private static native void b(String paramString, Context paramContext, int paramInt, eg parameg);
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\PushNotificationFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */