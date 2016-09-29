package com.ta.utdid2.android.utils;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class NetworkUtils
{
  public static final String DEFAULT_WIFI_ADDRESS = "00-00-00-00-00-00";
  public static final String WIFI = "Wi-Fi";
  
  static
  {
    JniLib.a(NetworkUtils.class, 1063);
  }
  
  private static native String _convertIntToIp(int paramInt);
  
  public static native String[] getNetworkState(Context paramContext);
  
  public static native String getWifiAddress(Context paramContext);
  
  public static native String getWifiIpAddress(Context paramContext);
  
  public static native boolean isConnectInternet(Context paramContext);
  
  public static native boolean isWifi(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */