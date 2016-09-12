package com.alipay.mobilesecuritysdk.model;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bangcle.andjni.JniLib;

public class SecLocationListener
  implements LocationListener
{
  static
  {
    JniLib.a(SecLocationListener.class, 45);
  }
  
  public native void onLocationChanged(Location paramLocation);
  
  public native void onProviderDisabled(String paramString);
  
  public native void onProviderEnabled(String paramString);
  
  public native void onStatusChanged(String paramString, int paramInt, Bundle paramBundle);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\model\SecLocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */