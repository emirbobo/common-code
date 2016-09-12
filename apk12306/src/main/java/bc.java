import android.location.Location;
import android.location.LocationManager;
import java.util.TimerTask;

final class bc
  extends TimerTask
{
  bc(az paramaz) {}
  
  public final void run()
  {
    this.a.jdField_a_of_type_AndroidLocationLocationManager.removeUpdates(this.a.jdField_a_of_type_AndroidLocationLocationListener);
    this.a.jdField_a_of_type_AndroidLocationLocationManager.removeUpdates(this.a.jdField_b_of_type_AndroidLocationLocationListener);
    if (this.a.jdField_a_of_type_Boolean) {}
    for (Location localLocation1 = this.a.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation("gps");; localLocation1 = null)
    {
      if (this.a.jdField_b_of_type_Boolean) {}
      for (Location localLocation2 = this.a.jdField_a_of_type_AndroidLocationLocationManager.getLastKnownLocation("network");; localLocation2 = null)
      {
        if ((localLocation1 != null) && (localLocation2 != null)) {
          if (localLocation1.getTime() > localLocation2.getTime()) {
            this.a.jdField_a_of_type_Bd.a(localLocation1);
          }
        }
        for (;;)
        {
          return;
          this.a.jdField_a_of_type_Bd.a(localLocation2);
          continue;
          if (localLocation1 != null) {
            this.a.jdField_a_of_type_Bd.a(localLocation1);
          } else if (localLocation2 != null) {
            this.a.jdField_a_of_type_Bd.a(localLocation2);
          } else {
            this.a.jdField_a_of_type_Bd.a(null);
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */