package cn.dbox.core.h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Vibrator;
import cn.dbox.core.g.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class e
{
  protected static final String A = "d[coord_acc]";
  protected static final String B = "d[coord_status]";
  protected static final String C = "d[coord_timestamp]";
  protected static final String D = "dma";
  protected static final String E = "areacode";
  protected static final String F = "cellid";
  protected static final String G = "language";
  protected static final String H = "odin1";
  protected static final String I = "locaccmeters";
  protected static final String J = "ama";
  protected static final String K = "ssid";
  protected static final String L = "scan";
  protected static final String M = "istab";
  protected static final String N = "aaid";
  private static d O = new d(e.class.getSimpleName());
  private static ArrayList<String> P = new ArrayList();
  private static String Q;
  private static int R = 0;
  private static int S = 0;
  private static String T;
  private static String U;
  private static final String V = "sdk";
  protected static final String a = "pb[identifier]";
  protected static final String b = "vc";
  protected static final String c = "vn";
  protected static final String d = "appname";
  protected static final String e = "useragent";
  protected static final String f = "ua";
  protected static final String g = "install";
  protected static final String h = "idv";
  protected static final String i = "imei";
  protected static final String j = "andoidid";
  protected static final String k = "osv";
  protected static final String l = "devicemodel";
  protected static final String m = "network";
  protected static final String n = "networkavailable";
  protected static final String o = "ip";
  protected static final String p = "timezone";
  protected static final String q = "carrier";
  protected static final String r = "orientation";
  protected static final String s = "isemulator";
  protected static final String t = "rsd";
  protected static final String u = "csd";
  protected static final String v = "rsw";
  protected static final String w = "rsh";
  protected static final String x = "csw";
  protected static final String y = "csh";
  protected static final String z = "d[coord]";
  
  public static String A(Context paramContext)
  {
    if (P.contains("areacode")) {}
    for (paramContext = "";; paramContext = b.x(paramContext)) {
      return paramContext;
    }
  }
  
  public static String B(Context paramContext)
  {
    if (P.contains("ama")) {}
    for (paramContext = "";; paramContext = b.w(paramContext)) {
      return paramContext;
    }
  }
  
  public static String C(Context paramContext)
  {
    if (P.contains("ssid")) {}
    for (paramContext = "";; paramContext = b.z(paramContext)) {
      return paramContext;
    }
  }
  
  public static String D(Context paramContext)
  {
    String str = "";
    if (!P.contains("scan")) {
      str = b.A(paramContext);
    }
    return str;
  }
  
  public static String[] E(Context paramContext)
  {
    if ((P.contains("areacode")) || (P.contains("cellid")))
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
      paramContext = b.B(paramContext);
    }
  }
  
  public static String F(Context paramContext)
  {
    if (P.contains("aaid")) {}
    for (paramContext = "";; paramContext = b.C(paramContext)) {
      return paramContext;
    }
  }
  
  public static boolean G(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1) {}
    for (boolean bool = false;; bool = true) {
      for (;;)
      {
        return bool;
        if (b.a(11, true)) {
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
            O.b("Android version of the device is less than 3.0, the interface is no mapping");
            O.a(paramContext);
          }
        }
      }
    }
  }
  
  private static boolean H(Context paramContext)
  {
    paramContext = j(paramContext);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = paramContext.replaceAll("0", "").equals("")) {
      return bool;
    }
  }
  
  private static String I(Context paramContext)
  {
    O.b("Start to generate device id");
    localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        String str = j(paramContext);
        if (str == null) {
          continue;
        }
        localStringBuffer.append(str);
        localStringBuffer.append(",");
        localStringBuffer.append("-1");
        localStringBuffer.append(",");
      }
      catch (SecurityException localSecurityException)
      {
        O.a(localSecurityException);
        O.e("you must set READ_PHONE_STATE permisson in AndroidManifest.xml");
        continue;
      }
      catch (Exception localException)
      {
        O.a(localException);
        continue;
        O.a("Android ID is null, use -1 instead");
        localStringBuffer.append("-1");
        continue;
      }
      paramContext = k(paramContext);
      if (paramContext == null) {
        continue;
      }
      localStringBuffer.append(paramContext);
      O.b("Generated device id: " + localStringBuffer.toString());
      return localStringBuffer.toString();
      localStringBuffer.append("-1");
    }
  }
  
  public static String a(Context paramContext)
  {
    if (P.contains("pb[identifier]")) {}
    for (paramContext = "";; paramContext = b.a(paramContext)) {
      return paramContext;
    }
  }
  
  public static ArrayList<String> a()
  {
    return P;
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      O.b("需要关闭的字段: " + paramArrayList);
      P = paramArrayList;
    }
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    return b.a(paramInt, paramBoolean);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (P.contains("install")) {}
    for (boolean bool = false;; bool = b.a(paramContext, paramString)) {
      return bool;
    }
  }
  
  public static int b(Context paramContext)
  {
    if (P.contains("vc")) {}
    for (int i1 = -1;; i1 = b.b(paramContext)) {
      return i1;
    }
  }
  
  public static String b()
  {
    if (P.contains("ip")) {}
    for (String str = "";; str = b.a()) {
      return str;
    }
  }
  
  public static String c()
  {
    if (P.contains("timezone")) {}
    for (String str = "";; str = b.b()) {
      return str;
    }
  }
  
  public static String c(Context paramContext)
  {
    if (P.contains("vn")) {}
    for (paramContext = "";; paramContext = b.c(paramContext)) {
      return paramContext;
    }
  }
  
  public static int d()
  {
    if (P.contains("d[coord_acc]")) {}
    for (int i1 = -1;; i1 = b.c()) {
      return i1;
    }
  }
  
  public static String d(Context paramContext)
  {
    if (P.contains("appname")) {}
    for (paramContext = "";; paramContext = b.d(paramContext)) {
      return paramContext;
    }
  }
  
  public static int e()
  {
    if (P.contains("d[coord_status]")) {}
    for (int i1 = -1;; i1 = b.d()) {
      return i1;
    }
  }
  
  public static String e(Context paramContext)
  {
    if (P.contains("useragent")) {}
    for (paramContext = "";; paramContext = b.e(paramContext)) {
      return paramContext;
    }
  }
  
  public static long f()
  {
    if (P.contains("d[coord_timestamp]")) {}
    for (long l1 = -1L;; l1 = b.e()) {
      return l1;
    }
  }
  
  public static String f(Context paramContext)
  {
    if (P.contains("ua"))
    {
      paramContext = "";
      return paramContext;
    }
    StringBuffer localStringBuffer;
    if (Q == null)
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("android");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      if (Build.VERSION.RELEASE.length() <= 0) {
        break label226;
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
      paramContext = p(paramContext);
      if (paramContext != null) {
        localStringBuffer.append(paramContext.replaceAll(",", "_"));
      }
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      localStringBuffer.append(",");
      Q = localStringBuffer.toString();
      O.b(f.class.getSimpleName(), "getUserAgent:" + Q);
      paramContext = Q;
      break;
      label226:
      localStringBuffer.append("1.5");
    }
  }
  
  public static String g()
  {
    if (P.contains("language")) {}
    for (String str = "";; str = b.f()) {
      return str;
    }
  }
  
  public static List<String> g(Context paramContext)
  {
    if (P.contains("install")) {}
    for (paramContext = new ArrayList();; paramContext = b.f(paramContext)) {
      return paramContext;
    }
  }
  
  public static int h()
  {
    if (P.contains("locaccmeters")) {}
    for (int i1 = -1;; i1 = b.g()) {
      return i1;
    }
  }
  
  public static String h(Context paramContext)
  {
    if (P.contains("idv"))
    {
      paramContext = "";
      return paramContext;
    }
    if (U == null)
    {
      if (!i(paramContext)) {
        break label51;
      }
      O.b("Use emulator id");
    }
    for (U = "-1,-1,emulator";; U = I(paramContext))
    {
      paramContext = U;
      break;
      label51:
      O.b("Generate device id");
    }
  }
  
  public static boolean i(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (P.contains("isemulator")) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (T == null) {
        T = k(paramContext);
      }
      bool1 = bool2;
      if (T == null)
      {
        bool1 = bool2;
        if (H(paramContext))
        {
          bool1 = bool2;
          if ("sdk".equalsIgnoreCase(Build.MODEL)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static String j(Context paramContext)
  {
    if (P.contains("imei")) {}
    for (paramContext = "-1";; paramContext = b.g(paramContext)) {
      return paramContext;
    }
  }
  
  public static String k(Context paramContext)
  {
    if (P.contains("andoidid")) {}
    for (paramContext = "-1";; paramContext = b.h(paramContext)) {
      return paramContext;
    }
  }
  
  public static String l(Context paramContext)
  {
    if (P.contains("osv")) {}
    for (paramContext = "";; paramContext = b.i(paramContext)) {
      return paramContext;
    }
  }
  
  public static String m(Context paramContext)
  {
    if (P.contains("devicemodel")) {}
    for (paramContext = "";; paramContext = b.j(paramContext)) {
      return paramContext;
    }
  }
  
  public static String n(Context paramContext)
  {
    if (P.contains("network")) {}
    for (paramContext = "";; paramContext = b.k(paramContext)) {
      return paramContext;
    }
  }
  
  public static boolean o(Context paramContext)
  {
    if (P.contains("networkavailable")) {}
    for (boolean bool = false;; bool = b.l(paramContext)) {
      return bool;
    }
  }
  
  public static String p(Context paramContext)
  {
    if (P.contains("carrier")) {}
    for (paramContext = "";; paramContext = b.m(paramContext)) {
      return paramContext;
    }
  }
  
  public static String q(Context paramContext)
  {
    if (P.contains("orientation")) {}
    for (paramContext = "";; paramContext = b.n(paramContext)) {
      return paramContext;
    }
  }
  
  public static float r(Context paramContext)
  {
    if (P.contains("rsd")) {}
    for (float f1 = -1.0F;; f1 = b.o(paramContext)) {
      return f1;
    }
  }
  
  public static float s(Context paramContext)
  {
    if (P.contains("csd")) {}
    for (float f1 = -1.0F;; f1 = b.p(paramContext)) {
      return f1;
    }
  }
  
  public static int t(Context paramContext)
  {
    if (P.contains("rsw")) {}
    for (int i1 = -1;; i1 = R)
    {
      return i1;
      R = Math.round(v(paramContext) * (r(paramContext) / s(paramContext)));
    }
  }
  
  public static int u(Context paramContext)
  {
    if (P.contains("rsh")) {}
    for (int i1 = -1;; i1 = S)
    {
      return i1;
      S = Math.round(w(paramContext) * (r(paramContext) / s(paramContext)));
    }
  }
  
  public static int v(Context paramContext)
  {
    if (P.contains("csw")) {}
    for (int i1 = -1;; i1 = b.q(paramContext)) {
      return i1;
    }
  }
  
  public static int w(Context paramContext)
  {
    if (P.contains("csh")) {}
    for (int i1 = -1;; i1 = b.r(paramContext)) {
      return i1;
    }
  }
  
  public static String x(Context paramContext)
  {
    if (P.contains("d[coord]")) {}
    for (paramContext = "";; paramContext = b.u(paramContext)) {
      return paramContext;
    }
  }
  
  public static String y(Context paramContext)
  {
    if (P.contains("dma")) {}
    for (paramContext = "";; paramContext = b.v(paramContext)) {
      return paramContext;
    }
  }
  
  public static String z(Context paramContext)
  {
    if (P.contains("odin1")) {}
    for (paramContext = "";; paramContext = a.a(paramContext.getApplicationContext())) {
      return paramContext;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */