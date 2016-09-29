package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.f.c;
import cn.domob.android.i.d;
import java.util.HashMap;

class i
{
  private static final String A = "pb[version]";
  private static final String B = "d[coord_timestamp]";
  private static final String C = "d[coord]";
  private static final String D = "d[coord_acc]";
  private static final String E = "d[coord_status]";
  private static final String F = "d[coord_accuracy]";
  private static final String G = "d[pc]";
  private static final String H = "d[dob]";
  private static final String I = "d[gender]";
  private static final String J = "spot";
  private static final String K = "network";
  private static final String L = "lpkg";
  private static final String M = "or";
  private static final String N = "orv";
  private static final String O = "dma";
  private static final String P = "ama";
  private static final String Q = "an";
  private static final String R = "lac";
  private static final String S = "cell";
  private static final String T = "mcc";
  private static final String U = "mnc";
  private static final String V = "ar";
  private static final String W = "ppid";
  private static final String X = "scan";
  private static final String Y = "iffd";
  private static final String Z = "cffd";
  protected static final int a = 1;
  private static final String aa = "cd";
  private static final String ab = "dmid";
  private static final String ac = "aaid";
  private static final String ad = "act";
  private static cn.domob.android.i.f b = new cn.domob.android.i.f(i.class.getSimpleName());
  private static final String e = "sdk";
  private static final String f = "rt";
  private static final String g = "pt";
  private static final String h = "ts";
  private static final String i = "ua";
  private static final String j = "ipb";
  private static final String k = "idv";
  private static final String l = "v";
  private static final String m = "sv";
  private static final String n = "l";
  private static final String o = "f";
  private static final String p = "e";
  private static final String q = "cid";
  private static final String r = "dim";
  private static final String s = "so";
  private static final String t = "sw";
  private static final String u = "sh";
  private static final String v = "sd";
  private static final String w = "c";
  private static final String x = "k";
  private static final String y = "pb[identifier]";
  private static final String z = "pb[name]";
  private cn.domob.android.f.g ae;
  private g c;
  private Context d;
  
  public i(g paramg)
  {
    b.b("New instance of DomobAdRequest.");
    this.c = paramg;
    this.d = paramg.x();
  }
  
  private cn.domob.android.f.f c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(1));
    localHashMap.put("rt", String.valueOf(1));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", cn.domob.android.b.a.f(this.d));
    localHashMap.put("ipb", this.c.m());
    localHashMap.put("ppid", this.c.n());
    localHashMap.put("idv", cn.domob.android.b.a.g(this.d));
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20141125", "android", "20140529" }));
    localHashMap.put("sv", "040602");
    localHashMap.put("l", cn.domob.android.b.a.h());
    localHashMap.put("f", "jsonp");
    localHashMap.put("e", "UTF-8");
    localHashMap.put("cid", h.a().b(this.d));
    if (this.c.o() != 0) {
      localHashMap.put("pt", String.valueOf(this.c.o()));
    }
    if (this.c.q() != null) {
      localHashMap.put("dim", this.c.q());
    }
    localHashMap.put("so", cn.domob.android.b.a.r(this.d));
    localHashMap.put("sw", String.valueOf(cn.domob.android.b.a.u(this.d)));
    localHashMap.put("sh", String.valueOf(cn.domob.android.b.a.v(this.d)));
    localHashMap.put("sd", String.valueOf(cn.domob.android.b.a.t(this.d)));
    String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { "gif", "ltx", "la", "hv", "expd", "iad", "spi", "mraid1", "wvl", "tpup", "gd" });
    Object localObject = str;
    if (cn.domob.android.b.a.F(this.d)) {
      localObject = str + ",vib\t";
    }
    localHashMap.put("c", localObject);
    localHashMap.put("pb[identifier]", cn.domob.android.b.a.a(this.d));
    localHashMap.put("pb[name]", cn.domob.android.b.a.d(this.d));
    localHashMap.put("pb[version]", cn.domob.android.b.a.c(this.d));
    localHashMap.put("network", cn.domob.android.b.a.o(this.d));
    if (this.c.h() == true)
    {
      localObject = "1";
      localHashMap.put("ar", localObject);
      if (this.c.s() != null) {
        localHashMap.put("k", this.c.s());
      }
      localObject = cn.domob.android.b.a.y(this.d);
      if (localObject == null) {
        break label1272;
      }
      localHashMap.put("d[coord_timestamp]", String.valueOf(cn.domob.android.b.a.g()));
      localHashMap.put("d[coord]", localObject);
      localHashMap.put("d[coord_acc]", String.valueOf(cn.domob.android.b.a.d()));
      localHashMap.put("d[coord_accuracy]", String.valueOf(cn.domob.android.b.a.e()));
    }
    for (;;)
    {
      localObject = cn.domob.android.b.a.D(this.d);
      b.b(String.format("Base info: cid=%s, lac=%s, mcc=%s, mnc=%s", new Object[] { localObject[0], localObject[1], localObject[2], localObject[3] }));
      localHashMap.put("cell", localObject[0]);
      localHashMap.put("lac", localObject[1]);
      localHashMap.put("mcc", localObject[2]);
      localHashMap.put("mnc", localObject[3]);
      if (this.c.t() != null) {
        localHashMap.put("d[pc]", this.c.t());
      }
      if (this.c.v() != null) {
        localHashMap.put("d[dob]", this.c.v());
      }
      if (this.c.u() != null) {
        localHashMap.put("d[gender]", this.c.u());
      }
      if (this.c.w() != null) {
        localHashMap.put("spot", this.c.w());
      }
      if (h.a().d() != null)
      {
        localHashMap.put("lpkg", h.a().d());
        h.a().d(null);
      }
      if (h.a().f() != null) {
        localHashMap.put("or", h.a().f());
      }
      if (h.a().g() != null) {
        localHashMap.put("orv", h.a().g());
      }
      localObject = cn.domob.android.b.a.z(this.d);
      if (localObject != null)
      {
        b.b("des encode dma:" + ((String)localObject).toUpperCase() + "-->" + cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", ((String)localObject).toUpperCase()));
        localHashMap.put("dma", cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", ((String)localObject).toUpperCase()));
      }
      localObject = cn.domob.android.b.a.A(this.d);
      if (localObject != null)
      {
        b.b("des encode ama:" + ((String)localObject).toUpperCase() + "-->" + cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", ((String)localObject).toUpperCase()));
        localHashMap.put("ama", cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", ((String)localObject).toUpperCase()));
      }
      localObject = cn.domob.android.b.a.B(this.d);
      if (localObject != null)
      {
        b.b("des encode apSSID:" + ((String)localObject).toUpperCase() + "-->" + cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", (String)localObject));
        localHashMap.put("an", cn.domob.android.i.h.a("d!j@d#g$r%s^j&h*", (String)localObject));
      }
      localObject = cn.domob.android.b.a.C(this.d);
      if (!cn.domob.android.i.h.e((String)localObject))
      {
        b.b("Scaned AP mac and name: " + (String)localObject);
        localHashMap.put("scan", localObject);
      }
      localObject = cn.domob.android.e.a.a(this.d);
      if (!cn.domob.android.i.h.e(localObject[0])) {
        localHashMap.put("iffd", localObject[0]);
      }
      if (!cn.domob.android.i.h.e(localObject[1])) {
        localHashMap.put("cffd", localObject[1]);
      }
      localHashMap.put("cd", a.a.a.a.a.a.a(this.d));
      localObject = d.a(this.d, "/.dm/dm.file");
      if ((!cn.domob.android.i.h.e((String)localObject)) && (((String)localObject).getBytes().length <= 256)) {
        localHashMap.put("dmid", localObject);
      }
      localObject = cn.domob.android.b.a.G(this.d);
      if (!cn.domob.android.i.h.e((String)localObject)) {
        localHashMap.put("aaid", localObject);
      }
      localHashMap.put("act", String.valueOf(this.c.I()));
      return new cn.domob.android.f.f(localHashMap);
      localObject = "0";
      break;
      label1272:
      localHashMap.put("d[coord_status]", String.valueOf(cn.domob.android.b.a.f()));
    }
  }
  
  protected void a()
  {
    this.ae = new i.1(this);
    c.a().b(this.d, h.a().b(), c(), this.ae);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\I.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */