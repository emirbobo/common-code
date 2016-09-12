package cn.domob.android.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.Log;
import cn.domob.android.i.e;
import cn.domob.android.i.f;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class a
{
  protected static final String A = "locinfo";
  protected static final String B = "locacc";
  protected static final String C = "locaccmeters";
  protected static final String D = "locstatus";
  protected static final String E = "loctime";
  protected static final String F = "ama";
  protected static final String G = "ssid";
  protected static final String H = "ma";
  protected static final String I = "areacode";
  protected static final String J = "cellid";
  protected static final String K = "language";
  protected static final String L = "scan";
  protected static final String M = "istab";
  protected static final String N = "aaid";
  protected static final String O = "esh";
  private static f P = new f(a.class.getSimpleName());
  private static ArrayList<String> Q = new ArrayList();
  private static String R;
  private static int S = 0;
  private static int T = 0;
  private static String U;
  private static String V;
  private static final String W = "sdk";
  protected static final String a = "pkgname";
  protected static final String b = "vc";
  protected static final String c = "vn";
  protected static final String d = "appname";
  protected static final String e = "useragent";
  protected static final String f = "ua";
  protected static final String g = "install";
  protected static final String h = "idv";
  protected static final String i = "imei";
  protected static final String j = "imsi";
  protected static final String k = "andoidid";
  protected static final String l = "osv";
  protected static final String m = "devicemodel";
  protected static final String n = "networktype";
  protected static final String o = "networkavailable";
  protected static final String p = "ip";
  protected static final String q = "timezone";
  protected static final String r = "carrier";
  protected static final String s = "orientation";
  protected static final String t = "isemulator";
  protected static final String u = "rsd";
  protected static final String v = "csd";
  protected static final String w = "rsw";
  protected static final String x = "rsh";
  protected static final String y = "csw";
  protected static final String z = "csh";
  
  public static String A(Context paramContext)
  {
    if (Q.contains("ama")) {}
    for (paramContext = "";; paramContext = b.w(paramContext)) {
      return paramContext;
    }
  }
  
  public static String B(Context paramContext)
  {
    if (Q.contains("ssid")) {}
    for (paramContext = "";; paramContext = b.x(paramContext)) {
      return paramContext;
    }
  }
  
  public static String C(Context paramContext)
  {
    String str = "";
    if (!Q.contains("scan")) {
      str = b.y(paramContext);
    }
    return str;
  }
  
  public static String[] D(Context paramContext)
  {
    if ((Q.contains("areacode")) || (Q.contains("cellid")))
    {
      paramContext = new String[4];
      paramContext[0] = "-1";
      paramContext[1] = "-1";
      paramContext[2] = "-1";
      paramContext[3] = "-1";
    }
    for (;;)
    {
      return paramContext;
      paramContext = e.b(paramContext);
    }
  }
  
  public static boolean E(Context paramContext)
  {
    if (Q.contains("istab")) {}
    for (boolean bool = false;; bool = b.A(paramContext).booleanValue()) {
      return bool;
    }
  }
  
  public static boolean F(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1) {}
    for (boolean bool = false;; bool = true) {
      for (;;)
      {
        return bool;
        if (a(11, true)) {
          try
          {
            paramContext = ((Vibrator)paramContext.getSystemService("vibrator")).getClass();
            bool = String.valueOf(paramContext.getMethod("hasVibrator", new Class[0]).invoke(paramContext.newInstance(), new Object[0])).equals("false");
            if (bool) {
              bool = false;
            }
          }
          catch (Exception paramContext)
          {
            P.b("Android version of the device is less than 3.0, the interface is no mapping");
            P.a(paramContext);
          }
        }
      }
    }
  }
  
  public static String G(Context paramContext)
  {
    if (Q.contains("aaid")) {}
    for (paramContext = "";; paramContext = b.B(paramContext)) {
      return paramContext;
    }
  }
  
  public static int H(Context paramContext)
  {
    if (Q.contains("esh")) {}
    for (int i1 = 0;; i1 = b.C(paramContext)) {
      return i1;
    }
  }
  
  private static boolean I(Context paramContext)
  {
    paramContext = k(paramContext);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = paramContext.replaceAll("0", "").equals("")) {
      return bool;
    }
  }
  
  private static String J(Context paramContext)
  {
    P.b("Start to generate device id");
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
        str = j(paramContext);
        if (str == null) {
          continue;
        }
        localStringBuffer.append(str);
      }
      catch (SecurityException localSecurityException)
      {
        P.a(localSecurityException);
        Log.e(f.b(), "you must set READ_PHONE_STATE permisson in AndroidManifest.xml");
        continue;
        localStringBuffer.append("-1");
        continue;
      }
      catch (Exception localException)
      {
        P.a(localException);
        continue;
        P.a("Android ID is null, use -1 instead");
        localStringBuffer.append("-1");
        continue;
      }
      localStringBuffer.append(",");
      paramContext = l(paramContext);
      if (paramContext == null) {
        continue;
      }
      localStringBuffer.append(paramContext);
      P.b("Generated device id: " + localStringBuffer.toString());
      return localStringBuffer.toString();
      localStringBuffer.append("-1");
    }
  }
  
  public static String a(Context paramContext)
  {
    if (Q.contains("pkgname")) {}
    for (paramContext = "";; paramContext = b.a(paramContext)) {
      return paramContext;
    }
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      P.b("Turn off list: " + paramArrayList);
      Q = paramArrayList;
    }
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    return b.a(paramInt, paramBoolean);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Q.contains("install")) {}
    for (boolean bool = false;; bool = b.a(paramContext, paramString)) {
      return bool;
    }
  }
  
  public static int b(Context paramContext)
  {
    if (Q.contains("vc")) {}
    for (int i1 = -1;; i1 = b.b(paramContext)) {
      return i1;
    }
  }
  
  public static String b()
  {
    if (Q.contains("ip")) {}
    for (String str = "";; str = b.a()) {
      return str;
    }
  }
  
  public static String c()
  {
    if (Q.contains("timezone")) {}
    for (String str = "";; str = b.b()) {
      return str;
    }
  }
  
  public static String c(Context paramContext)
  {
    if (Q.contains("vn")) {}
    for (paramContext = "";; paramContext = b.c(paramContext)) {
      return paramContext;
    }
  }
  
  public static int d()
  {
    if (Q.contains("locacc")) {}
    for (int i1 = -1;; i1 = e.b()) {
      return i1;
    }
  }
  
  public static String d(Context paramContext)
  {
    if (Q.contains("appname")) {}
    for (paramContext = "";; paramContext = b.d(paramContext)) {
      return paramContext;
    }
  }
  
  public static int e()
  {
    if (Q.contains("locaccmeters")) {}
    for (int i1 = -1;; i1 = e.a()) {
      return i1;
    }
  }
  
  public static String e(Context paramContext)
  {
    if (Q.contains("useragent")) {}
    for (paramContext = "";; paramContext = b.e(paramContext)) {
      return paramContext;
    }
  }
  
  public static int f()
  {
    if (Q.contains("locstatus")) {}
    for (int i1 = -1;; i1 = e.c()) {
      return i1;
    }
  }
  
  public static String f(Context paramContext)
  {
    if (Q.contains("ua"))
    {
      paramContext = "";
      return paramContext;
    }
    StringBuffer localStringBuffer;
    if (R == null)
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("android");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label225;
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
      paramContext = q(paramContext);
      if (paramContext != null) {
        localStringBuffer.append(paramContext.replaceAll(",", "_"));
      }
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      R = localStringBuffer.toString();
      P.b(a.class.getSimpleName(), "getUserAgent:" + R);
      paramContext = R;
      break;
      label225:
      localStringBuffer.append("1.5");
    }
  }
  
  public static long g()
  {
    if (Q.contains("loctime")) {}
    for (long l1 = -1L;; l1 = e.d()) {
      return l1;
    }
  }
  
  public static String g(Context paramContext)
  {
    if (Q.contains("idv"))
    {
      paramContext = "";
      return paramContext;
    }
    if (V == null)
    {
      if (!h(paramContext)) {
        break label51;
      }
      P.b("Use emulator id");
    }
    for (V = "-1,-1,emulator";; V = J(paramContext))
    {
      paramContext = V;
      break;
      label51:
      P.b("Generate device id");
    }
  }
  
  public static String h()
  {
    if (Q.contains("language")) {}
    for (String str = "";; str = b.g()) {
      return str;
    }
  }
  
  public static boolean h(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (Q.contains("isemulator")) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (U == null) {
        U = l(paramContext);
      }
      bool1 = bool2;
      if (U == null)
      {
        bool1 = bool2;
        if (I(paramContext))
        {
          bool1 = bool2;
          if ("sdk".equalsIgnoreCase(Build.MODEL)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean i(Context paramContext)
  {
    if ((I(paramContext)) && ("sdk".equalsIgnoreCase(Build.MODEL))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String j(Context paramContext)
  {
    if (Q.contains("imsi")) {}
    for (paramContext = "-1";; paramContext = b.f(paramContext)) {
      return paramContext;
    }
  }
  
  public static String k(Context paramContext)
  {
    if (Q.contains("imei")) {}
    for (paramContext = "-1";; paramContext = b.g(paramContext)) {
      return paramContext;
    }
  }
  
  public static String l(Context paramContext)
  {
    if (Q.contains("andoidid")) {}
    for (paramContext = "-1";; paramContext = b.h(paramContext)) {
      return paramContext;
    }
  }
  
  public static String m(Context paramContext)
  {
    if (Q.contains("osv")) {}
    for (paramContext = "";; paramContext = b.i(paramContext)) {
      return paramContext;
    }
  }
  
  public static String n(Context paramContext)
  {
    if (Q.contains("devicemodel")) {}
    for (paramContext = "";; paramContext = b.j(paramContext)) {
      return paramContext;
    }
  }
  
  public static String o(Context paramContext)
  {
    if (Q.contains("networktype")) {}
    for (paramContext = "";; paramContext = b.k(paramContext)) {
      return paramContext;
    }
  }
  
  public static boolean p(Context paramContext)
  {
    if (Q.contains("networkavailable")) {}
    for (boolean bool = false;; bool = b.l(paramContext)) {
      return bool;
    }
  }
  
  public static String q(Context paramContext)
  {
    if (Q.contains("carrier")) {}
    for (paramContext = "";; paramContext = b.m(paramContext)) {
      return paramContext;
    }
  }
  
  public static String r(Context paramContext)
  {
    if (Q.contains("orientation")) {}
    for (paramContext = "";; paramContext = b.n(paramContext)) {
      return paramContext;
    }
  }
  
  public static float s(Context paramContext)
  {
    if (Q.contains("rsd")) {}
    for (float f1 = -1.0F;; f1 = b.o(paramContext)) {
      return f1;
    }
  }
  
  public static float t(Context paramContext)
  {
    if (Q.contains("csd")) {}
    for (float f1 = -1.0F;; f1 = b.p(paramContext)) {
      return f1;
    }
  }
  
  public static int u(Context paramContext)
  {
    if (Q.contains("rsw")) {}
    for (int i1 = -1;; i1 = S)
    {
      return i1;
      S = Math.round(w(paramContext) * (s(paramContext) / t(paramContext)));
    }
  }
  
  public static int v(Context paramContext)
  {
    if (Q.contains("rsh")) {}
    for (int i1 = -1;; i1 = T)
    {
      return i1;
      T = Math.round(x(paramContext) * (s(paramContext) / t(paramContext)));
    }
  }
  
  public static int w(Context paramContext)
  {
    if (Q.contains("csw")) {}
    for (int i1 = -1;; i1 = b.q(paramContext)) {
      return i1;
    }
  }
  
  public static int x(Context paramContext)
  {
    if (Q.contains("csh")) {}
    for (int i1 = -1;; i1 = b.r(paramContext)) {
      return i1;
    }
  }
  
  public static String y(Context paramContext)
  {
    if (Q.contains("locinfo")) {}
    for (paramContext = "";; paramContext = e.a(paramContext)) {
      return paramContext;
    }
  }
  
  public static String z(Context paramContext)
  {
    if (Q.contains("ma")) {}
    for (paramContext = "";; paramContext = b.v(paramContext)) {
      return paramContext;
    }
  }
  
  public ArrayList<String> a()
  {
    return Q;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */