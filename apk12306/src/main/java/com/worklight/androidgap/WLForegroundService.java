package com.worklight.androidgap;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bangcle.andjni.JniLib;

public class WLForegroundService
  extends Service
{
  static
  {
    JniLib.a(WLForegroundService.class, 4);
  }
  
  public native IBinder onBind(Intent paramIntent);
  
  public native void onDestroy();
  
  public native int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  public class ForegroundBinder
    extends Binder
  {
    static
    {
      JniLib.a(ForegroundBinder.class, 1148);
    }
    
    public ForegroundBinder() {}
    
    public native void makeForeground(int paramInt, Notification paramNotification);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLForegroundService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */