package com.alipay.mobilesecuritysdk.deviceID;

import com.bangcle.andjni.JniLib;

class DeviceIdManager$2
  implements Runnable
{
  static
  {
    JniLib.a(2.class, 33);
  }
  
  DeviceIdManager$2(DeviceIdManager paramDeviceIdManager) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DeviceIdManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */