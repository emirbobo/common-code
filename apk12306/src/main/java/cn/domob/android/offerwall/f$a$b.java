package cn.domob.android.offerwall;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

class f$a$b
  implements LocationListener
{
  protected LocationManager a;
  
  f$a$b(f.a parama, LocationManager paramLocationManager)
  {
    this.a = paramLocationManager;
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    f.f().a(f.class.getSimpleName(), "onLocationChanged");
    f.a.a(this.b, paramLocation, 2);
    this.a.removeUpdates(this);
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\f$a$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */