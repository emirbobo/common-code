package cn.domob.android.i;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
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
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
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

public class c
{
  private static f a = new f(c.class.getSimpleName());
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
  private static String m;
  private static Boolean n;
  private static float o = 0.0F;
  private static float p = 0.0F;
  private static int q = 0;
  private static int r = 0;
  private static String s;
  private static String t;
  private static final String u = "unknown";
  private static final String v = "gprs";
  private static final String w = "wifi";
  private static final String x = "com.android.browser";
  private static final String y = "com.google.android.browser";
  private static final String z = "com.android.browser.BrowserActivity";
  
  public static Boolean A(Context paramContext)
  {
    if (n != null) {
      paramContext = n;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramContext = paramContext.getResources().getConfiguration();
          n = (Boolean)paramContext.getClass().getMethod("isLayoutSizeAtLeast", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(4) });
        }
        if (n == null) {
          n = Boolean.valueOf(false);
        }
        paramContext = n;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          a.a(paramContext);
        }
      }
    }
  }
  
  public static String B(Context paramContext)
  {
    if ((i == null) && (a(9, true))) {}
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      paramContext = localClass.getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(localClass.newInstance(), new Object[] { paramContext });
      i = String.valueOf(paramContext.getClass().getMethod("getId", new Class[0]).invoke(paramContext, new Object[0]));
      return i;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static int C(Context paramContext)
  {
    Rect localRect;
    int i2;
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getWindow();
      localRect = new Rect();
      paramContext.getDecorView().getWindowVisibleDisplayFrame(localRect);
      i2 = localRect.top;
      i1 = paramContext.findViewById(16908290).getTop();
    }
    for (int i1 = localRect.height() - (i1 - i2);; i1 = 0) {
      return i1;
    }
  }
  
  public static boolean D(Context paramContext)
  {
    try
    {
      bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        boolean bool = true;
      }
    }
  }
  
  public static boolean E(Context paramContext)
  {
    if (((WifiManager)paramContext.getSystemService("wifi")).getWifiState() == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String F(Context paramContext)
  {
    StringBuffer localStringBuffer;
    if (t == null)
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("android");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label186;
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
      paramContext = m(paramContext);
      if (paramContext != null) {
        localStringBuffer.append(paramContext.replaceAll(",", "_"));
      }
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      t = localStringBuffer.toString();
      a.b("getUserAgent:" + t);
      return t;
      label186:
      localStringBuffer.append("1.5");
    }
  }
  
  private static void G(Context paramContext)
  {
    a.b(c.class.getSimpleName(), "Start to get app info.");
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
        a.e(c.class.getSimpleName(), "Failed in getting app info.");
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
  
  public static Intent a(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (paramUri != null)
      {
        if (!a(paramContext, "com.android.browser")) {
          break label62;
        }
        paramUri = new Intent("android.intent.action.VIEW", paramUri);
        paramUri.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
      }
    }
    for (;;)
    {
      if (paramContext.getPackageManager().resolveActivity(paramUri, 65536) == null) {}
      for (localObject1 = localObject2;; localObject1 = paramUri)
      {
        return (Intent)localObject1;
        label62:
        if (!a(paramContext, "com.google.android.browser")) {
          break label100;
        }
        paramUri = new Intent("android.intent.action.VIEW", paramUri);
        paramUri.setClassName("com.google.android.browser", "com.android.browser.BrowserActivity");
        break;
      }
      label100:
      paramUri = null;
    }
  }
  
  public static String a()
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
  
  public static String a(Context paramContext)
  {
    if (b == null)
    {
      G(paramContext);
      if (!h.e(b)) {
        Log.i(f.b(), "Current package name is " + b);
      }
    }
    return b;
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
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
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = true;
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (;;)
    {
      try
      {
        if (paramContext.getPackageManager().getPackageInfo(paramString, 1) != null)
        {
          paramContext = a;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          paramContext.a("Already insalled pkgName = " + paramString);
          return bool;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
      bool = false;
    }
  }
  
  public static int b(Context paramContext)
  {
    if (b == null) {
      G(paramContext);
    }
    return c;
  }
  
  public static String b()
  {
    return new SimpleDateFormat("Z").format(new Date());
  }
  
  public static int c()
  {
    return a.a(a.a());
  }
  
  public static String c(Context paramContext)
  {
    if (b == null) {
      G(paramContext);
    }
    return d;
  }
  
  public static int d()
  {
    return a.b(a.a());
  }
  
  public static String d(Context paramContext)
  {
    if (b == null) {
      G(paramContext);
    }
    return e;
  }
  
  public static int e()
  {
    return a.c(a.a());
  }
  
  public static String e(Context paramContext)
  {
    if (m == null) {
      m = new WebView(paramContext).getSettings().getUserAgentString();
    }
    return m;
  }
  
  public static long f()
  {
    return a.d(a.a());
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      if (g == null) {
        g = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      }
      return g;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.e("Failed to get IMSI.");
        a.a(paramContext);
      }
    }
  }
  
  public static String g()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String g(Context paramContext)
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
        a.e(c.class.getSimpleName(), "Failed to get IMEI.");
        a.a(paramContext);
      }
    }
  }
  
  public static String h(Context paramContext)
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
        a.e(c.class.getSimpleName(), "Failed to get android ID.");
        a.a(paramContext);
      }
    }
  }
  
  public static boolean h()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String i(Context paramContext)
  {
    if (j == null) {
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label32;
      }
    }
    label32:
    for (j = Build.VERSION.RELEASE.replace(",", "_");; j = "1.5") {
      return j;
    }
  }
  
  public static String j(Context paramContext)
  {
    if ((k == null) && (Build.MODEL.length() > 0)) {
      k = Build.MODEL.replace(",", "_");
    }
    return k;
  }
  
  public static String k(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(c.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
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
  
  public static boolean l(Context paramContext)
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
  
  public static String m(Context paramContext)
  {
    try
    {
      if (l == null) {
        l = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      }
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
  
  public static String n(Context paramContext)
  {
    s = "v";
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if ((paramContext.getOrientation() == 1) || (paramContext.getOrientation() == 3)) {
      s = "h";
    }
    return s;
  }
  
  public static float o(Context paramContext)
  {
    try
    {
      if (o == 0.0F)
      {
        Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        paramContext = new android/util/DisplayMetrics;
        paramContext.<init>();
        localDisplay.getMetrics(paramContext);
        o = paramContext.density;
      }
      return o;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  public static float p(Context paramContext)
  {
    try
    {
      if (p == 0.0F) {
        p = paramContext.getResources().getDisplayMetrics().density;
      }
      return p;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  public static int q(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      q = paramContext.getWidth();
    }
    return q;
  }
  
  public static int r(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      r = paramContext.getHeight();
    }
    return r;
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
  
  public static String u(Context paramContext)
  {
    a locala = a.a();
    paramContext = a.a(locala, paramContext);
    if (paramContext != null) {}
    for (paramContext = a.a(locala, paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  public static String v(Context paramContext)
  {
    if (a.e(paramContext)) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();; paramContext = null) {
      return paramContext;
    }
  }
  
  public static String w(Context paramContext)
  {
    if ((a.e(paramContext)) && (E(paramContext))) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();; paramContext = null) {
      return paramContext;
    }
  }
  
  public static String x(Context paramContext)
  {
    if ((a.e(paramContext)) && (E(paramContext))) {}
    for (paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID();; paramContext = null) {
      return paramContext;
    }
  }
  
  public static String y(Context paramContext)
  {
    int i2 = 0;
    try
    {
      if ((!a.e(paramContext)) || (!E(paramContext))) {
        break label205;
      }
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getScanResults();
      ScanResult[] arrayOfScanResult = new ScanResult[paramContext.size()];
      for (int i1 = 0; i1 < paramContext.size(); i1++) {
        arrayOfScanResult[i1] = ((ScanResult)paramContext.get(i1));
      }
      paramContext = new cn/domob/android/i/c$1;
      paramContext.<init>();
      Arrays.sort(arrayOfScanResult, paramContext);
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      if (arrayOfScanResult.length <= 20) {
        i1 = arrayOfScanResult.length;
      }
      while (i2 < i1)
      {
        paramContext = arrayOfScanResult[i2];
        String str = paramContext.BSSID;
        paramContext = paramContext.SSID;
        if (!h.e(str))
        {
          if (h.e(str)) {
            paramContext = "#";
          }
          Object localObject = paramContext;
          if (paramContext.length() > 16) {
            localObject = paramContext.substring(0, 16);
          }
          localJSONObject.put(str, localObject);
        }
        i2++;
        continue;
        i1 = 20;
      }
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String[] z(Context paramContext)
  {
    int i2 = -1;
    a.a(c.class.getSimpleName(), "getLocationBasedService");
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "-1";
    arrayOfString[1] = "-1";
    arrayOfString[2] = "-1";
    arrayOfString[3] = "-1";
    if ((!a.a(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) && (!a.a(paramContext, "android.permission.ACCESS_FINE_LOCATION")))
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
          a.a(c.class.getSimpleName(), "tManager is not null");
          localObject = a;
          String str = c.class.getSimpleName();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          ((f)localObject).a(str, "Network Operator: " + paramContext.getNetworkOperator());
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
              i2 = Integer.valueOf(paramContext.getNetworkOperator().substring(0, 3)).intValue();
              i1 = Integer.valueOf(paramContext.getNetworkOperator().substring(3, 5)).intValue();
              arrayOfString[2] = String.valueOf(i2);
              arrayOfString[3] = String.valueOf(i1);
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
      try
      {
        bool2 = a.a(localContext, "android.permission.ACCESS_FINE_LOCATION");
        if ((bool2) || (a.a(localContext, "android.permission.ACCESS_COARSE_LOCATION")))
        {
          paramContext = (LocationManager)localContext.getSystemService("location");
          if (paramContext != null)
          {
            Iterator localIterator = paramContext.getProviders(true).iterator();
            while (localIterator.hasNext())
            {
              Location localLocation = paramContext.getLastKnownLocation((String)localIterator.next());
              if ((localLocation != null) && (a(localLocation, this.b)))
              {
                this.b = localLocation;
                continue;
                paramContext = this.b;
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        c.i().a(paramContext);
      }
      for (;;)
      {
        break;
        if ((this.b == null) || (System.currentTimeMillis() > this.b.getTime() + 300000L)) {
          a(paramContext, localContext);
        }
        if (this.b == null)
        {
          boolean bool1 = paramContext.isProviderEnabled("network");
          if ((paramContext == null) || ((!bool1) && (!bool2)) || ((!bool1) && (bool2) && (!paramContext.isProviderEnabled("gps"))))
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
        c.i().b(c.class.getSimpleName(), "User coordinates are " + str);
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
        Object localObject;
        b localb;
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
          localb = new cn/domob/android/i/c$a$b;
          localb.<init>(this, paramLocationManager);
          f localf = c.i();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localf.b((String)localObject + " start to listener position");
          paramLocationManager.requestLocationUpdates((String)localObject, 0L, 0.0F, localb, paramContext.getMainLooper());
          if (((String)localObject).equals("network"))
          {
            a(paramLocationManager, localb, 1200000, (String)localObject);
            continue;
          }
        }
        catch (Exception paramLocationManager)
        {
          c.i().a(paramLocationManager);
          break;
        }
        finally {}
        if (((String)localObject).equals("gps")) {
          a(paramLocationManager, localb, 120000, (String)localObject);
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
          c.i().b(paramString + " stop listening position");
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
        l1 = System.currentTimeMillis() - paramLocation1.getTime();
        long l2 = System.currentTimeMillis() - paramLocation2.getTime();
        if (l1 <= 600000L)
        {
          bool1 = bool2;
          if (l2 > 600000L) {}
        }
        else
        {
          if ((l1 <= 600000L) || (l2 > 600000L)) {
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
        c.i().b("This location is obtained via " + str);
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
        c.i().b("location accuracy is " + i + " meters");
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
        c.i().b("Location can not be obtained due to USER_CLOSE");
        continue;
        c.i().b("Location can not be obtained due to NO_PERSSION");
        continue;
        c.i().b("Location can not be obtained due to NO_AVAILABLE_LOCATION");
      }
    }
    
    private long f()
    {
      long l1;
      if (this.b != null)
      {
        l1 = this.b.getTime();
        long l2 = (System.currentTimeMillis() - l1) / 1000L;
        c.i().b(c.class.getSimpleName(), String.format("The location is %s minutes %s seconds ago acquired", new Object[] { String.valueOf(l2 / 60L), String.valueOf(l2 % 60L) }));
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
          c.i().b(paramLocation + " get location successfully, and remove the listener");
          this.a.removeUpdates(this);
        }
        for (;;)
        {
          return;
          c.i().b(paramLocation + " get location successfully, do not remove the listener");
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */