package cn.domob.wall.core.h;

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
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class b
{
  private static d a = new d(b.class.getSimpleName());
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
  private static String q;
  private static final String r = "unknown";
  private static final String s = "gprs";
  private static final String t = "wifi";
  
  protected static String A(Context paramContext)
  {
    int i2 = 0;
    JSONObject localJSONObject;
    try
    {
      ScanResult[] arrayOfScanResult;
      int i1;
      if ((f.b(paramContext)) && (f.c(paramContext)))
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getScanResults();
        arrayOfScanResult = new ScanResult[paramContext.size()];
        for (i1 = 0; i1 < paramContext.size(); i1++) {
          arrayOfScanResult[i1] = ((ScanResult)paramContext.get(i1));
        }
        paramContext = new cn/domob/wall/core/h/b$1;
        paramContext.<init>();
        Arrays.sort(arrayOfScanResult, paramContext);
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        if (arrayOfScanResult.length <= 20) {
          i1 = arrayOfScanResult.length;
        }
      }
      while (i2 < i1)
      {
        paramContext = arrayOfScanResult[i2];
        String str = paramContext.BSSID;
        paramContext = paramContext.SSID;
        Object localObject;
        if (!f.a(str))
        {
          if (f.a(str)) {
            paramContext = "#";
          }
          localObject = paramContext;
          if (paramContext.length() > 16) {
            localObject = paramContext.substring(0, 16);
          }
        }
        try
        {
          paramContext = URLEncoder.encode((String)localObject, "UTF-8");
          localJSONObject.put(str, paramContext);
          i2++;
        }
        catch (UnsupportedEncodingException paramContext)
        {
          for (;;)
          {
            a.a(paramContext);
          }
        }
        continue;
        i1 = 20;
        continue;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      a.a(paramContext);
      paramContext = "";
    }
    for (;;)
    {
      paramContext = localJSONObject.toString();
    }
  }
  
  protected static String[] B(Context paramContext)
  {
    int i2 = -1;
    a.a(b.class.getSimpleName(), "getLocationBasedService");
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "-1";
    arrayOfString[1] = "-1";
    arrayOfString[2] = "-1";
    arrayOfString[3] = "-1";
    if ((!f.a(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) && (!f.a(paramContext, "android.permission.ACCESS_FINE_LOCATION")))
    {
      a.d("No permission to access locationBaseInfo");
      return arrayOfString;
    }
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          a.a(b.class.getSimpleName(), "tManager is not null");
          d locald = a;
          localObject = b.class.getSimpleName();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          locald.a(localObject, "Network Operator: " + paramContext.getNetworkOperator());
          i1 = paramContext.getPhoneType();
          localObject = paramContext.getCellLocation();
          if (localObject != null) {}
          switch (i1)
          {
          default: 
            a.b("无法获取基站信息");
            i1 = -1;
            arrayOfString[0] = String.valueOf(i2);
            arrayOfString[1] = String.valueOf(i1);
            if ((paramContext.getNetworkOperator() != null) && (paramContext.getNetworkOperator().length() >= 5))
            {
              i1 = Integer.valueOf(paramContext.getNetworkOperator().substring(0, 3)).intValue();
              i2 = Integer.valueOf(paramContext.getNetworkOperator().substring(3, 5)).intValue();
              arrayOfString[2] = String.valueOf(i1);
              arrayOfString[3] = String.valueOf(i2);
            }
            break;
          }
        }
      }
      catch (Exception paramContext)
      {
        Object localObject;
        int i1;
        a.a(paramContext);
        continue;
      }
      localObject = (GsmCellLocation)localObject;
      if (localObject != null)
      {
        i2 = ((GsmCellLocation)localObject).getCid();
        i1 = ((GsmCellLocation)localObject).getLac();
        continue;
        localObject = (CdmaCellLocation)localObject;
        if (localObject != null)
        {
          i2 = ((CdmaCellLocation)localObject).getBaseStationId();
          i1 = ((CdmaCellLocation)localObject).getNetworkId();
        }
      }
    }
  }
  
  public static String C(Context paramContext)
  {
    if ((l == null) && (e.a(9, true))) {}
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      paramContext = localClass.getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(localClass.newInstance(), new Object[] { paramContext });
      l = String.valueOf(paramContext.getClass().getMethod("getId", new Class[0]).invoke(paramContext, new Object[0]));
      return l;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  private static void D(Context paramContext)
  {
    a.b(b.class.getSimpleName(), "Start to get app info.");
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        if (localObject != null)
        {
          PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
          if (localPackageInfo != null)
          {
            b = localPackageInfo.packageName;
            c = localPackageInfo.versionCode;
            d = localPackageInfo.versionName;
          }
        }
        localObject = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
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
        a.e(b.class.getSimpleName(), "Failed in getting app info.");
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
    if (b == null)
    {
      D(paramContext);
      if (!f.g(b))
      {
        Log.i("DrwSDK", "Current package name is " + b);
        Log.i("DrwSDK", "SDK_VERSION:020100,SDK_BUILD_DATE:20140217");
      }
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
          d locald = a;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          locald.a("Already insalled pkgName = " + paramString);
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
      D(paramContext);
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
      D(paramContext);
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
      D(paramContext);
    }
    return e;
  }
  
  protected static long e()
  {
    return a.c(a.a());
  }
  
  protected static String e(Context paramContext)
  {
    if (k == null) {
      k = new WebView(paramContext).getSettings().getUserAgentString();
    }
    return k;
  }
  
  protected static String f()
  {
    return Locale.getDefault().getLanguage();
  }
  
  protected static List<String> f(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager().getInstalledPackages(0);
    paramContext = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (PackageInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = ((PackageInfo)localObject2).packageName;
          if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
            paramContext.add(localObject2);
          }
          a.b("the phone has been installed packageName: " + (String)localObject2);
        }
      }
    }
    return paramContext;
  }
  
  protected static int g()
  {
    return a.d(a.a());
  }
  
  protected static String g(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      }
      return f;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.e(b.class.getSimpleName(), "Failed to get android ID.");
        a.a(paramContext);
      }
    }
  }
  
  protected static String h(Context paramContext)
  {
    try
    {
      if (g == null) {
        g = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      return g;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.e(b.class.getSimpleName(), "Failed to get android ID.");
        a.a(paramContext);
      }
    }
  }
  
  protected static String i(Context paramContext)
  {
    if (h == null) {
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label34;
      }
    }
    label34:
    for (h = Build.VERSION.RELEASE.replace(",", "_");; h = "1.5") {
      return h;
    }
  }
  
  protected static String j(Context paramContext)
  {
    if ((i == null) && (Build.MODEL.length() > 0)) {
      i = Build.MODEL.replace(",", "_");
    }
    return i;
  }
  
  protected static String k(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(b.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
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
  
  protected static boolean l(Context paramContext)
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
  
  protected static String m(Context paramContext)
  {
    try
    {
      if (j == null) {
        j = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      }
      return j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  protected static String n(Context paramContext)
  {
    q = "v";
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if ((paramContext.getOrientation() == 1) || (paramContext.getOrientation() == 3)) {
      q = "h";
    }
    return q;
  }
  
  protected static float o(Context paramContext)
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
  
  protected static float p(Context paramContext)
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
  
  protected static int q(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      o = paramContext.getWidth();
    }
    return o;
  }
  
  protected static int r(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      p = paramContext.getHeight();
    }
    return p;
  }
  
  public static String s(Context paramContext)
  {
    Cursor localCursor = t(paramContext);
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
  
  public static Cursor t(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localObject = k(paramContext);
        if ((localObject == null) || (!((String)localObject).equals("wifi"))) {
          continue;
        }
        a.b("network is wifi, don't read apn.");
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        a.a(paramContext);
        paramContext = null;
        continue;
      }
      catch (Error paramContext)
      {
        a.a(paramContext);
        paramContext = null;
        continue;
      }
      return paramContext;
      localObject = Uri.parse("content://telephony/carriers/preferapn");
      paramContext = paramContext.getContentResolver().query((Uri)localObject, null, null, null, null);
    }
  }
  
  protected static String u(Context paramContext)
  {
    a locala = a.a();
    paramContext = a.a(locala, paramContext);
    if (paramContext != null) {}
    for (paramContext = a.a(locala, paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  protected static String v(Context paramContext)
  {
    if (f.b(paramContext)) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();; paramContext = null) {
      return paramContext;
    }
  }
  
  protected static String w(Context paramContext)
  {
    if ((f.b(paramContext)) && (f.c(paramContext))) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();; paramContext = null) {
      return paramContext;
    }
  }
  
  protected static String x(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext.getPhoneType() == 1)
    {
      paramContext = (GsmCellLocation)paramContext.getCellLocation();
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getLac() + "";; paramContext = "-1") {
      return paramContext;
    }
  }
  
  protected static String y(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext.getPhoneType() == 1)
    {
      paramContext = (GsmCellLocation)paramContext.getCellLocation();
      if (paramContext == null) {}
    }
    for (paramContext = paramContext.getCid() + "";; paramContext = "-1") {
      return paramContext;
    }
  }
  
  protected static String z(Context paramContext)
  {
    if ((f.b(paramContext)) && (f.c(paramContext))) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID();; paramContext = null) {
      return paramContext;
    }
  }
  
  private static class a
  {
    private static final a a = new a();
    private static final long e = 600000L;
    private static final int f = 120000;
    private static final int g = 1200000;
    private static final int h = 120000;
    private Location b;
    private int c = -1;
    private final boolean d = true;
    
    private Location a(Context paramContext)
    {
      Context localContext = paramContext.getApplicationContext();
      this.c = 2;
      if (localContext == null)
      {
        paramContext = null;
        return paramContext;
      }
      boolean bool2;
      LocationManager localLocationManager;
      try
      {
        bool2 = f.a(localContext, "android.permission.ACCESS_FINE_LOCATION");
        if ((bool2) || (f.a(localContext, "android.permission.ACCESS_COARSE_LOCATION")))
        {
          localLocationManager = (LocationManager)localContext.getSystemService("location");
          if (localLocationManager != null)
          {
            Iterator localIterator = localLocationManager.getProviders(true).iterator();
            while (localIterator.hasNext())
            {
              paramContext = localLocationManager.getLastKnownLocation((String)localIterator.next());
              if ((paramContext != null) && (a(paramContext, this.b)))
              {
                this.b = paramContext;
                continue;
                paramContext = this.b;
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        b.h().a(paramContext);
      }
      for (;;)
      {
        break;
        if ((this.b == null) || (System.currentTimeMillis() > this.b.getTime() + 300000L)) {
          a(localLocationManager, localContext);
        }
        if (this.b == null)
        {
          boolean bool1 = localLocationManager.isProviderEnabled("network");
          if ((localLocationManager == null) || ((!bool1) && (!bool2)) || ((!bool1) && (bool2) && (!localLocationManager.isProviderEnabled("gps"))))
          {
            this.c = 0;
            continue;
            this.c = 1;
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
        b.h().b(b.class.getSimpleName(), "User coordinates are " + str);
      }
      return str;
    }
    
    private void a(LocationManager paramLocationManager, Context paramContext)
    {
      if (paramLocationManager == null) {
        return;
      }
      for (;;)
      {
        String str;
        b localb;
        try
        {
          Object localObject = new android/location/Criteria;
          ((Criteria)localObject).<init>();
          ((Criteria)localObject).setAltitudeRequired(false);
          ((Criteria)localObject).setBearingRequired(false);
          ((Criteria)localObject).setSpeedRequired(false);
          ((Criteria)localObject).setCostAllowed(false);
          ((Criteria)localObject).setAccuracy(2);
          localObject = paramLocationManager.getProviders((Criteria)localObject, true).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = (String)((Iterator)localObject).next();
          localb = new cn/domob/wall/core/h/b$a$b;
          localb.<init>(this, paramLocationManager);
          d locald = b.h();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          locald.b(str + " start to listener position");
          paramLocationManager.requestLocationUpdates(str, 0L, 0.0F, localb, paramContext.getMainLooper());
          if (str.equals("network"))
          {
            a(paramLocationManager, localb, 1200000, str);
            continue;
          }
        }
        catch (Exception paramLocationManager)
        {
          b.h().a(paramLocationManager);
          break;
        }
        finally {}
        if (str.equals("gps")) {
          a(paramLocationManager, localb, 120000, str);
        }
      }
    }
    
    private void a(final LocationManager paramLocationManager, final LocationListener paramLocationListener, int paramInt, final String paramString)
    {
      new Timer().schedule(new TimerTask()
      {
        public void run()
        {
          paramLocationManager.removeUpdates(paramLocationListener);
          b.h().b(paramString + " stop listening position");
        }
      }, paramInt);
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
      int j;
      label103:
      int k;
      if (l1 > 120000L)
      {
        j = 1;
        if (l1 >= -120000L) {
          break label150;
        }
        k = 1;
        label115:
        if (l1 <= 0L) {
          break label156;
        }
      }
      label150:
      label156:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (j != 0) {
          break;
        }
        if (k == 0) {
          break label161;
        }
        bool1 = false;
        break;
        j = 0;
        break label103;
        k = 0;
        break label115;
      }
      label161:
      int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
      if (m > 0)
      {
        j = 1;
        label181:
        if (m >= 0) {
          break label266;
        }
        k = 1;
        label189:
        if (m <= 200) {
          break label272;
        }
      }
      label266:
      label272:
      for (m = 1;; m = 0)
      {
        boolean bool3 = a(paramLocation1.getProvider(), paramLocation2.getProvider());
        bool1 = bool2;
        if (k != 0) {
          break;
        }
        if (i != 0)
        {
          bool1 = bool2;
          if (j == 0) {
            break;
          }
        }
        if ((i != 0) && (m == 0))
        {
          bool1 = bool2;
          if (bool3) {
            break;
          }
        }
        bool1 = false;
        break;
        j = 0;
        break label181;
        k = 0;
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
    
    private int c()
    {
      String str;
      int i;
      if (this.b != null)
      {
        str = this.b.getProvider();
        b.h().b("This location is obtained via " + str);
        if (str != null) {
          if (str.equals("network")) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        return i;
        if (str.equals("gps")) {
          i = 0;
        } else if (str.equals("passive")) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    
    private int d()
    {
      if (this.b == null) {}
      for (int i = 0;; i = (int)this.b.getAccuracy())
      {
        b.h().b("location accuracy is " + i + " meters");
        return i;
      }
    }
    
    private int e()
    {
      switch (this.c)
      {
      }
      for (;;)
      {
        return this.c;
        b.h().b("Location can not be obtained due to USER_CLOSE");
        continue;
        b.h().b("Location can not be obtained due to NO_PERSSION");
        continue;
        b.h().b("Location can not be obtained due to NO_AVAILABLE_LOCATION");
      }
    }
    
    private long f()
    {
      long l1;
      if (this.b != null)
      {
        l1 = this.b.getTime();
        long l2 = (System.currentTimeMillis() - l1) / 1000L;
        b.h().b(b.class.getSimpleName(), String.format("The location is %s minutes %s seconds ago acquired", new Object[] { String.valueOf(l2 / 60L), String.valueOf(l2 % 60L) }));
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
      
      b(LocationManager paramLocationManager)
      {
        this.a = paramLocationManager;
      }
      
      public void onLocationChanged(Location paramLocation)
      {
        paramLocation = paramLocation.getProvider();
        if ((paramLocation != null) && (!paramLocation.equals("network")))
        {
          b.h().b(paramLocation + " get location successfully, and remove the listener");
          this.a.removeUpdates(this);
        }
        for (;;)
        {
          return;
          b.h().b(paramLocation + " get location successfully, do not remove the listener");
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */