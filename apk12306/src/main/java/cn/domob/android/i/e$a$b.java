package cn.domob.android.i;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

class e$a$b
  implements LocationListener
{
  public LocationManager a;
  private boolean c = false;
  
  e$a$b(e.a parama, LocationManager paramLocationManager)
  {
    this.a = paramLocationManager;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null)
    {
      this.c = true;
      paramLocation = paramLocation.getProvider();
      if ((paramLocation != null) && (!paramLocation.equals("network")))
      {
        e.e().b("remove the listener of " + paramLocation);
        this.a.removeUpdates(this);
      }
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\e$a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */