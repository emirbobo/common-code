package com.ta.utdid2.device;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class DeviceInfo
{
  static final Object CREATE_DEVICE_METADATA_LOCK = new Object();
  static String HMAC_KEY;
  static final byte UTDID_VERSION_CODE = 1;
  private static Device mDevice;
  
  static
  {
    JniLib.a(DeviceInfo.class, 1074);
    mDevice = null;
    HMAC_KEY = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
  }
  
  private static native Device _initDeviceMetadata(Context paramContext);
  
  public static native Device getDevice(Context paramContext);
  
  static native long getMetadataCheckSum(Device paramDevice);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\device\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */