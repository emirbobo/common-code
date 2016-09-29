package cn.domob.android.i;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

class c$a$b
  implements LocationListener
{
  public LocationManager a;
  
  c$a$b(c.a parama, LocationManager paramLocationManager)
  {
    this.a = paramLocationManager;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    paramLocation = paramLocation.getProvider();
    if ((paramLocation != null) && (!paramLocation.equals("network")))
    {
      c.i().b(paramLocation + " get location successfully, and remove the listener");
      this.a.removeUpdates(this);
    }
    for (;;)
    {
      return;
      c.i().b(paramLocation + " get location successfully, do not remove the listener");
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\c$a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */