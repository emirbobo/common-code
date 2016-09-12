package cn.domob.android.b;

import android.location.LocationListener;
import android.location.LocationManager;
import cn.domob.android.i.f;
import java.util.TimerTask;

class b$a$1
  extends TimerTask
{
  b$a$1(b.a parama, LocationManager paramLocationManager, LocationListener paramLocationListener, String paramString) {}
  
  public void run()
  {
    this.a.removeUpdates(this.b);
    b.h().b(this.c + " stop listening position");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\b\b$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */