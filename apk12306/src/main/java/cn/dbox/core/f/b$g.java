package cn.dbox.core.f;

import cn.dbox.core.b.b;
import cn.dbox.core.b.f;
import cn.dbox.core.b.n;
import cn.dbox.core.c;
import java.util.HashMap;

class b$g
  extends b.c
{
  b$g(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.d);
    this.b.put("sid", paramc.e());
    a(this.b, "-1");
  }
  
  public void a(b.b paramb)
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
  
  void a(b.f paramf)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */