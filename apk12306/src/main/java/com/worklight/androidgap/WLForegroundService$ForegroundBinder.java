package com.worklight.androidgap;

import android.app.Notification;
import android.os.Binder;
import com.bangcle.andjni.JniLib;

public class WLForegroundService$ForegroundBinder
  extends Binder
{
  static
  {
    JniLib.a(ForegroundBinder.class, 1148);
  }
  
  public WLForegroundService$ForegroundBinder(WLForegroundService paramWLForegroundService) {}
  
  public native void makeForeground(int paramInt, Notification paramNotification);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLForegroundService$ForegroundBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */