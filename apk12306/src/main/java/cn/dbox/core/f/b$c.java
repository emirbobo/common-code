package cn.dbox.core.f;

import android.content.Context;
import cn.dbox.core.b.n;
import cn.dbox.core.bean.a;
import cn.dbox.core.h.c.a;
import cn.dbox.core.h.d;
import cn.dbox.core.h.e;
import cn.dbox.core.h.f;
import java.util.HashMap;
import java.util.Map;

class b$c
{
  HashMap<String, String> b = new HashMap();
  a c;
  cn.dbox.core.c d;
  
  b$c(b paramb, cn.dbox.core.c paramc, b.n paramn)
  {
    this.d = paramc;
    a(paramc.f(), paramn);
  }
  
  b$c(b paramb, cn.dbox.core.c paramc, a parama, b.n paramn)
  {
    this.d = paramc;
    this.c = parama;
    a(this.b, parama.h());
    a(paramc.f(), paramn);
  }
  
  private void a(Context paramContext, b.n paramn)
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
    c.a locala = cn.dbox.core.h.c.a(str1, str2, paramString);
    paramMap.put("tr", paramString);
    paramMap.put("ts", locala.a());
    paramMap.put("rnd", locala.b());
    paramMap.put("vcode", locala.c());
    paramMap.put("ipb", str1);
    paramMap.put("ua", str2);
  }
  
  protected void b(String paramString)
  {
    new b.p(this.e).a(this.d.f(), this.b, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */