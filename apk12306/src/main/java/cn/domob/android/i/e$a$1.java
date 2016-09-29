package cn.domob.android.i;

import android.location.LocationManager;
import java.util.TimerTask;

class e$a$1
  extends TimerTask
{
  e$a$1(e.a parama, String paramString, e.a.b paramb, LocationManager paramLocationManager) {}
  
  public void run()
  {
    if (this.a.equals("gps")) {
      e.a.a(this.d, this.b);
    }
    this.c.removeUpdates(this.b);
    e.e().b("remove the listener of " + this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\e$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */