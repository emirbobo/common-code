package org.apache.cordova;

import android.location.LocationManager;

public class GPSListener
  extends CordovaLocationListener
{
  public GPSListener(LocationManager paramLocationManager, GeoBroker paramGeoBroker)
  {
    super(paramLocationManager, paramGeoBroker, "[Cordova GPSListener]");
  }
  
  protected void start()
  {
    if (!this.running)
    {
      if (this.locationManager.getProvider("gps") == null) {
        break label39;
      }
      this.running = true;
      this.locationManager.requestLocationUpdates("gps", 60000L, 0.0F, this);
    }
    for (;;)
    {
      return;
      label39:
      fail(CordovaLocationListener.POSITION_UNAVAILABLE, "GPS provider is not available.");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\GPSListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */