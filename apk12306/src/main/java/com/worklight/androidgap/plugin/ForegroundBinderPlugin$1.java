package com.worklight.androidgap.plugin;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bangcle.andjni.JniLib;

class ForegroundBinderPlugin$1
  implements ServiceConnection
{
  static
  {
    JniLib.a(1.class, 1175);
  }
  
  ForegroundBinderPlugin$1(ForegroundBinderPlugin paramForegroundBinderPlugin, int paramInt1, String paramString1, Class paramClass, String paramString2, String paramString3, int paramInt2) {}
  
  public native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\ForegroundBinderPlugin$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */