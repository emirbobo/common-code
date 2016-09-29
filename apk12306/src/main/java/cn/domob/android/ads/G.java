package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import cn.domob.android.i.c;
import cn.domob.android.i.f;
import java.util.Date;
import java.util.HashMap;

public class g
  implements C.a, J.a, e.a, i.a
{
  protected static final String A = "visit";
  protected static final String B = "url";
  protected static final String C = "phase";
  protected static final String D = "wtai://wp/mc;";
  protected static final int E = 1;
  protected static final int F = 2;
  protected static final int G = 3;
  protected static final int H = 4;
  protected static final int I = 5;
  private static f J = new f(g.class.getSimpleName());
  protected static final String o = "domob";
  protected static final String p = "mraid";
  protected static final String q = "inapp";
  protected static final String r = "download";
  protected static final String s = "report";
  protected static final String t = "launch";
  protected static final String u = "custom";
  protected static final String v = "expand";
  protected static final String w = "close";
  protected static final String x = "clk";
  protected static final String y = "imp";
  protected static final String z = "event";
  private String K = null;
  private String L = null;
  private String M;
  private String N = null;
  private String O = null;
  private String P = null;
  private String Q = "";
  private String R = "";
  private boolean S = false;
  private boolean T = true;
  private boolean U = true;
  private boolean V = false;
  private int W;
  private Handler X = new Handler(Looper.getMainLooper());
  private long Y = 0L;
  private long Z = 0L;
  protected Context a;
  private l aa;
  private int ab = 0;
  protected Context b;
  protected String c = null;
  protected DomobAdView d = null;
  protected j e = null;
  protected g.b f = new g.b(this);
  protected n g;
  protected cn.domob.android.h.a h;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean k = false;
  protected g.a l = g.a.a;
  protected g.c m = g.c.c;
  protected g.d n = g.d.c;
  
  public g(DomobAdView paramDomobAdView, String paramString1, String paramString2)
  {
    J.a("Init DomobAdController.");
    Log.i(f.b(), "Current SDK version is " + cn.domob.android.ads.c.e.a() + " built at " + cn.domob.android.ads.c.e.b());
    if (paramDomobAdView != null)
    {
      this.d = paramDomobAdView;
      this.a = paramDomobAdView.b();
      this.b = this.a;
    }
    this.K = paramString1;
    this.c = paramString2;
    if (paramString1 == null) {
      this.K = h.a().a(this.a);
    }
    h.a().b(this.K);
    Log.i(f.b(), "Current placementID is " + this.c);
    J();
    K();
    e.a(this.a, this);
    this.aa = new l(this, paramDomobAdView);
    this.h = new cn.domob.android.h.a(this.a, this.c);
  }
  
  public g(String paramString)
  {
    J.a("Init DomobAdController.");
    this.K = paramString;
    if (paramString == null) {
      this.K = h.a().a(this.a);
    }
    h.a().b(this.K);
  }
  
  private void J()
  {
    if (!h.a().e())
    {
      Object localObject = new cn.domob.android.ads.c.a(this.a, "domob_config");
      String str = ((cn.domob.android.ads.c.a)localObject).a("version", "1");
      localObject = ((cn.domob.android.ads.c.a)localObject).a("config", "{\"com.admogo.AdMogoLayout\":\"1\",\"com.guohead.sdk.GHView\":\"2\",\"com.adview.AdViewLayout\":\"3\",\"appfactory.cn.adplatform.AdSageLayout\":\"4\"}");
      h.a().a(str, (String)localObject);
    }
  }
  
  private void K()
  {
    cn.domob.android.ads.c.a locala = new cn.domob.android.ads.c.a(this.a, "domob_config");
    h.a().c(locala.a("cookie_id", null));
    h.a().a(locala.a("disable", false), locala.a("timestamp", 0L), locala.a("time", 0));
    this.W = locala.a("interval", 20000);
  }
  
  private void L()
  {
    HashMap localHashMap = new HashMap();
    String str1 = this.e.c();
    if (str1 != null)
    {
      localHashMap.put("cookie_id", str1);
      h.a().c(str1);
    }
    int i1;
    if (this.e.f() != null) {
      if (this.e.f().d())
      {
        i1 = this.e.f().a() * 1000;
        if (i1 > 0) {
          break label347;
        }
        this.W = 0;
      }
    }
    for (;;)
    {
      localHashMap.put("interval", Integer.valueOf(this.W));
      boolean bool = this.e.f().b();
      long l1 = System.currentTimeMillis();
      i1 = this.e.f().c();
      localHashMap.put("timestamp", Long.valueOf(l1));
      localHashMap.put("disable", Boolean.valueOf(bool));
      localHashMap.put("time", Integer.valueOf(i1));
      J.a(this, "disable time stamp:" + l1);
      J.a(this, "disable time:" + i1);
      h.a().a(bool, l1, i1);
      str1 = this.e.f().e();
      String str2 = this.e.f().f();
      if (h.a().e(str1))
      {
        localHashMap.put("version", this.e.f().e());
        localHashMap.put("config", this.e.f().f());
        h.a().a(str1, str2);
      }
      if (!localHashMap.isEmpty()) {
        new cn.domob.android.ads.c.a(this.a, "domob_config").a(localHashMap);
      }
      return;
      label347:
      if ((i1 > 0) && (i1 < 5000)) {
        this.W = 5000;
      } else if (i1 >= 5000) {
        this.W = i1;
      }
    }
  }
  
  private void M()
  {
    String str = this.e.d().C();
    if (cn.domob.android.b.a.a(this.a, str)) {
      h.a().d(this.e.d().a());
    }
  }
  
  private boolean N()
  {
    if ((o() == DomobAdView.a.d.ordinal()) || (o() == DomobAdView.a.e.ordinal())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void O()
  {
    if (c.l(this.a))
    {
      cn.domob.android.g.a.a locala = new cn.domob.android.g.a.a(P());
      locala.a(true);
      if (o() == DomobAdView.a.e.ordinal()) {
        locala.b(false);
      }
      locala.a(b.x, this.a, new g.1(this));
    }
    for (;;)
    {
      return;
      if (N()) {
        a(DomobAdManager.ErrorCode.NETWORK_ERROR);
      }
    }
  }
  
  private cn.domob.android.g.a.e P()
  {
    String str3 = null;
    String str4 = String.format("%s-%s-%s", new Object[] { "20141125", "android", "20140529" });
    String str1 = cn.domob.android.b.a.z(this.a);
    if (str1 != null) {}
    for (str1 = cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", str1.toUpperCase());; str1 = null)
    {
      String str2 = cn.domob.android.b.a.A(this.a);
      if (str2 != null) {}
      for (str2 = cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", str2.toUpperCase());; str2 = null)
      {
        String str5 = cn.domob.android.b.a.B(this.a);
        if (str5 != null) {
          str3 = cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", str5);
        }
        String str6 = cn.domob.android.b.a.g(this.a);
        str5 = m();
        String str7 = n();
        cn.domob.android.g.a.e locale = new cn.domob.android.g.a.e();
        locale.e(str2);
        locale.d(str1);
        locale.f(str3);
        locale.g(str6);
        locale.h(str5);
        locale.i(str7);
        locale.b(str4);
        locale.a(String.valueOf(1));
        locale.c("040602");
        return locale;
      }
    }
  }
  
  private void a(String paramString, q paramq)
  {
    w localw = new w(this.a, this.c);
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = paramq.a().d().r();
    localc.d = paramq.c();
    localc.e = paramq.d();
    localc.f = paramq.e();
    localw.a(paramq.a().d().q(), w.h.b, paramString, localc, null);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    w localw = new w(this.a, this.c);
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.d = paramString2;
    localc.e = paramInt;
    localc.f = paramString3;
    localw.a("http://e.domob.cn/event_report", w.h.e, paramString1, localc, null);
  }
  
  private void b(j paramj, int paramInt)
  {
    if (paramj != null)
    {
      this.e = paramj;
      L();
      if (paramj.d() != null)
      {
        this.aa.a(this.a, this.e);
        M();
        J.b("Get ad response successfully.");
      }
    }
    for (;;)
    {
      return;
      if (paramj.e() != null)
      {
        String str = paramj.e().b();
        paramInt = paramj.e().a();
        Log.e("DomobSDK", String.format("Response contains error info. Error code is [%d-%s] and error content is [%s]", new Object[] { Integer.valueOf(paramInt), paramj.b(), str }));
        switch (paramInt / 1000)
        {
        }
        for (;;)
        {
          a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
          break;
          a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
          break;
          a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
          break;
          a(DomobAdManager.ErrorCode.INVALID_REQUEST);
          break;
          a(DomobAdManager.ErrorCode.NO_FILL);
          break;
          a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
        }
      }
      O();
      if (!N())
      {
        J.e("Unexpected resp, Try to request again after refresh interval.");
        a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
        continue;
        O();
        if (!N())
        {
          Log.w(f.b(), "Connection Error. Please make sure that your network is available.");
          J.e("AdResponse instance is null. Try to request again after refresh interval.");
          a(DomobAdManager.ErrorCode.NETWORK_ERROR);
        }
      }
    }
  }
  
  private void k(String paramString)
  {
    new w(this.a, this.c).a(this.e.d().q(), w.h.g, paramString, null, null);
  }
  
  protected boolean A()
  {
    return this.S;
  }
  
  protected j B()
  {
    return this.e;
  }
  
  protected void C()
  {
    try
    {
      if (!o.a)
      {
        J.b("Start to load config request");
        o localo = new cn/domob/android/ads/o;
        localo.<init>(this);
        localo.a();
      }
      for (;;)
      {
        return;
        a(this);
      }
    }
    catch (cn.domob.android.d.a locala)
    {
      for (;;)
      {
        J.b("Config request is ongoing, ignore this time");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void D()
  {
    J.a().a(this.a, this);
    E();
  }
  
  protected void E()
  {
    this.S = true;
    this.V = false;
    this.m = g.c.c;
    a();
  }
  
  public void F()
  {
    String str;
    if ((this.Q != null) && (!this.Q.equals(""))) {
      if ((this.R != null) && (this.R.equals("mraid")))
      {
        str = "mraid";
        J.b("gen fake ad response:" + str);
        a(j.a(String.format("{\"sid\":\"search_id\",\"cid\":\"cookie_id\",\"ad\":{\"id\":\"12345\",\"format\":\"%s\",\"ct\":\"url\",\"width\":320,\"height\":50,\"url\":\"%s\",\"content\":\"\",\"base_url\":\"\",\"click_tracker\":\"\",\"imp_tracker\":\"h\",\"event_tracker\":\"\",\"tracker\":\"8ewfqd8ffqwer1325effff342f3444\",\"animation\":1,\"o\":\"h\",\"cls_btn\":0,\"imp_min\":5,\"imp_cls\":8,\"cache\":1440,\"pkg\":\"cn.domob.android.rm.demo\",\"mz_click_tracker\":\"\",\"mz_imp_tracker\":\"\"},\"control\":{\"refresh\":20,\"disable\":false,\"dis_time\":30,\"location\":true,\"ors\":{\"version\":\"2\",\"config\":{\"com.admogo.AdMogoLayout\":\"1\",\"com.guohead.sdk.GHView\":\"2\",\"com.adview.AdViewLayout\":\"3\",\"appfactory.cn.adplatform.AdSageLayout\":\"4\",\"cn.domob.test\":\"5\"}}}}", new Object[] { str, this.Q })), 200);
      }
    }
    for (;;)
    {
      return;
      str = "domob";
      break;
      C();
    }
  }
  
  public boolean G()
  {
    if (o() == DomobAdView.a.c.ordinal()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void H()
  {
    a.a.a.a.a.a.a(new g.4(this));
  }
  
  protected int I()
  {
    return this.ab;
  }
  
  protected void a()
  {
    if (this.m == g.c.a) {}
    for (;;)
    {
      return;
      if (this.l == g.a.a)
      {
        if (this.T)
        {
          J.b("Start schedule new request. Refresh interval is " + this.W);
          if (this.W == 0)
          {
            J.a("AdView is auto refreshable but interval from ad response is 0. DON'T SCHEDULE.");
          }
          else
          {
            this.X.removeCallbacks(this.f);
            this.X.postDelayed(this.f, this.W);
            this.m = g.c.a;
          }
        }
      }
      else if (this.l == g.a.b) {
        J.a("AdView is expanding, cancel current 'start()'.");
      }
    }
  }
  
  protected void a(int paramInt)
  {
    this.W = paramInt;
  }
  
  protected void a(long paramLong)
  {
    this.n = g.d.a;
    this.Y = paramLong;
    this.Z = 0L;
    J.b("init timing");
  }
  
  protected void a(Context paramContext)
  {
    a.a.a.a.a.a.a(paramContext, new g.3(this));
  }
  
  protected void a(DomobAdManager.ErrorCode paramErrorCode)
  {
    J.b("FAILED to load AD.");
    this.V = false;
    a();
    ((Activity)this.a).runOnUiThread(new g.2(this, paramErrorCode));
  }
  
  protected void a(g.a parama)
  {
    this.l = parama;
  }
  
  public void a(g paramg)
  {
    if (!h.a().c(this.a)) {
      if (!this.V)
      {
        paramg.b();
        J.b("Load after schedule request.");
        this.V = true;
        new i(paramg).a();
      }
    }
    for (;;)
    {
      return;
      J.d("An ad is requesting.");
      continue;
      J.d("Ad has been disabled currently. Disable expire time = " + new Date(h.a().c()));
    }
  }
  
  public void a(j paramj)
  {
    a(paramj, null, null);
  }
  
  public void a(j paramj, int paramInt)
  {
    b(paramj, paramInt);
  }
  
  protected void a(j paramj, String paramString)
  {
    if ((paramj != null) && (paramj.d() != null))
    {
      w localw = new w(this.a, this.c);
      localw.getClass();
      w.c localc = new w.c(localw);
      localc.a = paramj.d().r();
      localw.a(paramj.d().q(), w.h.q, paramString, localc, null);
    }
  }
  
  public void a(j paramj, String paramString1, String paramString2, long paramLong)
  {
    a(paramj, null, paramString1, paramString2, paramLong, null);
  }
  
  protected void a(j paramj, String paramString1, String paramString2, String paramString3)
  {
    if ((paramj != null) && (paramj.d() != null))
    {
      w localw = new w(this.a, this.c);
      localw.getClass();
      w.c localc = new w.c(localw);
      localc.a = paramj.d().r();
      localc.i = paramString2;
      localc.j = paramString3;
      localw.a(paramj.d().q(), w.h.p, paramString1, localc, null);
    }
  }
  
  public void a(j paramj, HashMap<String, String> paramHashMap, String paramString)
  {
    String str1 = paramj.d().o();
    String str2 = paramj.d().r();
    w localw = new w(this.a, this.c);
    localw.getClass();
    w.b localb = new w.b(localw);
    localb.a = str2;
    if (paramString != null) {
      localb.b = paramString;
    }
    localw.a(str1, localb, paramHashMap);
    cn.domob.android.e.a.c(this.a, paramj.d().E());
  }
  
  public void a(j paramj, HashMap<String, String> paramHashMap, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    a(paramj, paramHashMap, paramString1, paramString2, paramLong, paramString3, this.d);
  }
  
  public void a(j paramj, HashMap<String, String> paramHashMap, String paramString1, String paramString2, long paramLong, String paramString3, View paramView)
  {
    w localw = new w(this.a, this.c);
    localw.getClass();
    w.f localf = new w.f(localw);
    String str = paramString3;
    if (paramString3 == null) {
      str = paramj.d().p();
    }
    localf.a = paramj.d().r();
    if (paramView != null)
    {
      paramString3 = new int[2];
      paramView.getLocationOnScreen(paramString3);
      localf.d = String.format("%d,%d,%d,%d", new Object[] { Integer.valueOf(paramString3[0]), Integer.valueOf(paramString3[1]), Integer.valueOf(paramView.getWidth()), Integer.valueOf(paramView.getHeight()) });
    }
    localf.e = cn.domob.android.b.a.u(this.a);
    localf.f = cn.domob.android.b.a.v(this.a);
    localf.g = cn.domob.android.b.a.r(this.a);
    localf.h = paramString1;
    localf.b = paramString2;
    localf.i = paramLong;
    localw.a(str, localf, paramHashMap);
    boolean bool = paramj.d().b().equals("video");
    if (((bool) && (paramString1.equals("m"))) || ((!bool) && (paramString1.equals("s")))) {
      cn.domob.android.e.a.b(this.a, paramj.d().E());
    }
  }
  
  public void a(q paramq)
  {
    a("install_success", paramq);
  }
  
  protected void a(String paramString)
  {
    this.K = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a("up_alert", paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, String paramString3) {}
  
  protected void a(String paramString, a.a.a.a.a.e parame)
  {
    w localw = new w(this.a, parame.d);
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = parame.c;
    localc.i = parame.a;
    localc.j = parame.b;
    localw.a(parame.e, w.h.p, paramString, localc, null);
  }
  
  protected void a(boolean paramBoolean)
  {
    J.a("Auto refresh is set to " + paramBoolean);
    this.T = paramBoolean;
  }
  
  protected void b()
  {
    this.X.removeCallbacks(this.f);
    this.m = g.c.c;
  }
  
  protected void b(int paramInt)
  {
    this.ab = paramInt;
  }
  
  public void b(q paramq)
  {
    a("run", paramq);
  }
  
  protected void b(String paramString)
  {
    this.L = paramString;
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    a("up_ok", paramString1, paramInt, paramString2);
  }
  
  protected void b(boolean paramBoolean)
  {
    J.a("Transition animation is set to " + paramBoolean);
    this.U = paramBoolean;
  }
  
  protected void c()
  {
    if (this.m == g.c.b) {}
    for (;;)
    {
      return;
      if (this.l == g.a.a)
      {
        if (this.T)
        {
          this.X.removeCallbacks(this.f);
          d();
          J.a("Pause schedule and the ad has shown " + this.Z + "ms");
          this.m = g.c.b;
        }
      }
      else if (this.l == g.a.b) {
        J.a("AdView is expanding, pause() has been called. Cancel current 'pause()'.");
      }
    }
  }
  
  protected void c(String paramString)
  {
    this.M = paramString;
  }
  
  public void c(String paramString1, int paramInt, String paramString2)
  {
    a("up_cancel", paramString1, paramInt, paramString2);
  }
  
  protected void c(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  protected void d()
  {
    if (this.n == g.d.a)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.Z;
      this.Z = (l1 - this.Y + l2);
      this.n = g.d.b;
      J.b("pause timing current ad has shown seconds:" + g() / 1000L);
    }
  }
  
  protected void d(String paramString)
  {
    this.N = paramString;
  }
  
  public void d(String paramString1, int paramInt, String paramString2)
  {
    a("up_skip", paramString1, paramInt, paramString2);
  }
  
  protected void d(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  protected void e()
  {
    if (this.m == g.c.a) {}
    for (;;)
    {
      return;
      if (this.l == g.a.a)
      {
        if ((this.T) && (this.W != 0))
        {
          f();
          long l1 = this.W - this.Z;
          if (l1 <= 0L)
          {
            J.a("Maybe there is no ad, request no.");
            l();
          }
          else
          {
            J.a("Resume with remaining time:" + l1);
            this.X.postDelayed(this.f, l1);
            this.m = g.c.a;
          }
        }
      }
      else if (this.l == g.a.b) {
        J.a("AdView is expanding, cancel current 'resume()'.");
      }
    }
  }
  
  protected void e(String paramString)
  {
    this.O = paramString;
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    a("download_finish", paramString1, paramInt, paramString2);
  }
  
  protected void f()
  {
    if (this.n == g.d.b)
    {
      this.Y = System.currentTimeMillis();
      this.n = g.d.a;
      J.b("resume timing current ad has shown seconds:" + g() / 1000L);
    }
    for (;;)
    {
      return;
      J.d("call resume timing, but current state is not pause");
    }
  }
  
  protected void f(String paramString)
  {
    this.P = paramString;
  }
  
  public void f(String paramString1, int paramInt, String paramString2)
  {
    a("download_failed", paramString1, paramInt, paramString2);
  }
  
  protected long g()
  {
    long l1;
    if (this.n == g.d.a)
    {
      long l2 = System.currentTimeMillis();
      l1 = this.Z;
      l1 = l2 - this.Y + l1;
    }
    for (;;)
    {
      J.b(String.format("get ad shown time: %d s", new Object[] { Long.valueOf(l1 / 1000L) }));
      return l1;
      if (this.n == g.d.b) {
        l1 = this.Z;
      } else {
        l1 = 0L;
      }
    }
  }
  
  public void g(String paramString)
  {
    k(paramString);
  }
  
  public void g(String paramString1, int paramInt, String paramString2)
  {
    a("download_start", paramString1, paramInt, paramString2);
  }
  
  protected void h(String paramString)
  {
    this.Q = paramString;
  }
  
  public void h(String paramString1, int paramInt, String paramString2)
  {
    a("download_cancel", paramString1, paramInt, paramString2);
  }
  
  protected boolean h()
  {
    return this.T;
  }
  
  protected void i(String paramString)
  {
    this.R = paramString;
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    a("download_repeat", paramString1, paramInt, paramString2);
  }
  
  protected boolean i()
  {
    return this.U;
  }
  
  public void j(String paramString)
  {
    if (this.h != null) {
      this.h.a(paramString, this.e);
    }
  }
  
  public void j(String paramString1, int paramInt, String paramString2) {}
  
  protected boolean j()
  {
    boolean bool = true;
    J.a("Check settings and permissions.");
    if ((this.K != null) && (this.K.length() != 0))
    {
      if (cn.domob.android.i.a.a(this.a, b.U, true))
      {
        J.a("All permissions are ok.");
        return bool;
      }
      Log.w(f.b(), "Permission denied.");
    }
    for (;;)
    {
      bool = false;
      break;
      Log.w(f.b(), "Please set your PlacementID first.");
    }
  }
  
  /* Error */
  protected void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 174	cn/domob/android/ads/g:S	Z
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 180	cn/domob/android/ads/g:V	Z
    //   13: ifne +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 910	cn/domob/android/ads/g:l	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: getstatic 150	cn/domob/android/ads/g:J	Lcn/domob/android/i/f;
    //   26: ldc_w 955
    //   29: invokevirtual 230	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   32: goto -12 -> 20
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	g
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	35	finally
    //   23	32	35	finally
  }
  
  public void k(String paramString1, int paramInt, String paramString2)
  {
    a("download_md5_failed", paramString1, paramInt, paramString2);
  }
  
  protected void l()
  {
    for (;;)
    {
      try
      {
        if (this.d.a())
        {
          if (!this.V)
          {
            C();
            return;
          }
          J.d("DomobAdView is requesting.");
          continue;
        }
        this.X.removeCallbacks(this.f);
      }
      finally {}
      this.X.postDelayed(this.f, this.W);
    }
  }
  
  protected String m()
  {
    return this.K;
  }
  
  public String n()
  {
    return this.c;
  }
  
  public int o()
  {
    return this.d.e();
  }
  
  protected g.a p()
  {
    return this.l;
  }
  
  protected String q()
  {
    return this.d.i();
  }
  
  public RelativeLayout r()
  {
    return this.d;
  }
  
  protected String s()
  {
    return this.L;
  }
  
  protected String t()
  {
    return this.M;
  }
  
  protected String u()
  {
    return this.N;
  }
  
  protected String v()
  {
    return this.O;
  }
  
  protected String w()
  {
    return this.P;
  }
  
  protected Context x()
  {
    return this.a;
  }
  
  public int y()
  {
    return this.W;
  }
  
  protected DomobAdListener z()
  {
    return this.d.f();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\G.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */