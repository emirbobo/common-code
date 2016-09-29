package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bangcle.andjni.JniLib;

class PayHelper$1
  implements ServiceConnection
{
  static
  {
    JniLib.a(1.class, 136);
  }
  
  PayHelper$1(PayHelper paramPayHelper) {}
  
  public native void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder);
  
  public native void onServiceDisconnected(ComponentName paramComponentName);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\PayHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */