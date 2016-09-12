package cn.domob.android.offerwall;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class f
{
  private static m a = new m(f.class.getSimpleName());
  private static String b;
  private static int c = 0;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static float m = 0.0F;
  private static float n = 0.0F;
  private static int o = 0;
  private static int p = 0;
  private static int q = 0;
  private static int r = 0;
  private static String s;
  private static final String t = "sdk";
  private static final String u = "unknown";
  private static final String v = "gprs";
  private static final String w = "wifi";
  
  protected static String A(Context paramContext)
  {
    a locala = a.a();
    paramContext = a.a(locala, paramContext);
    if (paramContext != null) {}
    for (paramContext = a.a(locala, paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  private static void B(Context paramContext)
  {
    a.b(f.class.getSimpleName(), "Start to get app info.");
    for (;;)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null)
        {
          localObject = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
          if (localObject != null)
          {
            b = ((PackageInfo)localObject).packageName;
            c = ((PackageInfo)localObject).versionCode;
            d = ((PackageInfo)localObject).versionName;
          }
        }
        localObject = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
        if (localObject != null)
        {
          if (((ApplicationInfo)localObject).labelRes != 0) {
            e = paramContext.getResources().getString(((ApplicationInfo)localObject).labelRes);
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        a.e(f.class.getSimpleName(), "Failed in getting app info.");
        a.a(paramContext);
        continue;
        paramContext = ((ApplicationInfo)localObject).nonLocalizedLabel.toString();
        continue;
      }
      if (((ApplicationInfo)localObject).nonLocalizedLabel != null) {
        continue;
      }
      paramContext = null;
      e = paramContext;
    }
  }
  
  protected static String a()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject1 = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      localObject1 = localInetAddress.getHostAddress().toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        a.a(localException);
        Object localObject2 = null;
      }
    }
    return (String)localObject1;
  }
  
  protected static String a(Context paramContext)
  {
    if (b == null) {
      B(paramContext);
    }
    return b;
  }
  
  protected static boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {
      if (Build.VERSION.SDK_INT >= paramInt) {
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      return paramBoolean;
      paramBoolean = false;
      continue;
      paramBoolean = bool;
      if (Build.VERSION.SDK_INT <= paramInt) {
        paramBoolean = false;
      }
    }
  }
  
  protected static boolean a(Context paramContext, String paramString)
  {
    boolean bool = true;
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (;;)
    {
      try
      {
        if (paramContext.getPackageManager().getPackageInfo(paramString, 1) != null)
        {
          m localm = a;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          localm.a("Already insalled pkgName = " + paramString);
          return bool;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
      bool = false;
    }
  }
  
  protected static int b(Context paramContext)
  {
    if (b == null) {
      B(paramContext);
    }
    return c;
  }
  
  protected static String b()
  {
    return new SimpleDateFormat("Z").format(new Date());
  }
  
  protected static int c()
  {
    return a.a(a.a());
  }
  
  protected static String c(Context paramContext)
  {
    if (b == null) {
      B(paramContext);
    }
    return d;
  }
  
  protected static int d()
  {
    return a.b(a.a());
  }
  
  protected static String d(Context paramContext)
  {
    if (b == null) {
      B(paramContext);
    }
    return e;
  }
  
  protected static long e()
  {
    return a.c(a.a());
  }
  
  protected static String e(Context paramContext)
  {
    StringBuffer localStringBuffer;
    if (l == null)
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("android");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label204;
      }
      localStringBuffer.append(Build.VERSION.RELEASE.replaceAll(",", "_"));
    }
    for (;;)
    {
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      String str = Build.MODEL;
      if (str.length() > 0) {
        localStringBuffer.append(str.replaceAll(",", "_"));
      }
      localStringBuffer.append(",");
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      if (paramContext != null) {
        localStringBuffer.append(paramContext.replaceAll(",", "_"));
      }
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      l = localStringBuffer.toString();
      a.b(l.class.getSimpleName(), "getUserAgent:" + l);
      return l;
      label204:
      localStringBuffer.append("1.5");
    }
  }
  
  protected static String f(Context paramContext)
  {
    if (f == null)
    {
      if (!g(paramContext)) {
        break label32;
      }
      a.b("Use emulator id");
    }
    for (f = "-1,-1,emulator";; f = j(paramContext))
    {
      return f;
      label32:
      a.b("Generate device id");
    }
  }
  
  protected static boolean g(Context paramContext)
  {
    if (h == null) {
      h = l(paramContext);
    }
    if ((h == null) && (i(paramContext)) && ("sdk".equalsIgnoreCase(Build.MODEL))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected static boolean h(Context paramContext)
  {
    if ((i(paramContext)) && ("sdk".equalsIgnoreCase(Build.MODEL))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected static boolean i(Context paramContext)
  {
    paramContext = k(paramContext);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = paramContext.replaceAll("0", "").equals("")) {
      return bool;
    }
  }
  
  protected static String j(Context paramContext)
  {
    a.b("Start to generate device id");
    localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        String str = k(paramContext);
        if (str == null) {
          continue;
        }
        localStringBuffer.append(str);
        localStringBuffer.append(",");
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (str == null) {
          continue;
        }
        localStringBuffer.append(str);
      }
      catch (SecurityException localSecurityException)
      {
        a.a(localSecurityException);
        Log.e("DomobSDK", "you must set READ_PHONE_STATE permisson in AndroidManifest.xml");
        continue;
        localStringBuffer.append("-1");
        continue;
      }
      catch (Exception localException)
      {
        a.a(localException);
        continue;
        a.a("Android ID is null, use -1 instead");
        localStringBuffer.append("-1");
        continue;
      }
      localStringBuffer.append(",");
      paramContext = l(paramContext);
      if (paramContext == null) {
        continue;
      }
      localStringBuffer.append(paramContext);
      a.b("Generated device id: " + localStringBuffer.toString());
      return localStringBuffer.toString();
      localStringBuffer.append("-1");
    }
  }
  
  protected static String k(Context paramContext)
  {
    try
    {
      if (g == null) {
        g = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      }
      return g;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.e(f.class.getSimpleName(), "Failed to get android ID.");
        a.a(paramContext);
      }
    }
  }
  
  protected static String l(Context paramContext)
  {
    try
    {
      if (h == null) {
        h = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      return h;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.e(f.class.getSimpleName(), "Failed to get android ID.");
        a.a(paramContext);
      }
    }
  }
  
  protected static String m(Context paramContext)
  {
    if (i == null) {
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label33;
      }
    }
    label33:
    for (i = Build.VERSION.RELEASE.replace(",", "_");; i = "1.5") {
      return i;
    }
  }
  
  protected static String n(Context paramContext)
  {
    if ((j == null) && (Build.MODEL.length() > 0)) {
      j = Build.MODEL.replace(",", "_");
    }
    return j;
  }
  
  protected static String o(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(f.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i1 = paramContext.getType();
        if (i1 == 0)
        {
          String str = paramContext.getSubtypeName();
          paramContext = str;
          if (str != null) {
            continue;
          }
          paramContext = "gprs";
          continue;
        }
        if (i1 == 1)
        {
          paramContext = "wifi";
          continue;
        }
      }
      paramContext = "unknown";
    }
  }
  
  protected static boolean p(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        bool = paramContext.isConnected();
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        a.a(paramContext);
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  protected static String q(Context paramContext)
  {
    try
    {
      if (k == null) {
        k = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      }
      return k;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  protected static String r(Context paramContext)
  {
    s = "v";
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if ((paramContext.getOrientation() == 1) || (paramContext.getOrientation() == 3)) {
      s = "h";
    }
    return s;
  }
  
  protected static float s(Context paramContext)
  {
    try
    {
      if (m == 0.0F)
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new android/util/DisplayMetrics;
        localDisplayMetrics.<init>();
        paramContext.getMetrics(localDisplayMetrics);
        m = localDisplayMetrics.density;
      }
      return m;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  protected static float t(Context paramContext)
  {
    try
    {
      if (n == 0.0F) {
        n = paramContext.getResources().getDisplayMetrics().density;
      }
      return n;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  protected static int u(Context paramContext)
  {
    o = Math.round(w(paramContext) * (s(paramContext) / t(paramContext)));
    return o;
  }
  
  protected static int v(Context paramContext)
  {
    p = Math.round(x(paramContext) * (s(paramContext) / t(paramContext)));
    return p;
  }
  
  protected static int w(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      q = paramContext.getWidth();
    }
    return q;
  }
  
  protected static int x(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      r = paramContext.getHeight();
    }
    return r;
  }
  
  protected static String y(Context paramContext)
  {
    Cursor localCursor = z(paramContext);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      paramContext = localCursor.getString(localCursor.getColumnIndexOrThrow("apn"));
      localCursor.close();
    }
    for (;;)
    {
      return paramContext;
      paramContext = "";
    }
  }
  
  protected static Cursor z(Context paramContext)
  {
    Uri localUri = null;
    String str = o(paramContext);
    if ((str != null) && (str.equals("wifi"))) {
      a.b("network is wifi, don't read apn.");
    }
    for (paramContext = localUri;; paramContext = paramContext.getContentResolver().query(localUri, null, null, null, null))
    {
      return paramContext;
      localUri = Uri.parse("content://telephony/carriers/preferapn");
    }
  }
  
  private static class a
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */