package cn.domob.wall.core.f;

import android.content.Context;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.DService.ReportDownLoadType;
import cn.domob.wall.core.DService.ReportUserActionType;
import cn.domob.wall.core.b.a;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.e;
import cn.domob.wall.core.h.f;
import java.util.HashMap;
import java.util.Map;

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
        localb = new cn/domob/wall/core/f/b;
        localb.<init>();
        a = localb;
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  class a
  {
    HashMap<String, String> a = new HashMap();
    AdInfo b;
    cn.domob.wall.core.b c;
    
    a(cn.domob.wall.core.b paramb, AdInfo paramAdInfo, b.n paramn)
    {
      this.c = paramb;
      this.b = paramAdInfo;
      this.a.put("sid", paramAdInfo.getSearchId());
      this.a.put("id", paramAdInfo.getAdId());
      a(this.a, paramAdInfo.getAdTracker());
      a(paramb.g(), paramn);
    }
    
    a(cn.domob.wall.core.b paramb, b.n paramn)
    {
      this.c = paramb;
      a(paramb.g(), paramn);
    }
    
    private void a(Context paramContext, b.n paramn)
    {
      try
      {
        this.a.put("sdk", String.valueOf(30));
        this.a.put("rt", String.valueOf(paramn.ordinal()));
        this.a.put("v", String.format("%s-%s-%s", new Object[] { "20140217", "android", "20131101" }));
        this.a.put("sv", "020100");
        this.a.put("idv", e.h(paramContext));
        this.a.put("ua", e.f(paramContext));
        this.a.put("ipb", this.c.d());
        this.a.put("ppid", this.c.e());
        paramContext = e.y(paramContext);
        if (paramContext != null) {
          this.a.put("dma", f.a("d!j@d#g$r%s^j&h*", paramContext.toUpperCase()));
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
    
    protected void a()
    {
      b.l locall = new b.l(b.this);
      if (DService.getEndpoint().equals("online")) {
        locall.a(this.c.g(), this.a, f.f(a.j));
      }
      for (;;)
      {
        return;
        locall.a(this.c.g(), this.a, f.f(a.n));
      }
    }
    
    protected void a(Map<String, String> paramMap, String paramString)
    {
      String str2 = this.c.d();
      String str1 = e.f(this.c.g());
      cn.domob.wall.core.h.c.a locala = cn.domob.wall.core.h.c.a(str2, str1, paramString);
      paramMap.put("tr", paramString);
      paramMap.put("ts", locala.a());
      paramMap.put("rnd", locala.b());
      paramMap.put("vcode", locala.c());
      paramMap.put("ipb", str2);
      paramMap.put("ua", str1);
    }
  }
  
  class b
    extends b.a
  {
    b(cn.domob.wall.core.b paramb, AdInfo paramAdInfo)
    {
      super(paramb, paramAdInfo, b.n.c);
    }
    
    public void a(b.j paramj)
    {
      String str = "";
      switch (b.1.c[paramj.ordinal()])
      {
      default: 
        paramj = str;
      }
      for (;;)
      {
        this.a.put("type", paramj);
        return;
        paramj = "load_success";
        continue;
        paramj = "load_failed";
        continue;
        paramj = "load_cancel";
        continue;
        paramj = "close_lp";
        continue;
        paramj = "lp_url";
      }
    }
  }
  
  class c
    extends b.a
  {
    c(cn.domob.wall.core.b paramb, AdInfo paramAdInfo)
    {
      super(paramb, paramAdInfo, b.n.d);
    }
    
    protected void a()
    {
      b.l locall = new b.l(b.this);
      if (DService.getEndpoint().equals("online")) {
        locall.a(this.c.g(), this.a, f.f(a.k));
      }
      for (;;)
      {
        if ((this.b.getClickTrackerUrl() != null) && (!((String)this.a.get("type")).equals("details_down"))) {
          locall.a(this.c.g(), this.a, this.b.getClickTrackerUrl());
        }
        return;
        locall.a(this.c.g(), this.a, f.f(a.o));
      }
    }
    
    public void a(int paramInt)
    {
      this.a.put("order", String.valueOf(paramInt));
    }
    
    public void a(b.k paramk)
    {
      String str = "";
      switch (b.1.e[paramk.ordinal()])
      {
      default: 
        paramk = str;
      }
      for (;;)
      {
        this.a.put("type", paramk);
        return;
        paramk = "banner_ad";
        continue;
        paramk = "list_ad";
        continue;
        paramk = "listad_down";
        continue;
        paramk = "details_down";
      }
    }
    
    public void b(int paramInt)
    {
      this.a.put("posit", String.valueOf(paramInt));
    }
  }
  
  class d
    extends b.a
  {
    d(cn.domob.wall.core.b paramb, AdInfo paramAdInfo)
    {
      super(paramb, paramAdInfo, b.n.b);
      this.a.put("vc", String.valueOf(paramAdInfo.getAdVersionCode()));
      this.a.put("vn", String.valueOf(paramAdInfo.getAdVersionName()));
      this.a.put("pkg", paramAdInfo.getAdPackageName());
      this.a.put("id", paramAdInfo.getAdId());
    }
    
    void a(DService.ReportDownLoadType paramReportDownLoadType)
    {
      String str = "";
      switch (b.1.b[paramReportDownLoadType.ordinal()])
      {
      default: 
        paramReportDownLoadType = str;
      }
      for (;;)
      {
        this.a.put("type", paramReportDownLoadType);
        return;
        paramReportDownLoadType = "download_start";
        continue;
        paramReportDownLoadType = "download_repeat";
        continue;
        paramReportDownLoadType = "download_finish";
        continue;
        paramReportDownLoadType = "download_failed";
        continue;
        paramReportDownLoadType = "download_cancel";
        continue;
        paramReportDownLoadType = "install_success";
        continue;
        paramReportDownLoadType = "run";
      }
    }
  }
  
  class e
    extends b.a
  {
    e(cn.domob.wall.core.b paramb)
    {
      super(paramb, b.n.h);
      this.a.put("sid", paramb.f());
      if (paramb.i() != null)
      {
        this.a.put("id", paramb.i().getmId());
        a(this.a, paramb.i().getmTr());
      }
    }
    
    void a(DService.EWallReportType paramEWallReportType)
    {
      String str = "";
      switch (b.1.f[paramEWallReportType.ordinal()])
      {
      default: 
        paramEWallReportType = str;
      }
      for (;;)
      {
        this.a.put("type", paramEWallReportType);
        return;
        paramEWallReportType = "e_entry_show";
        continue;
        paramEWallReportType = "e_entry_click";
        continue;
        paramEWallReportType = "e_page_req";
        continue;
        paramEWallReportType = "e_page_show";
        continue;
        paramEWallReportType = "e_page_click";
      }
    }
    
    public void a(String paramString)
    {
      if (paramString != null) {
        this.a.put("e_page_url", paramString);
      }
    }
  }
  
  protected class f
  {
    protected static final String A = "e_page_show";
    protected static final String B = "e_page_click";
    protected static final String a = "load_success";
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
    
    protected f() {}
  }
  
  class g
    extends b.a
  {
    g(cn.domob.wall.core.b paramb)
    {
      super(paramb, b.n.e);
    }
    
    protected void a()
    {
      b.h localh = new b.h(b.this, this.c.g());
      if (DService.getEndpoint().equals("online")) {
        localh.a(this.a, String.valueOf(b.n.e.ordinal()), f.f(a.l));
      }
      for (;;)
      {
        return;
        localh.a(this.a, String.valueOf(b.n.e.ordinal()), f.f(a.p));
      }
    }
    
    void a(String paramString)
    {
      this.a.put("tr", paramString);
      a(this.a, paramString);
    }
    
    void b(String paramString)
    {
      this.a.put("sid", paramString);
    }
  }
  
  class h
    implements cn.domob.wall.core.c.c.a
  {
    private Context b;
    private cn.domob.wall.core.c.c c;
    
    protected h(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public void a(cn.domob.wall.core.c.c paramc)
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
      this.c = new cn.domob.wall.core.c.c(this.b, paramString2, "", null, "POST", paramHashMap, 20000, this);
      this.c.run();
    }
  }
  
  class i
    extends b.a
  {
    i(cn.domob.wall.core.b paramb, AdInfo paramAdInfo)
    {
      super(paramb, paramAdInfo, b.n.g);
    }
    
    public void a(b.m paramm)
    {
      String str = "";
      switch (b.1.d[paramm.ordinal()])
      {
      default: 
        paramm = str;
      }
      for (;;)
      {
        this.a.put("type", paramm);
        return;
        paramm = "la_success";
        continue;
        paramm = "la_failed";
        continue;
        paramm = "la_failsafe_success";
        continue;
        paramm = "la_failsafe_failed";
      }
    }
    
    public void a(String paramString)
    {
      if (paramString != null) {
        this.a.put("failsafe", paramString);
      }
    }
  }
  
  public static enum j
  {
    private j() {}
  }
  
  public static enum k
  {
    private k() {}
  }
  
  class l
    implements cn.domob.wall.core.c.c.a
  {
    l() {}
    
    protected void a(Context paramContext, HashMap<String, String> paramHashMap, String paramString)
    {
      b.b().b("report type: " + (String)paramHashMap.get("type"));
      b.b().b("report params: " + paramHashMap.toString());
      paramContext = new cn.domob.wall.core.c.c(paramContext, paramString, "", null, "POST", f.a(paramHashMap), 20000, this);
      paramContext.a((String)paramHashMap.get("type"));
      paramContext.b();
    }
    
    public void a(cn.domob.wall.core.c.c paramc)
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
  
  public static enum m
  {
    private m() {}
  }
  
  public static enum n
  {
    private n() {}
  }
  
  class o
    extends b.a
  {
    o(cn.domob.wall.core.b paramb)
    {
      super(paramb, b.n.f);
      this.a.put("sid", paramb.f());
      a(this.a, "-1");
    }
    
    void a(DService.ReportUserActionType paramReportUserActionType)
    {
      String str = "";
      switch (b.1.a[paramReportUserActionType.ordinal()])
      {
      default: 
        paramReportUserActionType = str;
      }
      for (;;)
      {
        this.a.put("type", paramReportUserActionType);
        return;
        paramReportUserActionType = "entry";
        continue;
        paramReportUserActionType = "exit";
        continue;
        paramReportUserActionType = "pgdn";
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */