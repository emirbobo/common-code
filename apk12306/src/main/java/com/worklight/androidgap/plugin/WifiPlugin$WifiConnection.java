package com.worklight.androidgap.plugin;

import com.bangcle.andjni.JniLib;

class WifiPlugin$WifiConnection
{
  private String MAC = null;
  private String SSID = null;
  
  static
  {
    JniLib.a(WifiConnection.class, 1209);
  }
  
  public WifiPlugin$WifiConnection(WifiPlugin paramWifiPlugin, String paramString1, String paramString2)
  {
    this.SSID = paramString1;
    this.MAC = paramString2;
  }
  
  public native String getMAC();
  
  public native String getSSID();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WifiPlugin$WifiConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */