package com.worklight.androidgap.plugin;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.NetworkManager;

public class WLNetworkManager
  extends NetworkManager
{
  static
  {
    JniLib.a(WLNetworkManager.class, 1203);
  }
  
  public native boolean isSynch(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLNetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */