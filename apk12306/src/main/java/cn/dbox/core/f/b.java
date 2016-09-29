package cn.dbox.core.f;

import android.content.Context;
import android.text.TextUtils;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.bean.a;
import cn.dbox.core.h.d;
import cn.dbox.core.h.e;
import cn.dbox.core.h.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  static b a;
  private static d b = new d(b.class.getSimpleName());
  
  static b a()
  {
    try
    {
      if (a == null)
      {
        localb = new cn/dbox/core/f/b;
        localb.<init>();
        a = localb;
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  protected class a
  {
    protected static final String A = "e_page_show";
    protected static final String B = "e_page_click";
    protected static final String C = "entry_imp";
    protected static final String D = "entry_clk";
    protected static final String E = "presented";
    protected static final String F = "channel_entry_clk";
    protected static final String G = "container_entry_clk";
    protected static final String H = "landing";
    protected static final String I = "ad_imp";
    protected static final String J = "ad_clk";
    protected static final String K = "landing";
    protected static final String L = "setting_entry_clk";
    protected static final String M = "about_clk";
    protected static final String N = "feedback_submit";
    protected static final String O = "contact_clk";
    protected static final String P = "chanid";
    protected static final String Q = "acid";
    protected static final String R = "adid";
    protected static final String S = "action";
    protected static final String T = "trs";
    protected static final String U = "tr";
    protected static final String V = "position";
    protected static final String W = "element";
    protected static final String X = "phase";
    protected static final String Y = "data";
    protected static final String Z = "message";
    protected static final String a = "load_success";
    protected static final String aa = "contact";
    protected static final String b = "load_failed";
    protected static final String c = "load_cancel";
    protected static final String d = "lp_url";
    protected static final String e = "close_lp";
    protected static final String f = "download_start";
    protected static final String g = "download_finish";
    protected static final String h = "download_cancel";
    protected static final String i = "download_failed";
    protected static final String j = "download_repeat";
    protected static final String k = "install_success";
    protected static final String l = "run";
    protected static final String m = "la_success";
    protected static final String n = "la_failed";
    protected static final String o = "la_failsafe_success";
    protected static final String p = "la_failsafe_failed";
    protected static final String q = "entry";
    protected static final String r = "exit";
    protected static final String s = "pgdn";
    protected static final String t = "banner_ad";
    protected static final String u = "list_ad";
    protected static final String v = "listad_down";
    protected static final String w = "details_down";
    protected static final String x = "e_entry_show";
    protected static final String y = "e_entry_click";
    protected static final String z = "e_page_req";
    
    protected a() {}
  }
  
  class b
    extends b.c
  {
    b(cn.dbox.core.c paramc, a parama)
    {
      super(paramc, parama, null);
      this.b.put("sid", paramc.e());
    }
    
    public void a(String paramString)
    {
      this.b.put("origin", paramString);
    }
    
    public void a(HashMap<String, String> paramHashMap)
    {
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext())
        {
          Object localObject = (Map.Entry)paramHashMap.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          if ((str != null) && (localObject != null)) {
            this.b.put(str, localObject);
          }
        }
      }
    }
  }
  
  class c
  {
    HashMap<String, String> b = new HashMap();
    a c;
    cn.dbox.core.c d;
    
    c(cn.dbox.core.c paramc, cn.dbox.core.b.n paramn)
    {
      this.d = paramc;
      a(paramc.f(), paramn);
    }
    
    c(cn.dbox.core.c paramc, a parama, cn.dbox.core.b.n paramn)
    {
      this.d = paramc;
      this.c = parama;
      a(this.b, parama.h());
      a(paramc.f(), paramn);
    }
    
    private void a(Context paramContext, cn.dbox.core.b.n paramn)
    {
      try
      {
        this.b.put("sdk", String.valueOf(31));
        if (paramn != null) {
          this.b.put("rt", String.valueOf(paramn.ordinal()));
        }
        this.b.put("v", String.format("%s-%s-%s", new Object[] { "20140918", "android", "20140711" }));
        this.b.put("sv", "000900");
        this.b.put("idv", e.h(paramContext));
        this.b.put("ua", e.f(paramContext));
        this.b.put("ipb", this.d.a());
        this.b.put("ppid", this.d.b());
        paramContext = e.y(paramContext);
        if (paramContext != null) {
          this.b.put("dma", f.a("d!j@d#g$r%s^j&h*", paramContext.toUpperCase()));
        }
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          b.b().a(paramContext);
        }
      }
    }
    
    protected void a(Map<String, String> paramMap, String paramString)
    {
      String str1 = this.d.a();
      String str2 = e.f(this.d.f());
      cn.dbox.core.h.c.a locala = cn.dbox.core.h.c.a(str1, str2, paramString);
      paramMap.put("tr", paramString);
      paramMap.put("ts", locala.a());
      paramMap.put("rnd", locala.b());
      paramMap.put("vcode", locala.c());
      paramMap.put("ipb", str1);
      paramMap.put("ua", str2);
    }
    
    protected void b(String paramString)
    {
      new b.p(b.this).a(this.d.f(), this.b, paramString);
    }
  }
  
  class d
    extends b.c
  {
    d(cn.dbox.core.c paramc, a parama)
    {
      super(paramc, parama, cn.dbox.core.b.n.e);
      this.b.put("sid", paramc.e());
      this.b.put("type", "landing");
    }
    
    public void a(cn.dbox.core.b.b paramb)
    {
      String str = "";
      switch (b.1.e[paramb.ordinal()])
      {
      default: 
        paramb = str;
      }
      for (;;)
      {
        this.b.put("phase", paramb);
        return;
        paramb = "load_success";
        continue;
        paramb = "load_failed";
        continue;
        paramb = "load_cancel";
        continue;
        paramb = "close_lp";
        continue;
        paramb = "lp_url";
      }
    }
    
    public void a(String paramString)
    {
      this.b.put("data", paramString);
    }
  }
  
  class e
    extends b.c
  {
    e(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.b);
      this.b.put("sid", paramc.e());
      a(this.b, "-1");
    }
    
    void a(cn.dbox.core.b.c paramc)
    {
      String str = "";
      switch (b.1.b[paramc.ordinal()])
      {
      }
      for (paramc = str;; paramc = "channel_entry_clk")
      {
        this.b.put("type", paramc);
        return;
      }
    }
    
    void a(String paramString)
    {
      this.b.put("chanid", paramString);
    }
  }
  
  class f
    extends b.c
  {
    f(cn.dbox.core.c paramc, a parama)
    {
      super(paramc, parama, cn.dbox.core.b.n.e);
      this.b.put("type", "ad_clk");
      this.b.put("sid", paramc.e());
    }
    
    public void a(int paramInt)
    {
      this.b.put("position", String.valueOf(paramInt));
    }
    
    public void a(cn.dbox.core.b.d paramd)
    {
      String str = "";
      switch (b.1.f[paramd.ordinal()])
      {
      default: 
        paramd = str;
      }
      for (;;)
      {
        this.b.put("element", paramd);
        return;
        paramd = "banner_ad";
        continue;
        paramd = "list_ad";
        continue;
        paramd = "listad_down";
        continue;
        paramd = "details_down";
      }
    }
    
    public void a(String paramString)
    {
      this.b.put("chanid", String.valueOf(paramString));
    }
    
    protected void b(String paramString)
    {
      b.p localp = new b.p(b.this);
      localp.a(this.d.f(), this.b, paramString);
      if ((this.c.n() != null) && (!((String)this.b.get("type")).equals("details_down"))) {
        localp.a(this.d.f(), this.b, this.c.n());
      }
    }
    
    public void c(String paramString)
    {
      this.b.put("acid", String.valueOf(paramString));
    }
  }
  
  class g
    extends b.c
  {
    g(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.d);
      this.b.put("sid", paramc.e());
      a(this.b, "-1");
    }
    
    public void a(cn.dbox.core.b.b paramb)
    {
      String str = "";
      switch (b.1.e[paramb.ordinal()])
      {
      default: 
        paramb = str;
      }
      for (;;)
      {
        this.b.put("phase", paramb);
        return;
        paramb = "load_success";
        continue;
        paramb = "load_failed";
        continue;
        paramb = "load_cancel";
        continue;
        paramb = "close_lp";
        continue;
        paramb = "lp_url";
      }
    }
    
    void a(cn.dbox.core.b.f paramf)
    {
      String str = "";
      switch (b.1.c[paramf.ordinal()])
      {
      default: 
        paramf = str;
      }
      for (;;)
      {
        this.b.put("type", paramf);
        return;
        paramf = "container_entry_clk";
        continue;
        paramf = "landing";
      }
    }
    
    void a(String paramString)
    {
      this.b.put("chanid", paramString);
    }
    
    void c(String paramString)
    {
      this.b.put("acid", paramString);
    }
    
    public void d(String paramString)
    {
      this.b.put("data", paramString);
    }
  }
  
  class h
    extends b.c
  {
    h(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.d);
      this.b.put("sid", paramc.e());
      a(this.b, "-1");
    }
    
    public void a(cn.dbox.core.b.b paramb)
    {
      String str = "";
      switch (b.1.e[paramb.ordinal()])
      {
      default: 
        paramb = str;
      }
      for (;;)
      {
        this.b.put("phase", paramb);
        return;
        paramb = "load_success";
        continue;
        paramb = "load_failed";
        continue;
        paramb = "load_cancel";
        continue;
        paramb = "close_lp";
        continue;
        paramb = "lp_url";
      }
    }
    
    void a(cn.dbox.core.b.f paramf)
    {
      String str = "";
      switch (b.1.c[paramf.ordinal()])
      {
      default: 
        paramf = str;
      }
      for (;;)
      {
        this.b.put("type", paramf);
        return;
        paramf = "container_entry_clk";
        continue;
        paramf = "landing";
      }
    }
    
    void a(String paramString)
    {
      this.b.put("chanid", paramString);
    }
    
    void c(String paramString)
    {
      this.b.put("acid", paramString);
    }
    
    public void d(String paramString)
    {
      this.b.put("data", paramString);
    }
  }
  
  class i
    extends b.c
  {
    i(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.d);
      this.b.put("sid", paramc.e());
      a(this.b, "-1");
    }
    
    void a(cn.dbox.core.b.e parame)
    {
      String str = "";
      switch (b.1.d[parame.ordinal()])
      {
      default: 
        parame = str;
      }
      for (;;)
      {
        this.b.put("action", parame);
        return;
        parame = "slide";
        continue;
        parame = "click";
      }
    }
    
    void a(cn.dbox.core.b.f paramf)
    {
      String str = "";
      switch (b.1.c[paramf.ordinal()])
      {
      default: 
        paramf = str;
      }
      for (;;)
      {
        this.b.put("type", paramf);
        return;
        paramf = "container_entry_clk";
        continue;
        paramf = "landing";
      }
    }
    
    void a(String paramString)
    {
      this.b.put("chanid", paramString);
    }
    
    void c(String paramString)
    {
      this.b.put("acid", paramString);
    }
  }
  
  class j
    extends b.c
  {
    j(cn.dbox.core.c paramc, a parama)
    {
      super(paramc, parama, cn.dbox.core.b.n.h);
      this.b.put("id", parama.i());
      this.b.put("sid", paramc.e());
    }
    
    void a(cn.dbox.core.b.g paramg)
    {
      String str = "";
      switch (b.1.g[paramg.ordinal()])
      {
      default: 
        paramg = str;
      }
      for (;;)
      {
        this.b.put("type", paramg);
        return;
        paramg = "download_start";
        continue;
        paramg = "download_repeat";
        continue;
        paramg = "download_finish";
        continue;
        paramg = "download_failed";
        continue;
        paramg = "download_cancel";
        continue;
        paramg = "install_success";
        continue;
        paramg = "run";
      }
    }
  }
  
  class k
    extends b.c
  {
    k(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.b);
      this.b.put("sid", paramc.e());
      if ((paramc.k() == null) || (paramc.k().equals(""))) {
        a(this.b, "-1");
      }
      for (;;)
      {
        return;
        a(this.b, paramc.k());
      }
    }
    
    void a(Entrance.EntryReportType paramEntryReportType)
    {
      String str = "";
      switch (b.1.a[paramEntryReportType.ordinal()])
      {
      default: 
        paramEntryReportType = str;
      }
      for (;;)
      {
        this.b.put("type", paramEntryReportType);
        return;
        paramEntryReportType = "entry_imp";
        continue;
        paramEntryReportType = "entry_clk";
        continue;
        paramEntryReportType = "presented";
      }
    }
  }
  
  class l
    extends b.c
  {
    l(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.f);
      a(this.b, "-1");
      this.b.put("sid", "");
      this.b.put("type", "start");
      this.b.put("network", e.n(paramc.f()));
      this.b.put("pb[name]", e.d(paramc.f()));
      this.b.put("pb[version]", e.c(paramc.f()));
    }
  }
  
  class m
    extends b.c
  {
    m(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.e);
      this.b.put("type", "ad_imp");
      this.b.put("sid", paramc.e());
    }
    
    void a(String paramString)
    {
      this.b.put("tr", paramString);
      a(this.b, paramString);
    }
    
    protected void b(String paramString)
    {
      new b.n(b.this, this.d.f()).a(this.b, String.valueOf(cn.dbox.core.b.n.e.ordinal()), paramString);
    }
  }
  
  class n
    implements cn.dbox.core.c.c.a
  {
    private Context b;
    private cn.dbox.core.c.c c;
    
    protected n(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public void a(cn.dbox.core.c.c paramc)
    {
      int i = paramc.f();
      b.b().b("imp repoet response: " + i);
      if (i == 200) {
        b.b().b("Imp report finish.");
      }
      for (;;)
      {
        return;
        b.b().e("onConnectionFinished:respCode=" + i);
      }
    }
    
    protected void a(HashMap<String, String> paramHashMap, String paramString1, String paramString2)
    {
      paramHashMap = f.a(paramHashMap);
      b.b().b("imp report: " + paramHashMap);
      this.c = new cn.dbox.core.c.c(this.b, paramString2, "", null, "POST", paramHashMap, 20000, this);
      this.c.run();
    }
  }
  
  class o
    extends b.c
  {
    o(cn.dbox.core.c paramc, a parama)
    {
      super(paramc, parama, cn.dbox.core.b.n.i);
      this.b.put("sid", paramc.e());
    }
    
    public void a(cn.dbox.core.b.i parami)
    {
      String str = "";
      switch (b.1.h[parami.ordinal()])
      {
      default: 
        parami = str;
      }
      for (;;)
      {
        this.b.put("type", parami);
        return;
        parami = "la_success";
        continue;
        parami = "la_failed";
        continue;
        parami = "la_failsafe_success";
        continue;
        parami = "la_failsafe_failed";
      }
    }
    
    public void a(String paramString)
    {
      if (paramString != null) {
        this.b.put("failsafe", paramString);
      }
    }
  }
  
  class p
    implements cn.dbox.core.c.c.a
  {
    p() {}
    
    protected void a(Context paramContext, HashMap<String, String> paramHashMap, String paramString)
    {
      b.b().b("report type: " + (String)paramHashMap.get("type"));
      b.b().b("report params: " + paramHashMap.toString());
      paramContext = new cn.dbox.core.c.c(paramContext, paramString, "", null, "POST", f.a(paramHashMap), 20000, this);
      paramContext.a((String)paramHashMap.get("type"));
      paramContext.b();
    }
    
    public void a(cn.dbox.core.c.c paramc)
    {
      int i = paramc.f();
      b.b().b("report response: " + i);
      if (i == 200) {
        b.b().b("Report " + paramc.a() + " finish.");
      }
      for (;;)
      {
        return;
        b.b().b("onConnectionFinished:respCode = " + i);
      }
    }
  }
  
  class q
    extends b.c
  {
    q(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.j);
      a(this.b, "-1");
    }
    
    void a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.b.put("d_info", f.a("d!j@d#g$r%s^j&h*", paramString));
      }
    }
  }
  
  class r
    extends b.c
  {
    r(cn.dbox.core.c paramc)
    {
      super(paramc, cn.dbox.core.b.n.f);
      this.b.put("sid", paramc.e());
    }
    
    public void a(cn.dbox.core.b.o paramo)
    {
      String str = "";
      switch (b.1.i[paramo.ordinal()])
      {
      default: 
        paramo = str;
      }
      for (;;)
      {
        this.b.put("type", paramo);
        return;
        paramo = "setting_entry_clk";
        continue;
        paramo = "about_clk";
        continue;
        paramo = "feedback_submit";
        continue;
        paramo = "contact_clk";
      }
    }
    
    public void a(String paramString)
    {
      if (paramString != null) {
        this.b.put("message", paramString);
      }
    }
    
    public void c(String paramString)
    {
      if (paramString != null) {
        this.b.put("contact", paramString);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */