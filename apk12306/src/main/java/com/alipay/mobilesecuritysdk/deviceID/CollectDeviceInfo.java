package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class CollectDeviceInfo
{
  private static CollectDeviceInfo collectSingleton = new CollectDeviceInfo();
  
  static
  {
    JniLib.a(CollectDeviceInfo.class, 30);
  }
  
  public static native CollectDeviceInfo getInstance();
  
  public native String getBandVer();
  
  public native String getBluMac();
  
  public native String getCpuFre();
  
  public native String getCpuNum();
  
  public native String getDeviceMx(Context paramContext);
  
  public native String getImei(Context paramContext);
  
  public native String getImsi(Context paramContext);
  
  public native String getMacAddress(Context paramContext);
  
  public native String getNetworkType(Context paramContext);
  
  public native String getOsVer();
  
  public native String getPackageName(Context paramContext);
  
  public native String getPhoneModel();
  
  public native String getResolution(Context paramContext);
  
  public native String getRomName();
  
  public native long getSDCardMemory();
  
  public native String getSDKVer();
  
  public native long getTotalMemory();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\CollectDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */