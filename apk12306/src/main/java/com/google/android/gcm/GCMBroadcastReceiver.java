package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

public class GCMBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "GCMBroadcastReceiver";
  
  static
  {
    JniLib.a(GCMBroadcastReceiver.class, 254);
  }
  
  protected native String getGCMIntentServiceClassName(Context paramContext);
  
  public final native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\android\gcm\GCMBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */