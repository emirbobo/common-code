package cn.domob.android.offerwall;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class f$a
{
  private static a a = new a();
  private static final long f = 600000L;
  private Location b;
  private int c = -1;
  private int d = -1;
  private boolean e = true;
  
  private Location a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (this.e) {
          continue;
        }
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        LocationManager localLocationManager;
        Object localObject1;
        paramContext = null;
        continue;
        paramContext = this.b;
        continue;
        Object localObject3 = null;
        continue;
        localObject3 = null;
        continue;
      }
      return paramContext;
      localLocationManager = (LocationManager)paramContext.getSystemService("location");
      if (localLocationManager != null)
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          continue;
        }
        localObject1 = localLocationManager.getLastKnownLocation("gps");
        if (localObject1 == null)
        {
          localObject1 = localLocationManager.getLastKnownLocation("network");
          if ((localObject1 != null) && (System.currentTimeMillis() - ((Location)localObject1).getTime() < 600000L))
          {
            this.c = 2;
            this.b = ((Location)localObject1);
            paramContext = (Context)localObject1;
          }
        }
        else if (System.currentTimeMillis() - ((Location)localObject1).getTime() < 600000L)
        {
          this.c = 0;
          this.b = ((Location)localObject1);
          paramContext = (Context)localObject1;
          continue;
        }
        if ((paramContext == null) || ((this.b != null) && (System.currentTimeMillis() <= this.b.getTime() + 600000L))) {
          continue;
        }
      }
      try
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
          f.f().b("Trying to get locations from the network.");
          localObject1 = new android/location/Criteria;
          ((Criteria)localObject1).<init>();
          ((Criteria)localObject1).setAccuracy(2);
          ((Criteria)localObject1).setCostAllowed(false);
          localObject1 = localLocationManager.getBestProvider((Criteria)localObject1, true);
          if (localObject1 == null)
          {
            f.f().b(f.class.getSimpleName(), "No location providers are available.  Ads will not be geotargeted.");
            this.d = 0;
            paramContext = null;
            continue;
          }
          f.f().b(f.class.getSimpleName(), "Location provider setup successfully.");
          b localb = new cn/domob/android/offerwall/f$a$b;
          localb.<init>(this, localLocationManager);
          localLocationManager.requestLocationUpdates((String)localObject1, 0L, 0.0F, localb, paramContext.getMainLooper());
          b(paramContext);
          this.d = 2;
          paramContext = null;
          continue;
        }
      }
      finally {}
    }
  }
  
  protected static a a()
  {
    return a;
  }
  
  private String a(Location paramLocation)
  {
    String str = null;
    if (paramLocation != null)
    {
      str = paramLocation.getLatitude() + "," + paramLocation.getLongitude();
      f.f().b(f.class.getSimpleName(), "User coordinates are " + str);
    }
    return str;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Exception
  {
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("version", "1.1.0");
    ((JSONObject)localObject1).put("host", "maps.google.com");
    ((JSONObject)localObject1).put("request_address", true);
    Object localObject2 = new JSONArray();
    Object localObject3 = new JSONObject();
    ((JSONObject)localObject3).put("cell_id", paramInt1);
    ((JSONObject)localObject3).put("location_area_code", paramInt2);
    ((JSONObject)localObject3).put("mobile_country_code", paramInt4);
    ((JSONObject)localObject3).put("mobile_network_code", paramInt3);
    ((JSONArray)localObject2).put(localObject3);
    ((JSONObject)localObject1).put("cell_towers", localObject2);
    f.f().a("Location send:" + ((JSONObject)localObject1).toString());
    localObject3 = new DefaultHttpClient();
    localObject2 = new HttpPost("http://www.google.com/loc/json");
    ((HttpPost)localObject2).setEntity(new StringEntity(((JSONObject)localObject1).toString()));
    localObject1 = ((DefaultHttpClient)localObject3).execute((HttpUriRequest)localObject2).getEntity();
    if (localObject1 != null)
    {
      localObject3 = new BufferedReader(new InputStreamReader(((HttpEntity)localObject1).getContent()));
      localObject2 = new StringBuffer();
      for (localObject1 = ((BufferedReader)localObject3).readLine(); localObject1 != null; localObject1 = ((BufferedReader)localObject3).readLine()) {
        ((StringBuffer)localObject2).append((String)localObject1);
      }
      if (localObject2 != null)
      {
        localObject2 = new JSONObject(new JSONTokener(((StringBuffer)localObject2).toString()));
        if ((localObject2 != null) && (((JSONObject)localObject2).has("location")))
        {
          localObject1 = ((JSONObject)localObject2).optJSONObject("location").optString("longitude");
          localObject3 = ((JSONObject)localObject2).optJSONObject("location").optString("latitude");
          long l = System.currentTimeMillis();
          localObject2 = new Location("jizhan");
          ((Location)localObject2).setLongitude(Double.parseDouble((String)localObject1));
          ((Location)localObject2).setLatitude(Double.parseDouble((String)localObject3));
          ((Location)localObject2).setTime(l);
          a((Location)localObject2, 1);
        }
      }
    }
  }
  
  private void a(Location paramLocation, int paramInt)
  {
    this.b = paramLocation;
    this.c = paramInt;
  }
  
  private int b()
  {
    switch (this.c)
    {
    default: 
      f.f().b(f.class.getSimpleName(), "Unknown");
    }
    for (;;)
    {
      return this.c;
      f.f().b(f.class.getSimpleName(), "GPS");
      continue;
      f.f().b(f.class.getSimpleName(), "Base");
      continue;
      f.f().b(f.class.getSimpleName(), "Wifi");
    }
  }
  
  private void b(final Context paramContext)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        f.f().a(f.class.getSimpleName(), "getLocationBasedService");
        for (;;)
        {
          try
          {
            localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
            if (localTelephonyManager != null)
            {
              f.f().a(f.class.getSimpleName(), "tManager is not null");
              m localm = f.f();
              localObject = f.class.getSimpleName();
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localm.a(localObject, "Network Operator: " + localTelephonyManager.getNetworkOperator());
              if ((localTelephonyManager.getNetworkOperator() == null) || (localTelephonyManager.getNetworkOperator().length() < 5)) {}
            }
            switch (localTelephonyManager.getPhoneType())
            {
            default: 
              return;
            }
          }
          catch (Exception localException)
          {
            TelephonyManager localTelephonyManager;
            Object localObject;
            int j;
            int i;
            int k;
            int m;
            f.f().a(localException);
            continue;
          }
          localObject = (GsmCellLocation)localTelephonyManager.getCellLocation();
          if (localObject != null)
          {
            j = ((GsmCellLocation)localObject).getCid();
            i = ((GsmCellLocation)localObject).getLac();
            k = Integer.valueOf(localTelephonyManager.getNetworkOperator().substring(0, 3)).intValue();
            m = Integer.valueOf(localTelephonyManager.getNetworkOperator().substring(3, 5)).intValue();
            f.a.a(f.a.this, j, i, m, k);
          }
        }
      }
    }).start();
  }
  
  private int c()
  {
    switch (this.d)
    {
    }
    return this.d;
  }
  
  private long d()
  {
    if (this.b != null) {}
    for (long l = this.b.getTime();; l = 0L) {
      return l;
    }
  }
  
  private class a
  {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    
    private a() {}
  }
  
  private class b
    implements LocationListener
  {
    protected LocationManager a;
    
    b(LocationManager paramLocationManager)
    {
      this.a = paramLocationManager;
    }
    
    public final void onLocationChanged(Location paramLocation)
    {
      f.f().a(f.class.getSimpleName(), "onLocationChanged");
      f.a.a(f.a.this, paramLocation, 2);
      this.a.removeUpdates(this);
    }
    
    public final void onProviderDisabled(String paramString) {}
    
    public final void onProviderEnabled(String paramString) {}
    
    public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
  
  private class c
  {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    
    private c() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\f$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */