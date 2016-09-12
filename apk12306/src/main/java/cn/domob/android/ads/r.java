package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.b.a;
import cn.domob.android.f.c;
import java.util.HashMap;

class r
{
  protected static final String a = "http://r.domob.cn/a/";
  private static cn.domob.android.i.f b = new cn.domob.android.i.f(r.class.getSimpleName());
  private static final String e = "sdk";
  private static final String f = "rt";
  private static final String g = "ts";
  private static final String h = "ua";
  private static final String i = "ipb";
  private static final String j = "idv";
  private static final String k = "v";
  private static final String l = "sv";
  private static final String m = "l";
  private static final String n = "f";
  private static final String o = "e";
  private static final String p = "pb[identifier]";
  private static final String q = "pb[version_name]";
  private static final String r = "pb[version_code]";
  private static final String s = "network";
  private static final int t = 4;
  private g c;
  private Context d;
  private cn.domob.android.f.g u;
  
  public r(g paramg, Context paramContext)
  {
    b.b("New instance of DomobExtraRequest.");
    this.c = paramg;
    this.d = paramContext;
  }
  
  private cn.domob.android.f.f c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(1));
    localHashMap.put("rt", String.valueOf(4));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("ua", a.f(this.d));
    localHashMap.put("ipb", this.c.m());
    localHashMap.put("idv", a.g(this.d));
    localHashMap.put("v", String.format("%s-%s-%s", new Object[] { "20141125", "android", "20140529" }));
    localHashMap.put("sv", "040602");
    localHashMap.put("l", a.h());
    localHashMap.put("f", "jsonp");
    localHashMap.put("e", "UTF-8");
    localHashMap.put("pb[identifier]", a.a(this.d));
    localHashMap.put("pb[version_name]", a.c(this.d));
    localHashMap.put("pb[version_code]", "" + a.b(this.d));
    localHashMap.put("network", a.o(this.d));
    return new cn.domob.android.f.f(localHashMap);
  }
  
  protected void a()
  {
    b.b("Start to request ExtraInfo.");
    this.u = new cn.domob.android.f.g()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (paramAnonymousString1 != null)
        {
          r.b().b("ExtraInfo resp string:" + paramAnonymousString1);
          s.a(paramAnonymousString1, r.a(r.this));
        }
        for (;;)
        {
          return;
          r.b().b("ExtraInfo respStr is null.");
        }
      }
    };
    c.a().b(this.d, "http://r.domob.cn/a/", c(), this.u);
  }
  
  static abstract interface a
  {
    public abstract void a(j paramj, int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */