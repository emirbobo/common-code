package com.worklight.androidgap.plugin;

import android.location.LocationManager;
import com.bangcle.andjni.JniLib;

public class WLGPSListener
  extends WLLocationListener
{
  static
  {
    JniLib.a(WLGPSListener.class, 1199);
  }
  
  public WLGPSListener(LocationManager paramLocationManager, WLGeolocationPlugin paramWLGeolocationPlugin)
  {
    super(paramLocationManager, paramWLGeolocationPlugin, "gps");
  }
  
  protected native void start();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLGPSListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */