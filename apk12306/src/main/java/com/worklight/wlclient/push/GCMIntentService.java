package com.worklight.wlclient.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.push.WLGCMIntentService;

public class GCMIntentService
  extends WLGCMIntentService
{
  private static boolean isAppForeground = false;
  private BroadcastReceiver resultReceiver = new BroadcastReceiver()
  {
    static
    {
      JniLib.a(1.class, 1316);
    }
    
    public native void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent);
  };
  
  static
  {
    JniLib.a(GCMIntentService.class, 1317);
  }
  
  public GCMIntentService()
  {
    setBroadcastReceiver(this.resultReceiver);
  }
  
  public static native boolean isAppForeground();
  
  public static native void setAppForeground(boolean paramBoolean);
  
  protected native void addToIntentQueue(Intent paramIntent);
  
  protected native String getNotificationTitle(Context paramContext);
  
  protected native String[] getSenderIds(Context paramContext);
  
  protected native void setResources();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\push\GCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */