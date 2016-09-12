package cn.domob.wall.core.f;

import android.content.Context;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.b.a;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.c;
import cn.domob.wall.core.h.c.a;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.e;
import cn.domob.wall.core.h.f;
import java.util.HashMap;
import java.util.Map;

class b$a
{
  HashMap<String, String> a = new HashMap();
  AdInfo b;
  cn.domob.wall.core.b c;
  
  b$a(b paramb, cn.domob.wall.core.b paramb1, AdInfo paramAdInfo, b.n paramn)
  {
    this.c = paramb1;
    this.b = paramAdInfo;
    this.a.put("sid", paramAdInfo.getSearchId());
    this.a.put("id", paramAdInfo.getAdId());
    a(this.a, paramAdInfo.getAdTracker());
    a(paramb1.g(), paramn);
  }
  
  b$a(b paramb, cn.domob.wall.core.b paramb1, b.n paramn)
  {
    this.c = paramb1;
    a(paramb1.g(), paramn);
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
    b.l locall = new b.l(this.d);
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
    c.a locala = c.a(str2, str1, paramString);
    paramMap.put("tr", paramString);
    paramMap.put("ts", locala.a());
    paramMap.put("rnd", locala.b());
    paramMap.put("vcode", locala.c());
    paramMap.put("ipb", str2);
    paramMap.put("ua", str1);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */