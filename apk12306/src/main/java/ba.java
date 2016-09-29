import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Timer;

final class ba
  implements LocationListener
{
  ba(az paramaz) {}
  
  public final void onLocationChanged(Location paramLocation)
  {
    this.a.jdField_a_of_type_JavaUtilTimer.cancel();
    this.a.jdField_a_of_type_Bd.a(paramLocation);
    this.a.jdField_a_of_type_AndroidLocationLocationManager.removeUpdates(this);
    this.a.jdField_a_of_type_AndroidLocationLocationManager.removeUpdates(this.a.b);
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */