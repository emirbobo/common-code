import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

final class bg
  implements Runnable
{
  bg(be parambe, Location paramLocation) {}
  
  public final void run()
  {
    Object localObject = new ArrayList();
    String str = this.jdField_a_of_type_Be.a();
    if ("".equals(str)) {}
    for (;;)
    {
      return;
      ((List)localObject).add(new BasicNameValuePair("device_id", str));
      ((List)localObject).add(new BasicNameValuePair("device_type", "android"));
      ((List)localObject).add(new BasicNameValuePair("an_sdk", "2.25.3"));
      ((List)localObject).add(new BasicNameValuePair("lat", String.valueOf(this.jdField_a_of_type_AndroidLocationLocation.getLatitude())));
      ((List)localObject).add(new BasicNameValuePair("lng", String.valueOf(this.jdField_a_of_type_AndroidLocationLocation.getLongitude())));
      ((List)localObject).add(new BasicNameValuePair("acc", String.valueOf(this.jdField_a_of_type_AndroidLocationLocation.getAccuracy())));
      ((List)localObject).add(new BasicNameValuePair("provider", String.valueOf(this.jdField_a_of_type_AndroidLocationLocation.getProvider())));
      ((List)localObject).add(new BasicNameValuePair("alt", String.valueOf(this.jdField_a_of_type_AndroidLocationLocation.getAltitude())));
      be.a(this.jdField_a_of_type_Be, be.c(this.jdField_a_of_type_Be) + "?key=" + be.b(this.jdField_a_of_type_Be), "POST", (List)localObject);
      localObject = be.a(this.jdField_a_of_type_Be).getSharedPreferences(be.b(), 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("com.arrownock.internal.device.LAST_LOCATION_REPORT", Calendar.getInstance().getTimeInMillis());
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */