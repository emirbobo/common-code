package cn.domob.android.i;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class e$a
{
  private static final a a = new a();
  private static final int b = 3;
  private static final int c = 600000;
  private static volatile int d = 0;
  private static volatile long e = 0L;
  private static final long f = 600000L;
  private static final int g = 120000;
  private static final int h = 1200000;
  private static final int i = 90000;
  private Location j;
  private int k = -1;
  
  private Location a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    this.k = 2;
    if (localContext == null)
    {
      paramContext = null;
      return paramContext;
    }
    boolean bool1;
    LocationManager localLocationManager;
    try
    {
      bool1 = a.a(localContext, "android.permission.ACCESS_FINE_LOCATION");
      if ((bool1) || (a.a(localContext, "android.permission.ACCESS_COARSE_LOCATION")))
      {
        localLocationManager = (LocationManager)localContext.getSystemService("location");
        if (localLocationManager != null)
        {
          Iterator localIterator = localLocationManager.getProviders(true).iterator();
          while (localIterator.hasNext())
          {
            paramContext = localLocationManager.getLastKnownLocation((String)localIterator.next());
            if ((paramContext != null) && (a(paramContext, this.j)))
            {
              this.j = paramContext;
              continue;
              paramContext = this.j;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      e.e().a(paramContext);
    }
    for (;;)
    {
      break;
      if ((this.j == null) || (System.currentTimeMillis() > this.j.getTime() + 300000L)) {
        a(localLocationManager, localContext);
      }
      if (this.j == null)
      {
        boolean bool2 = localLocationManager.isProviderEnabled("network");
        if ((localLocationManager == null) || ((!bool2) && (!bool1)) || ((!bool2) && (bool1) && (!localLocationManager.isProviderEnabled("gps"))))
        {
          this.k = 0;
          continue;
          this.k = 1;
        }
      }
    }
  }
  
  private String a(Location paramLocation)
  {
    String str = null;
    if (paramLocation != null)
    {
      str = paramLocation.getLatitude() + "," + paramLocation.getLongitude();
      e.e().b(c.class.getSimpleName(), "User coordinates are " + str);
    }
    return str;
  }
  
  private void a(Context paramContext, LocationManager paramLocationManager, String paramString)
  {
    b localb = new b(paramLocationManager);
    e.e().b(paramString + " start to listener position");
    paramLocationManager.requestLocationUpdates(paramString, 0L, 0.0F, localb, paramContext.getMainLooper());
    if (paramString.equals("network")) {
      a(paramLocationManager, localb, 1200000, paramString);
    }
    for (;;)
    {
      return;
      if (paramString.equals("gps")) {
        a(paramLocationManager, localb, 90000, paramString);
      }
    }
  }
  
  private void a(LocationManager paramLocationManager, Context paramContext)
  {
    if (paramLocationManager == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new android/location/Criteria;
        ((Criteria)localObject).<init>();
        ((Criteria)localObject).setAltitudeRequired(false);
        ((Criteria)localObject).setBearingRequired(false);
        ((Criteria)localObject).setSpeedRequired(false);
        ((Criteria)localObject).setCostAllowed(false);
        ((Criteria)localObject).setAccuracy(2);
        Iterator localIterator = paramLocationManager.getProviders((Criteria)localObject, true).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        if (((String)localObject).equals("gps"))
        {
          if (!c()) {
            continue;
          }
          e = System.currentTimeMillis();
          a(paramContext, paramLocationManager, (String)localObject);
          continue;
        }
      }
      catch (Exception paramLocationManager)
      {
        e.e().a(paramLocationManager);
        break;
      }
      finally {}
      if ((((String)localObject).equals("network")) || (((String)localObject).equals("passive"))) {
        a(paramContext, paramLocationManager, (String)localObject);
      } else {
        e.e().b(String.format("Detected an unknown location provider %s, but taking into account security, there is no use.", new Object[] { localObject }));
      }
    }
  }
  
  private void a(final LocationManager paramLocationManager, final b paramb, int paramInt, final String paramString)
  {
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        if (paramString.equals("gps")) {
          e.a.a(e.a.this, paramb);
        }
        paramLocationManager.removeUpdates(paramb);
        e.e().b("remove the listener of " + paramString);
      }
    }, paramInt);
  }
  
  private void a(b paramb)
  {
    if (!paramb.a())
    {
      d += 1;
      e.e().b("gps locate failed, and the current total failed times is " + d);
    }
  }
  
  private boolean a(Location paramLocation1, Location paramLocation2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLocation2 == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      long l2 = System.currentTimeMillis() - paramLocation1.getTime();
      l1 = System.currentTimeMillis() - paramLocation2.getTime();
      if (l2 <= 600000L)
      {
        bool1 = bool2;
        if (l1 > 600000L) {}
      }
      else
      {
        if ((l2 <= 600000L) || (l1 > 600000L)) {
          break;
        }
        bool1 = false;
      }
    }
    long l1 = paramLocation1.getTime() - paramLocation2.getTime();
    int n;
    label103:
    int i1;
    if (l1 > 120000L)
    {
      n = 1;
      if (l1 >= -120000L) {
        break label150;
      }
      i1 = 1;
      label115:
      if (l1 <= 0L) {
        break label156;
      }
    }
    label150:
    label156:
    for (int m = 1;; m = 0)
    {
      bool1 = bool2;
      if (n != 0) {
        break;
      }
      if (i1 == 0) {
        break label161;
      }
      bool1 = false;
      break;
      n = 0;
      break label103;
      i1 = 0;
      break label115;
    }
    label161:
    int i2 = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    if (i2 > 0)
    {
      n = 1;
      label181:
      if (i2 >= 0) {
        break label266;
      }
      i1 = 1;
      label189:
      if (i2 <= 200) {
        break label272;
      }
    }
    label266:
    label272:
    for (i2 = 1;; i2 = 0)
    {
      boolean bool3 = a(paramLocation1.getProvider(), paramLocation2.getProvider());
      bool1 = bool2;
      if (i1 != 0) {
        break;
      }
      if (m != 0)
      {
        bool1 = bool2;
        if (n == 0) {
          break;
        }
      }
      if ((m != 0) && (i2 == 0))
      {
        bool1 = bool2;
        if (bool3) {
          break;
        }
      }
      bool1 = false;
      break;
      n = 0;
      break label181;
      i1 = 0;
      break label189;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramString1 == null) {
      if (paramString2 != null) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (paramString2 != null) {
        bool = paramString1.equals(paramString2);
      }
    }
  }
  
  private static a b()
  {
    return a;
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (3 <= d) {
      e.e().b(String.format("gps positioning has failed %d times, has reached or exceeded the maximum allowed number(%d) of failures", new Object[] { Integer.valueOf(d), Integer.valueOf(3) }));
    }
    for (;;)
    {
      return bool;
      if (System.currentTimeMillis() < e + 600000L) {
        e.e().b("Now can not be gps positioning, because just evoke gps positioning time");
      } else {
        bool = true;
      }
    }
  }
  
  private int d()
  {
    String str;
    int m;
    if (this.j != null)
    {
      str = this.j.getProvider();
      e.e().b("This location is obtained via " + str);
      if (str != null) {
        if (str.equals("network")) {
          m = 1;
        }
      }
    }
    for (;;)
    {
      return m;
      if (str.equals("gps")) {
        m = 0;
      } else if (str.equals("passive")) {
        m = 2;
      } else {
        m = 3;
      }
    }
  }
  
  private int e()
  {
    if (this.j == null) {}
    for (int m = 0;; m = (int)this.j.getAccuracy())
    {
      e.e().b("location accuracy is " + m + " meters");
      return m;
    }
  }
  
  private int f()
  {
    switch (this.k)
    {
    }
    for (;;)
    {
      return this.k;
      e.e().b("Location can not be obtained due to USER_CLOSE");
      continue;
      e.e().b("Location can not be obtained due to NO_PERSSION");
      continue;
      e.e().b("Location can not be obtained due to NO_AVAILABLE_LOCATION");
    }
  }
  
  private long g()
  {
    long l1;
    if (this.j != null)
    {
      l1 = this.j.getTime();
      long l2 = (System.currentTimeMillis() - l1) / 1000L;
      e.e().b(c.class.getSimpleName(), String.format("The location is %s minutes %s seconds ago acquired", new Object[] { String.valueOf(l2 / 60L), String.valueOf(l2 % 60L) }));
    }
    for (;;)
    {
      return l1;
      l1 = 0L;
    }
  }
  
  private class a
  {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    
    private a() {}
  }
  
  private class b
    implements LocationListener
  {
    public LocationManager a;
    private boolean c = false;
    
    b(LocationManager paramLocationManager)
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
  
  private class c
  {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    
    private c() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\e$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */