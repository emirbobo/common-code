package cn.domob.android.i;

import android.location.LocationListener;
import android.location.LocationManager;
import java.util.TimerTask;

class c$a$1
  extends TimerTask
{
  c$a$1(c.a parama, LocationManager paramLocationManager, LocationListener paramLocationListener, String paramString) {}
  
  public void run()
  {
    this.a.removeUpdates(this.b);
    c.i().b(this.c + " stop listening position");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\c$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */