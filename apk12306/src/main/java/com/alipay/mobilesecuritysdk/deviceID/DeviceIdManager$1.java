package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.Map;

class DeviceIdManager$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 32);
  }
  
  DeviceIdManager$1(DeviceIdManager paramDeviceIdManager, Context paramContext, Map paramMap) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DeviceIdManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */